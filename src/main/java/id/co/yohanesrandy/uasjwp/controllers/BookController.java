package id.co.yohanesrandy.uasjwp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.co.yohanesrandy.uasjwp.entities.Book;
import id.co.yohanesrandy.uasjwp.entities.Category;
import id.co.yohanesrandy.uasjwp.repositories.BookRepository;
import id.co.yohanesrandy.uasjwp.repositories.CategoryRepository;

@Controller
@RequestMapping("books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	private Book book;

	@Autowired
	private CategoryRepository categoryRepository;
	private Category category;

	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("title", "Master Book");
		model.addAttribute("books", bookRepository.findAll());
		model.addAttribute("categories", categoryRepository.findAll());
		return "books/index";
	}

	@PostMapping("/save")
	public String save(Book Book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "books/form";
		}
		bookRepository.save(Book);
		return "redirect:/books";
	}

	@GetMapping("/add")
	public String add(Book Book, Model model) {
		model.addAttribute("title", "Add Book");
		model.addAttribute("categories", categoryRepository.findAll());
		return "books/form";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id" + id));
		model.addAttribute("title", "Edit Book");
		model.addAttribute("categories", categoryRepository.findAll());
		model.addAttribute("book", book);
		return "books/form";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model) {
		Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id" + id));
		bookRepository.delete(book);
		return "redirect:/books";
	}

}
