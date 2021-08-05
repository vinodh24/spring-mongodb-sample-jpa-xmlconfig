package com.vinodh.common.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vinodh.service.CurdService;

public class EmployeeTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("mongodb-context.xml");
		CurdService curdOperation = (CurdService) context.getBean("DaoOperations");
//		Employe employe=new Employe();
//		employe.setName("tejesh");
//		employe.setSalary("1000");
//		Common common=new Common();
//		common.setPortName("1-1-1");
//		common.setTechnology("ADSL");
//		common.setSubscriberId("123232323");
//		employe.setCommon(common);
//		curdOperation.saveEmpoye(employe);
		//List<Employe> employes=curdOperation.findByEmpoyeeId("5fae36e9684e33b375a652dc");
		//curdOperation.findByName("vinodh");
		// System.out.println(employes);
       // curdOperation.deleteByName("vinodh");
		curdOperation.findByCommonPortName();
	}

}
