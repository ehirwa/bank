package org.management.bp.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue(value="W")
public class Withdraw extends Operation{

	public Withdraw() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Withdraw(Date operationDate, double amount) {
		super(operationDate, amount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Withdraw ";
	}
	

}
