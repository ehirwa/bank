package org.management.bp.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Accounts")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ACCT_TYPE",discriminatorType = DiscriminatorType.STRING,length=4)
public class Account implements Serializable{
	@Id
	private String accountCode;
	private Date creationDate;
	private double amount;
	@ManyToOne
	@JoinColumn(name="CUS_CODE")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name="EMP_CODE")
	private Employee employee;
	@OneToMany(mappedBy="account")
	private Collection<Operation> operations;
	public Account() {
		super();
	}
	public Account(String accountCode, Date creationDate, double amount, Customer customer, Employee employee,
			Collection<Operation> operations) {
		super();
		this.accountCode = accountCode;
		this.creationDate = creationDate;
		this.amount = amount;
		this.customer = customer;
		this.employee = employee;
		this.operations = operations;
	}
	
	
	
	public Account(String accountCode, Date creationDate, double amount, Customer customer) {
		super();
		this.accountCode = accountCode;
		this.creationDate = creationDate;
		this.amount = amount;
		this.customer = customer;
	}
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Collection<Operation> getOperations() {
		return operations;
	}
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}

}
