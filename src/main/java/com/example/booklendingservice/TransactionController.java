package com.example.booklendingservice;

import java.util.ArrayList;
import java.util.List;

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
		bookRepository.updateBookAvailability(book,trxntype.equals("check-out"));
		return "redirect:transactions";
    }
	
	@GetMapping(value = "/transactions")
    public String showListTransaction(Model model)
    {
        List<String> dbData = transactionRepository.ListTransactions();
        List<TransactionPretty> transactions = new ArrayList<TransactionPretty>();
        for(int i = 0; i < dbData.size(); i++) {
        	transactions.add(prettify(dbData.get(i)));
        }
        model.addAttribute("transactions", transactions);
        return "transaction/transactions";
    }

	@GetMapping(value = "/transactions/check_in")
    public String showListTransactionCheckIn(Model model)
    {
        List<String> dbData = transactionRepository.ListTransactionsCheckIn();
        List<TransactionPretty> transactions = new ArrayList<TransactionPretty>();
        for(int i = 0; i < dbData.size(); i++) {
        	transactions.add(prettify(dbData.get(i)));
        }
        model.addAttribute("transactions", transactions);
        return "transaction/transactions";
    }
	
	@GetMapping(value = "/transactions/check_out")
    public String showListTransactionCheckout(Model model)
    {
        List<String> dbData = transactionRepository.ListTransactionsCheckOut();
        List<TransactionPretty> transactions = new ArrayList<TransactionPretty>();
        for(int i = 0; i < dbData.size(); i++) {
        	transactions.add(prettify(dbData.get(i)));
        }
        model.addAttribute("transactions", transactions);
        return "transaction/transactions";
    }
	
	private TransactionPretty prettify (String data) {
		TransactionPretty transaction = new TransactionPretty();
		String[] arrayData = data.split(",");
		//Giang,Nguyen,Into the sky,Nolan,Christopher,2021-04-13 15:12:23.0,Check in
		transaction.setCustomerFirstName(arrayData[0]);
		transaction.setCustomerLastName(arrayData[1]);
		transaction.setBookTitle(arrayData[2]);
		transaction.setAuthorFirstName(arrayData[3]);
		transaction.setAuthorLastName(arrayData[4]);
		transaction.setTransactionDate(arrayData[5]);
		transaction.setTransactionType(arrayData[6]);
		transaction.setId(Integer.parseInt(arrayData[7]));
		return transaction;
	}
}


