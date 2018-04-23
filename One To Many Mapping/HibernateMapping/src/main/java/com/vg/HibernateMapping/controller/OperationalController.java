package com.vg.HibernateMapping.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vg.HibernateMapping.dao.dao;
import com.vg.HibernateMapping.model.College;
import com.vg.HibernateMapping.model.Student;

@Controller
public class OperationalController {
	@Autowired
	dao d;

	@RequestMapping(value = { "/", "", "/home" })
	public String index() {
		return "index";
	}

	@RequestMapping("/college")
	public ModelAndView insertCollege() {
		ModelAndView mv = new ModelAndView("College");
		mv.addObject("college", new College());
		mv.addObject("colleges", d.allCollege());
		return mv;
	}

	@RequestMapping("/incollege")
	public String insert(@ModelAttribute("college") College college) {
		// college.setStudents(d.allStudents());
		if (d.insertCollege(college)) {
			return "redirect:/college";
		} else {
			return "redirect:/college";
		}
	}

	@RequestMapping("/student")
	public ModelAndView insertStudent() {
		ModelAndView mv = new ModelAndView("Student");
		mv.addObject("student", new Student());
		
		return mv;
	}

	@RequestMapping("/instudent")
	public String insert(@ModelAttribute("student") Student student, HttpServletRequest request) {
		// college.setStudents(d.allStudents());
		student.setCollege(d.singleCollege(Integer.parseInt(request.getParameter("lol"))));
		if (d.inseretStudent(student)) {
			return "redirect:/student";
		} else {
			return "redirect:/student";
		}
	}

}
