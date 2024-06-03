package org.devpatel;

import java.util.List;

import org.devpatel.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
        
		
		// CREATE A NEW SESSION WHERE SESSTIONFACTORY configure = hibernate.cfg.xml AND addAnnotatedClass = Users AFTER THAT buildSessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Users.class)
                .buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
        try {
        	
        // INSERT DATA FROM ECLIPSE TO DB
        	//	Users users = new Users("name", "email", "password"); 
        	//	session.beginTransaction();
        	//	session.save(users);
        	//	session.getTransaction().commit();
        	//	System.out.println("Row Added :) "); // FOR VARIFACTION THAT DATA IS INSERTED OR NOT
        
        // SHOW USERS FROM DB TO CONSOLE
        	// Users users = new Users();
         	// session.beginTransaction();
         	// users = session.get(Users.class, 2); // 2 is ID (anoted table, id)
         	// session.getTransaction().commit();
        	// System.out.println(users);
         
        
        // UPDATE THE USERS FROM ECLIPSE TO DB
        	// Users users = new Users();
         	// session.beginTransaction();
        	// users = session.get(Users.class, 2);
        	// users.setPassword("hello@123");
        	// session.getTransaction().commit();
        	// System.out.println(users);
        	
        // DELETE THE USERS FROM ECLIPSE TO DB
        	// Users users = new Users();
        	// session.beginTransaction();
        	// users = session.get(Users.class, 3);
        	// session.delete(users);
        	// session.getTransaction().commit();
        	
        // LIST THE USERS FROM DB TO ECLIPSE
        	// session.beginTransaction();
        	// List<Users> listofDB = session.createQuery("from users").getResultList(); // from users mean that given into Users class Entity name
        	// for (Users users : listofDB) {
			// 	System.out.println(users);
			// }
        	
        // WHERE CONDITIONS THE USERS FROM DB TO ECLIPSE
        	session.beginTransaction();
/*UPDATE*/  session.createQuery("update users set name = 'Nilam Patel'" + "where id = 1").executeUpdate(); // where id = this id is define in Users class not in Users table in DB
// using this way to perform all the operations in Hibernate
			System.out.println("Rows affected ");
            
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
    }
}
