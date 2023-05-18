package com.springboot.EDT.service;

import java.util.List;

import com.springboot.EDT.Entity.Employee;

public interface employeeService 
{
	Employee saveEmployee(Employee employee);
	 Employee findByEid(Long eid);
	 List<Employee> getAllEmployee();
	 List<Employee> getAllByDnDt(long dno);
	 List<Employee> getAllByMgr(Long mgrno);
	 
}
