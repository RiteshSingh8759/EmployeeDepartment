package com.springboot.EDT.service.serviceImpl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.EDT.EDRepository.DeptRepository;
import com.springboot.EDT.EDRepository.EmpRepository;
import com.springboot.EDT.Entity.Employee;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EmployeeTest {
	@Mock
	private EmpRepository empRepo;
	@Mock
	private DeptRepository deptRepo;
	
	private EmpDeptService empDeptImpl;
	
	@BeforeEach
	void setUp() {
		this.empDeptImpl = new EmpDeptService(empRepo, deptRepo);
		
	}
	@Test
	void getEmployeeById() {
		Optional<Employee> employee=Optional.of((new Employee()));
		System.out.println(employee.toString());
		when(empRepo.findById(4l)).thenReturn(employee);
		empDeptImpl.findByEid(4l);
		verify(empRepo).findById(4l);
	}
	
	@Test
	 void getAllEmployee() {
		empDeptImpl.getAllEmployee();
		verify(empRepo).findAll();
	}
	
	@Test
	void getAllDeptNo() {
		empDeptImpl.getAllDepartment();
		verify(deptRepo).findAll();
	}
	
	
}
