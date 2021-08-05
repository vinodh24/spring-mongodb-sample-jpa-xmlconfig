package com.vinodh.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;

import com.vinodh.model.Employe;
import com.vinodh.repository.GenericDAO;

public interface EmployeeRepository extends GenericDAO<Employe> {
	
	List<Employe> findByEmpoyeeId(String empoyeeId);
	
	List<Employe> findByName(String name);
	
	List<Employe> findByNameAndSalary(String name,String salary);
	
	@Query("{ 'name' : ?0 }")
	List<Employe> findByName1(String name, PageRequest pageRequest);
	
    Long deleteByName(String name);
    
    List<Employe> findByCommonPortName(String portName,Sort sort);
    

}
