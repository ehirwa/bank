package org.management.bp.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employees")
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeecode;
	private String employeeName;
	@ManyToOne
	@JoinColumn(name="EMP_SUP_CODE")
	private Employee employeeSup;
	@ManyToMany
	@JoinTable(name="EMP_GR",joinColumns=
	@JoinColumn(name="EMP_CODE"),
	inverseJoinColumns=@JoinColumn(name="GR_CODE"))
	private Collection<Group> groups;

	public Employee(String employeeName, Employee employeeSup) {
		super();
		this.employeeName = employeeName;
		this.employeeSup = employeeSup;
	}

	public Employee(String employeeName) {
		super();
		this.employeeName = employeeName;
	}

	public Employee() {
		super();
	}

	public Long getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(Long employeecode) {
		this.employeecode = employeecode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Employee getEmployeeSup() {
		return employeeSup;
	}

	public void setEmployeeSup(Employee employeeSup) {
		this.employeeSup = employeeSup;
	}

	public Collection<Group> getGroups() {
		return groups;
	}

	public void setGroups(Collection<Group> groups) {
		this.groups = groups;
	}

}
