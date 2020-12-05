package org.sid.repositories;

import org.sid.entities.Produit_Book;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
public interface Bookrepository extends JpaRepository<Produit_Book, Long > {
	

}
