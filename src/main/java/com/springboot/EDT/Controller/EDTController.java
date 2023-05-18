package com.springboot.EDT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.EDT.EDRepository.DeptRepository;
import com.springboot.EDT.EDRepository.EmpRepository;
import com.springboot.EDT.Entity.*;
import com.springboot.EDT.service.departmentService;
import com.springboot.EDT.service.employeeService;
import com.springboot.EDT.service.serviceImpl.EmpDeptService;

@RestController
@RequestMapping("/api")
public class EDTController 
{
	
	private employeeService eService;
	private departmentService dService;
	public EDTController(employeeService eService, departmentService dService) {
		super();
		this.eService = eService;
		this.dService = dService;
	}
	@PostMapping("/postD")
	public ResponseEntity<Department> saveDepartment(@RequestBody Department Dept)
	{
		return new ResponseEntity<Department>(dService.saveDepartment(Dept), HttpStatus.CREATED);
		
	}
	@GetMapping("/lod")
	public ResponseEntity<List<Department>> getAllDepartment()
	{
		return new ResponseEntity<List<Department>>(dService.getAllDepartment(),HttpStatus.OK);
	}
	@GetMapping("{Did}")
	public ResponseEntity<Department> findByDeptno(@PathVariable("Did") long deptno)
	{
		return new ResponseEntity<Department>(dService.findByDeptno(deptno),HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public void deleteByDeptno(@PathVariable("id") long deptno)
	{
		dService.deleteByDeptno(deptno);
	}
	@PutMapping("{Did}")
	public ResponseEntity<Department> updateDepartment(@RequestBody Department dept,@PathVariable("Did") long deptno) 
	{
		return new ResponseEntity<Department>(dService.updateDept(dept, deptno),HttpStatus.OK);
	}
	
	@PostMapping("/postE")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(eService.saveEmployee(employee),HttpStatus.OK);
	}
	@GetMapping("{Eid}")
	public ResponseEntity<Employee> findByEid(@PathVariable("Eid") long id)
	{
		return new ResponseEntity<Employee>(eService.findByEid(id),HttpStatus.OK);
	}
	@GetMapping("/loe")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		return new ResponseEntity<List<Employee>>(eService.getAllEmployee(),HttpStatus.OK);
	}
	@GetMapping("/gbdodt/{dno}")
	public ResponseEntity<List<Employee>> getAllByDnDt(@PathVariable("dno") long dno)
	{
		return new ResponseEntity<List<Employee>>(eService.getAllByDnDt(dno),HttpStatus.OK);
	}
	@GetMapping("mgno/{mgrno}")
	public ResponseEntity<List<Employee>> getAllByMgr(@PathVariable("mgrno") long mgrno)
	{
		return new ResponseEntity<List<Employee>>(eService.getAllByMgr(mgrno),HttpStatus.OK);
	}
}
