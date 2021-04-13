package com.example.booklendingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransactionController {
	
	@Autowired 
	private TransactionRepository transactionRepository;
	@Autowired 
	private CustomerRepository customerRepository;
	@Autowired 
	private BookRepository bookRepository;

	
	@GetMapping(value = "/add_transaction")
	public String renderAddTransaction(Model model)
	{
		model.addAttribute("customers", customerRepository.findAll());
		model.addAttribute("books", bookRepository.findAll());
		return "transaction/add_transaction";
	}
		
	@PostMapping("/add_transaction")
    public String addTransaction(
		   @RequestParam("bookId") String bookId,
           @RequestParam("customerId") String customerId,
           @RequestParam("trxnType") String trxntype)
    {
		int book = Integer.parseInt(bookId);
		int customer = Integer.parseInt(customerId);
		Transaction newTransaction = new Transaction(customer,book,trxntype);
		transactionRepository.save(newTransaction);
		System.out.print("saved new transaction");
		return "redirect:transactions";
    }
	
	@GetMapping(value = "/transactions")
    public String showListTransaction(Model model)
    {
        model.addAttribute("transactions", transactionRepository.findAll());
        return "transaction/transactions";
    }
}


