package com.example.respository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.example.entity.Student;

@Transactional
public class StudentRespository {

	@Inject
	private EntityManager em;
	
	public Student addStudent(Student student) {
		em.persist(student);
		return student;
	}
	
	public Student findStudentById(Long id) {
		return em.find(Student.class, id);
	}
	
	public List<Student> findAllStudents() {
		return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
	}
	
	public void updateStudent(Student student) {
		em.merge(student);
				
	}
	
	public void removeStudentById(Long id) {
		em.remove(em.find(Student.class, id));
				
	}
	
}
