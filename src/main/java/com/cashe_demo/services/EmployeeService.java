package com.cashe_demo.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.cashe_demo.entities.Employee;
import com.cashe_demo.repositories.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo repo;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Cacheable(value = "emp")
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@CachePut(key = "#emp.empId", value = "emp")
	@CacheEvict(value = "emp", allEntries = true)
	public Employee saveEmployee(Employee emp) {
		return repo.save(emp);
	}

	@Cacheable(key = "#eid", value = "emp")
	public Employee getById(int eid) {
		return repo.findById(eid).orElse(null);
	}

	public void showAllKeys() {
		Set<String> keys = redisTemplate.keys("emp::*");
		if (keys != null && !keys.isEmpty()) {
			keys.forEach(key -> {
				Object value = redisTemplate.opsForValue().get(key);
				System.out.println("Key: " + key + ", Value: " + value);
			});
		} else {
			System.out.println("No keys found for pattern 'emp::*'");
		}
	}

}
