package com.springboot.EDT.EDRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.EDT.Entity.Department;
@Repository
public interface DeptRepository extends JpaRepository<Department, Long>
{

}
