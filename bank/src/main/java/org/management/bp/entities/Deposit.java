package org.management.bp.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue(value="D")
public class Deposit extends Operation{

	public Deposit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Deposit(Date operationDate, double amount) {
		super(operationDate, amount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Deposit";
	}

}
