package com.luv2code.springdemo.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.controller.CustomerController;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	//a�a��daki kodlar� g�ncelledim, art�k service den �a��r�m yapaca��m
	//need to inject the customer dao
	//@Autowired
	//private CustomerDAO customerDAO;//customer dao yu implemente eden component i�in tarama ba�lanacak SPRING taraf�ndan
	
	//need to inject the our customer service
	@Autowired
	private CustomerService customerService;
	
	//@RequestMapping("/list")
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		//get customers from th instead of DAO..=> customer service
		List<Customer> theCustomers=customerService.getCustomers(); 
		
		//ADD THE CUSTOMERS TO THE model
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Customer theCustomer=new Customer();
		
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		//save the customer using our service
		customerService.saveCustomer(theCustomer);		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel) {
		//get the customer from our service
		Customer theCustomer=customerService.getCustomers(theId);
		
		//set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer",theCustomer);
		
		//send over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		//delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		
		//search customers from service
		List<Customer> theCustomers=customerService.searchCustomer(theSearchName);
		
		//add the customers to the model
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}
	
}
