package org.management.bp.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customer implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CUS_CODE")
	private Long customercode;
	private String customerName;
	private String customerAddress;
	@OneToMany(mappedBy="customer",fetch=FetchType.LAZY)
	private Collection<Account> accounts;

	public Customer() {
		super();
	}

	public Customer(String customerName, String customerAddress) {
		super();
		this.customerName = customerName;
		this.customerAddress = customerAddress;
	}

	public Customer(String customerName, String customerAddress, Collection<Account> accounts) {
		super();
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.accounts = accounts;
	}

	public Long getCustomercode() {
		return customercode;
	}

	public void setCustomercode(Long customercode) {
		this.customercode = customercode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Collection<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Collection<Account> accounts) {
		this.accounts = accounts;
	}

}
