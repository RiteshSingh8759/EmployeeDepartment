package com.springboot.EDT.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.EDT.EDRepository.DeptRepository;
import com.springboot.EDT.EDRepository.EmpRepository;
import com.springboot.EDT.Entity.Department;
import com.springboot.EDT.Entity.Employee;
import com.springboot.EDT.service.serviceImpl.EmpDeptService;
@SpringBootTest
public class EmpServiceTest {
	
	@Autowired
	private EmpRepository empRepo;
	
	@Autowired
	private DeptRepository deptRepo;
	
	@Autowired
	private EmpDeptService eservice;
	
	@Test
	void getEmployeeById() {
		//empRepo = Mockito.mock(EmpRepository.class);
//		Employee expectedEmployee = new Employee();
//		expectedEmployee.setEid(4l);
//		expectedEmployee.setEname("siya");
//		expectedEmployee.setMgrname("rahul");
//		expectedEmployee.setDeptno(3l);
//		expectedEmployee.setMgrno(2l);
		
//		when(empRepo.findById(4l)).thenReturn(Optional.of(expectedEmployee));
//		EmpDeptService eservice = new EmpDeptService(empRepo, null);
	   Employee actualEmployee=eservice.findByEid(4l);
	   System.out.println(eservice.findByEid(4l).toString());
		Employee expectedEmployee=empRepo.findById(4l).get();	
		System.out.println(empRepo.findById(4l).toString());
	
		assertEquals(expectedEmployee,actualEmployee);
	}
	
	@Test
	void getDepartmentByDepytNo() {
		
		Department actualdept =eservice.findByDeptno(2l);
		System.out.println(eservice.findByDeptno(2).toString());
		
		Department expected = deptRepo.findById(2l).get();
		System.out.println(deptRepo.findById(2l).toString());
		assertEquals(actualdept, expected);
		
		
	}
	
	@Test
	void getAllDeptNo() {
		
		List<Department> departments = eservice.getAllDepartment();
		System.out.println(departments);
		
		List<Department> expected =deptRepo.findAll();
		assertEquals(departments, expected);
	}
	
	
	@Test
	 void getAllEmployee() {
		List<Employee> actualEmp =eservice.getAllEmployee();
		System.out.println(actualEmp);
		List<Employee> expected =empRepo.findAll();
		System.out.println(expected);
		assertEquals(actualEmp,expected);
	}
	
//	@Test
//	void deleteByDeptNo() {
////	eservice.deleteByDeptno(3l);
////		verify(deptRepo).deleteById(3l);	
//		assertEquals(eservice.deleteByDeptno(3l),deptRepo.deleteById(3l));
//	}
	
	void saveDept() {
		Department dept = new Department();
		dept.setDeptno(8l);
		dept.setDloc("Raipur");
		dept.setDname("Industrial");
		deptRepo.save(dept);
		
	Department act =	eservice.findByDeptno(8l);
	       Department exp=deptRepo.findById(8l).get();
	       assertEquals(act, exp);
	}
	
}
