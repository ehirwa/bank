package org.management.bp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Operations")
public class Operation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long opnumber;
	private Date operationDate;
	private double amount;
	@ManyToOne
	@JoinColumn(name="ACCT_CODE")
	private Account account;
	@ManyToOne
	@JoinColumn(name="CODE_EMPL")
	private Employee employee;

	public Operation() {
		super();
	}

	public Operation(Date operationDate, double amount) {
		super();
		this.operationDate = operationDate;
		this.amount = amount;
	}

	public Long getOpnumber() {
		return opnumber;
	}

	public void setOpnumber(Long opnumber) {
		this.opnumber = opnumber;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
