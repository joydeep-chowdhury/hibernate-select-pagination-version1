package com.joydeep.hibernate.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.joydeep.hibernate.model.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        Query query=session.createQuery("from UserDetails");
        query.setFirstResult(1);
        query.setMaxResults(3);
        List<UserDetails> users=query.list();
        
        session.getTransaction().commit();
        session.close();
        System.out.println(users);
        //Temp is now detached and not racked by hibernate since session is closed
	}

}
