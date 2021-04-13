package com.example.booklendingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

@Controller
public class CustomerController {
	
	@Autowired 
	private CustomerRepository customerRepository;

	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	@GetMapping(value = "/add_customer")
	public String renderAddCustomer()
	{
		return "customer/add_customer";
	}
		
	// @PostMapping("/add_customer")
    // public @ResponseBody String addCustomer(
	// 	   @RequestParam("firstName") String firstName,
    //        @RequestParam("lastName") String lastName,
    //        @RequestParam("address") String address,
	// 	   @RequestParam("phone") String phone,
    //        @RequestParam("emailid") String emailid)
    // {
	// 	Customer newCustomer = new Customer(firstName,lastName,address,phone,emailid);
	// 	customerRepository.save(newCustomer);
    //    	return "An employee info added";
    // }

	@PostMapping("/add_customer")
    public String addCustomer(
		   @RequestParam("firstName") String firstName,
           @RequestParam("lastName") String lastName,
           @RequestParam("address") String address,
		   @RequestParam("phone") String phone,
           @RequestParam("emailid") String emailid)
    {
		Customer newCustomer = new Customer(firstName,lastName,address,phone,emailid);
		customerRepository.save(newCustomer);
		return "redirect:customers";
    }
	
	@GetMapping(value = "/customers")
    public String showListCustomer(Model model)
    {
        model.addAttribute("customers", customerRepository.findAll());
        return "customer/customers";
    }
}

