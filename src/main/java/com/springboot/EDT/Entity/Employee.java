package com.springboot.EDT.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "eid")
    private Long eid;

    @Column(name = "ename")
    private String ename;

    @Column(name = "mgrno")
    private Long mgrno;

    @Column(name = "mgrname")
    private String mgrname;

    @Column(name = "deptno")
    private Long deptno;
	
	

	

    
}
