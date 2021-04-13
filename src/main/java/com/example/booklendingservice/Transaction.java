package com.example.booklendingservice;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class Transaction {
	@Id
	@Column(name="transactionid")
	private int transactionId;
	@Column(name="customerid")
	private int customerId;
	@Column(name="bookid")
	private int bookId;
	@Column(name="trxndate")
	private String trxnDate;
	@Column(name="trxntype")
	private String trxnType;
	
	public Transaction() {
		super();
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		this.trxnDate = formatter.format(date);
	}
	public Transaction(
			int customerId
			, int bookId
			, String trxnType) {
		super();
		this.customerId = customerId;
		this.bookId = bookId;
		this.trxnType = trxnType;
		
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		this.trxnDate = formatter.format(date);
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTrxnDate() {
		return trxnDate;
	}
	public void setTrxnDate(String trxnDate) {
		this.trxnDate = trxnDate;
	}
	public String getTrxnType() {
		return trxnType;
	}
	public void setTrxnType(String trxnType) {
		this.trxnType = trxnType;
	}

}
