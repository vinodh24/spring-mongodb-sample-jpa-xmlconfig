package com.vinodh.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.WriteResult;
import com.vinodh.model.Common;
import com.vinodh.model.Employe;
import com.vinodh.repository.CommonRepository;
import com.vinodh.repository.EmployeeRepository;
public class CurdService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private CommonRepository commonRepository;

	@Autowired
	private EmployeeRepository employeeRepository;


	public void save(Common Common) {
		Common common2=commonRepository.save(Common);
		System.out.println(commonRepository+"   Common   :::"+common2);
	}

	public void findByStartDateBetween(String from, String to) throws ParseException{
		Query query = new Query();
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Criteria c = new Criteria().andOperator(
				Criteria.where("startDate").gte(inputFormat.parseObject(from)),  
				Criteria.where("startDate").lte(inputFormat.parseObject(to)));
		query.addCriteria(c);
		//query.addCriteria(Criteria.where("startDate").gte(inputFormat.parseObject(from)).lte(inputFormat.parseObject(to)));
		System.out.println("Criteria result");
		mongoTemplate.find(query, Common.class).forEach(System.out::println);
		System.out.println("normal date format");
		commonRepository.findByStartDateBetween(inputFormat.parseObject(from), inputFormat.parseObject(to)).forEach(System.out::println);
		System.out.println("local Date list");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd") ;
		LocalDate fromLocalDate = LocalDate.parse( from , dateTimeFormatter);
		LocalDate toLocalDate = LocalDate.parse( to , dateTimeFormatter) ;
		commonRepository.findByStartDateBetween(fromLocalDate,toLocalDate).forEach(System.out::println);
	}

	public void saveEmpoye(Employe employe) {
		Employe employe1=employeeRepository.insert(employe);
		System.out.println(employe1);
		Employe employe2=employeeRepository.insert(employe1);
		System.out.println(employe2);
	}

	public List<Employe> findByEmpoyeeId(String empoyeeId){
		//employeeRepository.findByNameAndSalary("vinodh", "1000").forEach(System.out::println);
		employeeRepository.findByName1("kadhir",new PageRequest(0, 10)).forEach(System.out::println);
		//employeeRepository.deleteByName("vinodh");
		return employeeRepository.findByEmpoyeeId(empoyeeId);

	}

	public void findByName(String name){
		Query query = new Query();
		Criteria c = new Criteria().andOperator(
				Criteria.where("name").is(name)
				);
		query.addCriteria(c);
		query.with(new Sort(Sort.Direction.ASC,"name"));  //sorting asc
		mongoTemplate.find(query,Employe.class).forEach(System.out::println);
		query.with((new PageRequest(0, 10)));// pagination
		//  query.addCriteria(c).limit(3);  //limit condition
	}

	public WriteResult deleteByName(String name) {
		Query query = new Query();
		Criteria c = new Criteria().andOperator(
				Criteria.where("name").is(name)
				);

		query.addCriteria(c);
		WriteResult detailes = mongoTemplate.remove(query, Employe.class);
		System.out.println(detailes.getN());
		return detailes;	  	
	}

	public void findByCommonPortName(){
		//employeeRepository.findByCommonPortName("1-1-1").forEach(System.out::println);
		Query query = new Query();
		Criteria c = new Criteria().andOperator(
				Criteria.where("common.portName").is("1-1-1")
				);
		query.with(new Sort(new Order(Direction.ASC, "name")));   
		query.addCriteria(c);
		mongoTemplate.find(query,Employe.class).forEach(System.out::println);
	}

}
