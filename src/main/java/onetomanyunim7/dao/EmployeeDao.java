package onetomanyunim7.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanyunim7.dto.Company;
import onetomanyunim7.dto.Employee;

public class EmployeeDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	public void saveEmployee(int companyId,Employee employee) {
		EntityManager entityManager=getEntityManager();
//		while saving the employee you need to check that company is present or not
		Company dbCompany=entityManager.find(Company.class, companyId);
		if(dbCompany!=null) {
//			that company is present then i can save the data
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(employee);
//			you want to update company details also
//			im taking the employees details which is present in thus company
			List<Employee> employees=dbCompany.getEmployees();
//			employees =old employees means employees whoch is already present
//			to the same list im going to add the next employee
			employees.add(employee);
//			reset this list of employees to the company
			dbCompany.setEmployees(employees);
			
			entityTransaction.commit();
			
		}else {
			System.out.println("Sorry that company id is not present");
		}
		
	}
	
	
	public void updateEmployee(int id,Employee employee) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, id);
		if(dbEmployee!=null) {
//			that id is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			employee.setId(id);
			entityManager.merge(employee);
			entityTransaction.commit();
			
		}else {
			System.out.println("Sorry that id is not present");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
