package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationsController {

	@Autowired
	private IEmployeeMgmtService empService;

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/report")
	public String showEmployeeReport(Map<String, Object> map) {
		// use service
		Iterable<Employee> itEmps = empService.getAllEmployee();
		// put result in model attribute
		map.put("empsList", itEmps);
		itEmps.forEach(emp -> {
			System.out.println(emp);
		});
		// return LVN
		return "show_employee_report";
	}

	@GetMapping("/register")
	public String showRegisterEmployeeFormPage(@ModelAttribute("emp") Employee emp) {
		// return LVN
		return "register_employee";
	}

	/*	
		 * @PostMapping("/register") public String
		 * registerEmployee(@ModelAttribute("emp") Employee emp, Map<String,Object> map)
		 * { //use service String msg = empService.registerEmployee(emp);
		 * Iterable<Employee> itEmps = empService.getAllEmployee(); //keep result in
		 * model Attribure map.put("resultMsg",msg); map.put("empsList",itEmps);
		 * //return LVN return "show_employee_report"; }
		 */
	@PostMapping("/register")
	public String registerEmployee(@ModelAttribute("emp") Employee emp, RedirectAttributes attrs) {
		// use service
		String msg = empService.registerEmployee(emp);
		// Iterable<Employee> itEmps = empService.getAllEmployee();
		// keep result in model Attribure
		attrs.addFlashAttribute("resultMsg", msg);
		// map.put("empsList",itEmps);
		// return LVN
		return "redirect:report";
	}
	
	@GetMapping("/edite")
	public String showEditeEmployeePage(@ModelAttribute("emp") Employee emp,
																					@RequestParam("eno") int id) { 
	Employee emp1 = empService.fetchEmployeeById(id);
	BeanUtils.copyProperties(emp1, emp);
	return "employee_edite_page";
		
	}
	@PostMapping("/edite")
	public String updateEmployee(@ModelAttribute("emp")Employee emp,
																	RedirectAttributes attrs) {		
		String msg = empService.updateEmployee(emp);
		System.out.println(emp.toString());
		attrs.addFlashAttribute("ResultMsg", msg);
		return "redirect:report";
		
	}
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("eno") int id,
																RedirectAttributes attrs) {
		String msg = empService.deleteEmployeeById(id);
		attrs.addFlashAttribute("ResultMsg", msg);
		return "redirect:report";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}