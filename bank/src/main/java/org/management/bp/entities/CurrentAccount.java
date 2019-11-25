package org.management.bp.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CA")
public class CurrentAccount extends Account {
private double overdraft;

public CurrentAccount() {
	super();
}


public CurrentAccount(String accountCode, Date creationDate, double amount, Customer customer, Employee employee,
		Collection<Operation> operations, double overdraft) {
	super(accountCode, creationDate, amount, customer, employee, operations);
	this.overdraft = overdraft;
}





public CurrentAccount(String accountCode, Date creationDate, double amount, Customer customer) {
	super(accountCode, creationDate, amount, customer);
	// TODO Auto-generated constructor stub
}


public double getOverdraft() {
	return overdraft;
}

public void setOverdraft(double overdraft) {
	this.overdraft = overdraft;
}
}
