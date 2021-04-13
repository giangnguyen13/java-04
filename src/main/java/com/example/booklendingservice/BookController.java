package com.example.booklendingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

@Controller
public class BookController {
	
	@Autowired 
	private BookRepository bookRepository;

	
	@GetMapping(value = "/add_book")
	public String renderAddBook()
	{
		return "book/add_book";
	}
		
	@PostMapping("/add_book")
    public String addBook(
		   @RequestParam("authorFirstName") String authorFirstName,
           @RequestParam("authorLastName") String authorLastName,
           @RequestParam("title") String title,
		   @RequestParam("phone") String phone,
           @RequestParam("rating") String rating)
    {
		int bookRating = Integer.parseInt(rating);
		Book newBook = new Book(title,authorLastName,authorFirstName,phone,bookRating);
		bookRepository.save(newBook);
       	return "redirect:books";
    }
	
	@GetMapping(value = "/books")
    public String showListBook(Model model)
    {
        model.addAttribute("books", bookRepository.findAll());
        return "book/books";
    }
}


