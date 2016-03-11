package com.example.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import com.example.entity.Student;
import com.example.respository.StudentRespository;

@Startup
@Singleton
public class StartupService {

	@Inject
	private StudentRespository respository;
	
	@PostConstruct
	public void init() {
		Student s1 = new Student();
		s1.setName("Ravi");
		Student s2 = new Student();
		s2.setName("Sankar");
		respository.addStudent(s1);
		respository.addStudent(s2);
	}
	
}
