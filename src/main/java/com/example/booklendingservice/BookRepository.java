package com.example.booklendingservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepository extends JpaRepository<Book, Integer> {
	@Query(value="SELECT * FROM books b WHERE b.isavailable = 1",nativeQuery = true)
	List<Book> findAvailableBooks();
	
	@Query(value="SELECT * FROM books b WHERE b.isavailable = 0",nativeQuery = true)
	List<Book> findInUseBooks();
	
	@Modifying
	@Transactional
	@Query(value = "update books b set b.isavailable = :status where b.bookid = :id",nativeQuery = true)
	void updateBookAvailability(@Param("id") int id, @Param("status") boolean status);

}
