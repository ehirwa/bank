package org.management.bp.models;

import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.management.bp.entities.Account;
import org.management.bp.entities.Operation;

public class BankForm {
	@NotEmpty
	@Size(min = 3, max = 10)
	private String code;
	private Account account;
	private String accountType;
	private List<Operation> operations;
	private String operationType;
	private String exception;
	@DecimalMin(value = "50")
	private double amount = 50;
	@NotEmpty
	@Size(min = 3, max = 10)
	private String code2 = "XXX";
	private String action;
	//pagination attributes
	private int page=0;
	private int numberOfligns=3;
	private int numberofPages;

	public String getException() {
		return exception;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNumberOfligns() {
		return numberOfligns;
	}

	public void setNumberOfligns(int numberOfligns) {
		this.numberOfligns = numberOfligns;
	}

	public int getNumberofPages() {
		return numberofPages;
	}

	public void setNumberofPages(int numberofPages) {
		this.numberofPages = numberofPages;
	}
	

}
