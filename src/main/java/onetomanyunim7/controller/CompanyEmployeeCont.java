package onetomanyunim7.controller;

import onetomanyunim7.dao.CompanyDao;
import onetomanyunim7.dao.EmployeeDao;
import onetomanyunim7.dto.Company;
import onetomanyunim7.dto.Employee;

public class CompanyEmployeeCont {
public static void main(String[] args) {
//	Company company=new Company();
//	company.setId(1);
//	company.setName("TY");
//	company.setGst("ty@123");
//	
//	CompanyDao companyDao=new CompanyDao();
//	companyDao.saveCompany(company);
	
	Employee employee1=new Employee();
	employee1.setId(2);
	employee1.setName("bhuvan");
	employee1.setAddress("tN");
	
	EmployeeDao dao=new EmployeeDao();
	dao.saveEmployee(1, employee1);
	
	
	
	
	
	
	
	
	
}
}
