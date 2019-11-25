package org.management.bp.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("SA")
public class SavingAccount extends Account {
	private double rate;
public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

public SavingAccount(String accountCode, Date creationDate, double amount, Customer customer, Employee employee,
			Collection<Operation> operations, double rate) {
		super(accountCode, creationDate, amount, customer, employee, operations);
		this.rate = rate;
	}



public SavingAccount(String accountCode, Date creationDate, double amount, Customer customer) {
	super(accountCode, creationDate, amount, customer);
	// TODO Auto-generated constructor stub
}

public SavingAccount() {
	super();
}
}
