package com.springboot.EDT.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springboot.EDT.EDRepository.DeptRepository;
import com.springboot.EDT.EDRepository.EmpRepository;
import com.springboot.EDT.service.departmentService;
import com.springboot.EDT.service.employeeService;
import com.springboot.EDT.Entity.Department;
import com.springboot.EDT.Entity.Employee;
import com.springboot.EDT.Exception1.DataNotFoundException;
@Service
public class EmpDeptService implements departmentService,employeeService
{
	private EmpRepository empRepository;
	private DeptRepository deptRepository;
	public EmpDeptService(EmpRepository empRepository, DeptRepository deptRepository) {
		super();
		this.empRepository = empRepository;
		this.deptRepository = deptRepository;
	}
	@Override
	public Department saveDepartment(Department Dept) {
		
		return deptRepository.save(Dept);
	}
	@Override
	public Employee findByEid(Long eid) {
		
		return empRepository.findById(eid).orElseThrow(()->new DataNotFoundException("Employee", "eid", eid));
	}
	@Override
	public List<Employee> getAllEmployee() {
		return empRepository.findAll();
	}
	@Override
	public Employee saveEmployee(Employee employee) {
		if(deptRepository.existsById(employee.getDeptno())&& empRepository.existsById(employee.getMgrno())) 
		{
		    return empRepository.save(employee);
		}
		else {
			throw new DataNotFoundException("employee","deptno", employee.getDeptno());
		}
	}
	@Override
	public List<Department> getAllDepartment() {
		
		return deptRepository.findAll();
	}
	@Override
	public Department findByDeptno(long deptno) {
		return deptRepository.findById(deptno).orElseThrow(()->new DataNotFoundException("Department", "Id", deptno));
	}
	@Override
	public void deleteByDeptno(long deptno) {
		deptRepository.findById(deptno).orElseThrow(()->new DataNotFoundException("Department", "Id", deptno));
		if(!(empRepository.findAll().stream().map(i->i.getDeptno()).collect(Collectors.toList()).contains(deptno)))
		{
			deptRepository.deleteById(deptno);
		}	
	}
	@Override
	public Department updateDept(Department dept, long deptno) {
		
		Department existingDept=deptRepository.findById(deptno).orElseThrow(()->new DataNotFoundException("Department", "Id", deptno));
		existingDept.setDloc(dept.getDloc());
		existingDept.setDname(dept.getDname());
		deptRepository.save(existingDept);
		return existingDept;
	}
	@Override
	public List<Employee> getAllByDnDt(long dno) {
		
		deptRepository.findById(dno).orElseThrow(()->new DataNotFoundException("Department", "Id", dno));
		return empRepository.findAll().stream().filter(i->i.getDeptno()==dno).collect(Collectors.toList());
	}
	@Override
	public List<Employee> getAllByMgr(Long mgrno) {
		List<Employee> li=empRepository.findAll().stream().filter(i->i.getMgrno()==mgrno).collect(Collectors.toList());
		if(li.isEmpty()) {
			throw new DataNotFoundException("Employee", "mgrno", mgrno);
		}
		return li;
	}
	
	
}
