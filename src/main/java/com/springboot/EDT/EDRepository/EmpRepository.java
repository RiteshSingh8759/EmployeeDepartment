package com.springboot.EDT.EDRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.EDT.Entity.Employee;
@Repository
public interface EmpRepository extends JpaRepository<Employee,Long>
{
	
}
