package com.sms.service.impl;

import java.util.List;

import com.sms.entity.Student;
import com.sms.repository.StudentRepository;
import com.sms.service.StudentService;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceIMPL implements StudentService{

	private StudentRepository studentRepository;
	
	
	public StudentServiceIMPL(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public List<Student> getAllStudents() {
		// kayitlari listelemek icin
		return studentRepository.findAll();
	}


	@Override
	public Student saveStudent(Student student) {
		// yeni kayit eklemek icin
		return studentRepository.save(student);
	}


	@Override
	public Student getStudentById(Long id) {
		// id ye gore kayit ekleme ve silme islemi icin
		return studentRepository.findById(id).get();
	}


	@Override
	public Student updateStudent(Student student) {
		// Kayit Güncellemek icin
		return studentRepository.save(student);
	}


	@Override
	public void deleteStudentById(Long id) {
		// Kayit silmek icin
		studentRepository.deleteById(id);
		
	}
	
}
