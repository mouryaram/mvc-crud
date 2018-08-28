package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.entity.Student;
import com.springdemo.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	//inject service into Controller
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		//get students from dao
		List<Student> thestudent=studentService.getStudents();
		//add students to model
          model.addAttribute("student",thestudent);		
		
		return "list-students";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Student thestudent=new Student();
		model.addAttribute("student",thestudent);
		return "student-form";
	}

	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student")Student thestudent) {
		studentService.saveStudent(thestudent);
		return "redirect:/student/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId,Model model) {
		//get the Student from database
		
		Student theStudent=studentService.getStudent(theId);
		
		
		//set student as a model attribute to prepopulate the form
		
		model.addAttribute("student",theStudent);
		
		//send over to form
		return "student-form";
	}
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int theId) {
		
		studentService.deleteStudent(theId);
		return "redirect:/student/list";
	}
	
	@PostMapping("/search")
	public String searchStudent(@RequestParam("theSearchName") String theSearchName,Model model) {
		List<Student> thestudents= studentService.searchStudents(theSearchName);
		model.addAttribute("student",thestudents);
		
		return "list-students";
		
	}
}
