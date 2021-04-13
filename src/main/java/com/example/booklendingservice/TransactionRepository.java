package com.example.booklendingservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	@Query(value = "Select "
			+ "c.FirstName, c.LastName, "
			+ "b.Title, b.AuthorFirstName, b.AuthorLastName, "
			+ "t.TrxnDate, t.TrxnType,t.TransactionId "
			+ "from Transactions t "
			+ "join Customers c on t.CustomerId = c.CustomerId "
			+ "join Books b on t.BookId = b.BookId "
			+ "order by t.TransactionId desc"
			,nativeQuery = true)
	List<String> ListTransactions();
	
	@Query(value = "Select "
			+ "c.FirstName, c.LastName, "
			+ "b.Title, b.AuthorFirstName, b.AuthorLastName, "
			+ "t.TrxnDate, t.TrxnType,t.TransactionId "
			+ "from Transactions t "
			+ "join Customers c on t.CustomerId = c.CustomerId "
			+ "join Books b on t.BookId = b.BookId "
			+ "where t.TrxnType = 'check-in' "
			+ "order by t.TransactionId desc"
			,nativeQuery = true)
	List<String> ListTransactionsCheckIn();
	
	@Query(value = "Select "
			+ "c.FirstName, c.LastName, "
			+ "b.Title, b.AuthorFirstName, b.AuthorLastName, "
			+ "t.TrxnDate, t.TrxnType,t.TransactionId "
			+ "from Transactions t "
			+ "join Customers c on t.CustomerId = c.CustomerId "
			+ "join Books b on t.BookId = b.BookId "
			+ "where t.TrxnType = 'check-out' "
			+ "order by t.TransactionId desc"
			,nativeQuery = true)
	List<String> ListTransactionsCheckOut();
}

