package com.springboot.EDT.service;

import java.util.List;

import com.springboot.EDT.Entity.Department;

public interface departmentService 
{
	Department saveDepartment(Department Dept);
	List<Department> getAllDepartment();
	Department findByDeptno(long deptno);
	void deleteByDeptno(long deptno);
	Department updateDept(Department dept,long deptno);
}
