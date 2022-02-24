package com.rdodo.demo.hql;

import com.rdodo.demo.hql.model.Employee;
import com.rdodo.demo.hql.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MainEmployee {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        // Getting all objects
        /*Query<Employee> query = session.createQuery("FROM Employee");
        for (Employee employee : query.getResultList()) {
            System.out.println(employee.toString());
        }*/


        // Getting partial object
        /*Query<Object[]> query = session.createQuery("SELECT name, department FROM Employee WHERE department=:department AND salary>:salary");
        query.setParameter("department", "HR");
        query.setParameter("salary", 28000D);

        List<Object[]> listObject = query.getResultList();

        listObject.forEach(row -> System.out.println(row[0] + " : " + row[1]));*/

        /*Query<String> query = session.createQuery("SELECT name FROM Employee WHERE salary>:salary");
        query.setParameter("salary", 28000D);

        List<String> listObject = query.getResultList();

        listObject.forEach(System.out::println);*/


        // Update HR salary by 5000
        /*Query query = session.createQuery("UPDATE Employee SET salary = salary + :salary WHERE department=:department");
        query.setParameter("salary", 1000D);
        query.setParameter("department", "HR");

        int row = query.executeUpdate();*/

        //Delete all HR

        Query query = session.createQuery("DELETE FROM Employee WHERE department=:department");
        query.setParameter("department", "HR");
        int row = query.executeUpdate();
        
        System.out.println("No. of rows affected: " + row);

        transaction.commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
}
