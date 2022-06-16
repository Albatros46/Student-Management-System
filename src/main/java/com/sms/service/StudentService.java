package com.sms.service;

import java.util.List;

import com.sms.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudents();//listeleme islemi icin
	
	Student saveStudent(Student student);//kayit ekleme islemi icin
	
	Student getStudentById(Long id);//id ye gore kayit düzenleme, silme islemi yapacagiz onun icin
	
	Student updateStudent(Student student);//kayitli veriyi düzenlemek icin
	
	void deleteStudentById(Long id);//kayit silme islemi icin
}
