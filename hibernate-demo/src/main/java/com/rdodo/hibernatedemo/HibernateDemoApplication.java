package com.rdodo.hibernatedemo;

import com.rdodo.hibernatedemo.model.Employee;
import com.rdodo.hibernatedemo.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateDemoApplication {

	public static void main(String[] args) {
		Employee jhon = (new Employee()).setName("Jhon Dsouza").setDepartment("Human Resource").setSalary(34000);
		Employee hina = (new Employee()).setName("Hina Kim").setDepartment("Quality Assurance").setSalary(40000);
		Employee nina = (new Employee()).setName("Nina Williams").setDepartment("Delivery").setSalary(84000);

		/*saveEmployee(jhon);
		saveEmployee(hina);
		saveEmployee(nina);*/
		//deleteEmployee(2);
		updateEmployee(3);
		HibernateUtil.closeSessionFactory();
	}


	private static void saveEmployee (Employee employee) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		session.persist(employee);

		transaction.commit();
		session.close();
	}

	private static Employee getEmployee(int id) {
		Session session = HibernateUtil.getSession();
		Employee employee = session.get(Employee.class, id);
		session.close();
		return employee;
	}

	private static void deleteEmployee(int id) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		// 1st way
		Employee employee = new Employee();
		employee.setId(id);

		// 2nd fetch employee from database and than delete
		session.delete(employee);
		transaction.commit();
		session.close();
	}

	private static void updateEmployee(int id) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		Employee employee = getEmployee(id);
		employee.setName("Seena Sam").setSalary(20000);

		session.update(employee);

		transaction.commit();
		session.close();
	}
}
