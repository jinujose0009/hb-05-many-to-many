package com.jinu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jinu.entity.Course;
import com.jinu.entity.Instructor;
import com.jinu.entity.InstructorDetails;
import com.jinu.entity.Review;
import com.jinu.entity.Student;

public class CreateCourseforMery {

	public static void main(String[] args) {
		
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetails.class)
										.addAnnotatedClass(Course.class)
										.addAnnotatedClass(Review.class)
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				// create session
				Session session = factory.getCurrentSession();
				
				try {			
					int id=13;
					// start a transaction
					session.beginTransaction();
								
					// Get student
					Student thestudent=session.get(Student.class, id);
					System.out.println("Student details....."+thestudent);
					//Create course
					Course c1=new Course("C++");
					Course c2=new Course("C");
					//add course
							c1.addStudent(thestudent);
							c2.addStudent(thestudent);
					// save the course
					System.out.println("\nSaving the course ...");
					session.save(c1);
					session.save(c2);
					//System.out.println("Saved the course: " + tempCourse);
					
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				finally {
					
					// add clean up code
					session.close();
					
					factory.close();
				}
	}

}
