package com.vinodh.repository;

import java.time.LocalDate;
import java.util.List;

import com.vinodh.model.Common;

public interface CommonRepository extends GenericDAO<Common>{
	
	List<Common> findByStartDateBetween(Object from,Object to);
	
	List<Common> findByStartDateBetween(LocalDate from,LocalDate to);
	

}
