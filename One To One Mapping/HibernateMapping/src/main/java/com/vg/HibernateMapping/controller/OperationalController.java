package com.vg.HibernateMapping.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.server.reactive.HttpHeadResponseDecorator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vg.HibernateMapping.dao.dao;
import com.vg.HibernateMapping.model.Person;
import com.vg.HibernateMapping.model.PersonDetail;

@Controller
public class OperationalController {
	@Autowired
	dao d;

	@RequestMapping(value = { "/", "", "/home" })
	public String index() {
		return "index";
	}

	@RequestMapping("/person")
	public ModelAndView regPerson() {

		ModelAndView mv = new ModelAndView("PersonReg");
		mv.addObject("prsn", new Person());
		return mv;
	}

	@RequestMapping("/regperson")
	public String reg(@ModelAttribute("prsn") Person person) {

		if (d.regPerson(person)) {
			return "redirect:/person";
		} else {
			return "redirect:/person";
		}
	}

	@RequestMapping("/persondetail")
	public ModelAndView regPersonDetail() {

		ModelAndView mv = new ModelAndView("PersonDetailReg");
		mv.addObject("prsndtl", new PersonDetail());
		mv.addObject("allperson", d.allPerson());
		return mv;
	}

	@RequestMapping("/regpersondetail")
	public String regDetail(@ModelAttribute("prsndtl") PersonDetail pDetail, HttpServletRequest request) {

		pDetail.setPerson(d.singlePerson(Integer.parseInt(request.getParameter("lol"))));

		if (d.regPersonDetail(pDetail)) {
			return "redirect:/person";
		} else {
			return "redirect:/person";
		}
	}

}
