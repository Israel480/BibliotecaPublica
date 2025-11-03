package br.edu.org.biblioteca.publica.controller;

import br.edu.org.biblioteca.publica.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

@RestController
@RequestMapping("/api/v1/livro")
public class LivroController {
    @Autowired
    LivroService service;

    // EXEMPLO
//    @GetMapping("/by-category")
//    public List<Book> getBooksByCategory(@RequestParam String name) {
//        return bookService.findBooksByCategoryName(name);
//    }




}
