package org.sid.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.sid.entities.Produit_Book;
import org.sid.exception.ResourceNotFoundException;
import org.sid.repositories.Bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/b/")

public class Bookcontroller{
	
	@Autowired
	private  Bookrepository bookrepository;
	
	// get all Produit_book
	
	@GetMapping("/Book/")
	public List<Produit_Book> getAllProduit_Book(){
		return bookrepository.findAll();
	}
	//create a new Produit_book
	@PostMapping("/Book/")
	public Produit_Book createProduit_Book(@Valid @RequestBody Produit_Book Produit_Book ) {
		return bookrepository.save(Produit_Book);
	}
	
	//get a Produit_Book by id
	@GetMapping("/Book/{id}")
	public ResponseEntity<Produit_Book> getEmployeeById(@PathVariable(value = "id") Long BookId)
			throws ResourceNotFoundException {
		Produit_Book produit_book = bookrepository.findById(BookId)
				.orElseThrow(() -> new ResourceNotFoundException("Produit_Book not found for this id :: " + BookId));
		return ResponseEntity.ok().body(produit_book);
	}
	
	//update Produit_Book
 
	@PutMapping("/Book/{id}")
	public ResponseEntity<Produit_Book> updateEmployee(@PathVariable(value = "id") Long BookId,
			@Valid @RequestBody Produit_Book BookDetails) throws ResourceNotFoundException {
		Produit_Book produit_book = bookrepository.findById(BookId)
				.orElseThrow(() -> new ResourceNotFoundException("Produit_Book not found for this id :: " + BookId));

		produit_book.setNom(BookDetails.getNom());
		produit_book.setQuantity(BookDetails.getQuantity());
		produit_book.setRelease_date(BookDetails.getRelease_date());
		final Produit_Book updatedBook = bookrepository.save(produit_book);
		return ResponseEntity.ok(updatedBook);
	}
	@DeleteMapping("/Book/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long BookId)
			throws ResourceNotFoundException {
		Produit_Book employee = bookrepository.findById(BookId)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + BookId));

		bookrepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	

}
