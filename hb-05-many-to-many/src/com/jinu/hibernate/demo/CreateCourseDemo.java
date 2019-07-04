package com.jinu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jinu.entity.Course;
import com.jinu.entity.Instructor;
import com.jinu.entity.InstructorDetails;
import com.jinu.entity.Student;

public class CreateCourseDemo {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try{
			
			session.beginTransaction();
			int theid=1;
			//Get instructor from db
			Instructor theinstInstroctor=session.get(Instructor.class, 1);
			
			//Create some courses
		    Course courseone= new Course("Java complete reference");
		    Course coursetwo=new Course("Jdbc full syllabus");
		    
		    //add courses to the instructor
		    theinstInstroctor.add(courseone);
		    theinstInstroctor.add(coursetwo);
		    
		    //save the cources
		    
		    session.save(courseone);
		    session.save(coursetwo);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done..!");
			
		}
		finally{
			session.close();
			factory.close();
		}
		
		

	}

}
