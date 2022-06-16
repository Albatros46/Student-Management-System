package com.sms.controller;

import com.sms.entity.Student;
import com.sms.service.StudentService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	// handler metod to handle list student and return mode and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students"; // templates icindeki students.html ile iliskili
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		// yeni ogrenci kaydi eklemek icin
		Student student = new Student(); // create student obj to hold form data
		model.addAttribute("student", student);
		return "create_student"; // create_student.html ile iliskili olacak

	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		// yeni ogrenci kaydini eklemek icin
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}") // students.html deki update butonun ile cagirilacak kisim
	public String enditStudentForm(@PathVariable Long id, Model model) {
		// kayitli kisiyi düzenleme islemi
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";// edit_student.hml sayfasi seklinde dondurulecek
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, 
			@ModelAttribute("student") Student student,Model model) 
	{
		// id ye gore cagirilip ayni id ye gore yeni veri girilerek düzenleyecegiz
		Student existingStudent=studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		//kayit ve guncelleme islemi
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	//Delete icin handler metod
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";//kayit silindiginde students.html ye yeni liste ile donus yapacak
	}
}
