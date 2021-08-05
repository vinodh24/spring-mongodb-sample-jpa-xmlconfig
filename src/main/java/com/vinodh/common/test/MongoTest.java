package com.vinodh.common.test;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vinodh.model.Common;
import com.vinodh.service.CurdService;

public class MongoTest {

	public static void main(String args[]) {

		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("mongodb-context.xml");
		CurdService curdOperation = (CurdService) context.getBean("DaoOperations");
		System.out.println("mongoOps::::::::" + curdOperation);
		Common common = new Common();
		common.setPortName("vinodh prot name");
		common.setStartDate(new Date());
		common.setSubscriberId("vinodh12345");
		common.setTechnology("microservices");
		try {
			//curdOperation.save(common);
			curdOperation.findByStartDateBetween("2020-11-15", "2020-11-20");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
