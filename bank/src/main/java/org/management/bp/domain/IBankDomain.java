package org.management.bp.domain;

import java.util.List;

import org.management.bp.entities.Account;
import org.management.bp.entities.Customer;
import org.management.bp.entities.Employee;
import org.management.bp.entities.Group;
import org.management.bp.entities.Operation;

public interface IBankDomain {
	public Customer addCustomer(Customer c);

	public Employee addEmployee(Employee e, Long codeSup);

	public Group addGroup(Group g);

	public void addEmployeeToGroup(Long empCode, Long groupCode);

	public Account addAccount(Account ac, Long cusCode,Long empCode);

//	public Operation addOperation(Operation op, String accCode, Long empCode);

	public void deposit(String accCode, double amt, Long empCode);

	public void transfer(String accCode1, String accCode2, double amt, Long empCode);

	public void withdraw(String accCode, double amt, Long empCode);
	public Account viewAccount(String accCode);

	public List<Operation> viewOperations(String opCode,int position, int nboperation);

	public Customer viewCustomer(Long custCod);
	
	public List<Customer>viewCustomers(String mc);

	public List<Account> getAccountsbyCustomer(Long custCod);

	public List<Account> getAccountsbyEmployees(Long empCod);

	public List<Employee> getEmployees();

	public List<Group> getGroups();

	public List<Employee> getEmployeesByGroup(Long groupCode);

	public long getNumberOfOperations(String accNo);
}
