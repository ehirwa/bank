package org.management.bp.domain;

import java.util.Date;
import java.util.List;

import org.management.bp.dao.IBankDao;
import org.management.bp.entities.Account;
import org.management.bp.entities.Customer;
import org.management.bp.entities.Deposit;
import org.management.bp.entities.Employee;
import org.management.bp.entities.Group;
import org.management.bp.entities.Operation;
import org.management.bp.entities.Withdraw;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class BankDomainImpl implements IBankDomain {
private IBankDao dao;

	public void setDao(IBankDao dao) {
	this.dao = dao;
}

	@Override
	public Customer addCustomer(Customer c) {
		// TODO Auto-generated method stub
		return dao.addCustomer(c);
	}

	@Override
	public Employee addEmployee(Employee e, Long codeSup) {
		// TODO Auto-generated method stub
		return dao.addEmployee(e, codeSup);
	}

	@Override
	public Group addGroup(Group g) {
		// TODO Auto-generated method stub
		return dao.addGroup(g);
	}

	@Override
	public void addEmployeeToGroup(Long empCode, Long groupCode) {
		// TODO Auto-generated method stub
		dao.addEmployeeToGroup(empCode, groupCode);
	}

	@Override
	public Account addAccount(Account ac, Long cusCode, Long empCode) {
		// TODO Auto-generated method stub
		return dao.addAccount(ac, cusCode, empCode);
	}

	@Override
	public void deposit(String accCode, double amt, Long empCode) {
		// TODO Auto-generated method stub
		dao.addOperation(new Deposit(new Date(),amt), accCode, empCode);
		Account ac=dao.viewAccount(accCode);
		ac.setAmount(ac.getAmount()+amt);
		
	}

	@Override
	public void transfer(String accCode1, String accCode2, double amt, Long empCode) {
		// TODO Auto-generated method stub
		withdraw(accCode1,  amt,  empCode);
		deposit(accCode2,  amt,  empCode);
	}

	@Override
	public void withdraw(String accCode, double amt, Long empCode) {
		// TODO Auto-generated method stub
		dao.addOperation(new Withdraw(new Date(),amt), accCode, empCode);
		Account ac=dao.viewAccount(accCode);
		ac.setAmount(ac.getAmount()-amt);
	}

	@Override
	public Account viewAccount(String accCode) {
		// TODO Auto-generated method stub
		return dao.viewAccount(accCode);
	}

	@Override
	public List<Operation> viewOperations(String opCode,int position, int nboperation) {
		// TODO Auto-generated method stub
		return dao.viewOperations(opCode,position, nboperation);
	}

	@Override
	public Customer viewCustomer(Long custCod) {
		// TODO Auto-generated method stub
		return dao.viewCustomer(custCod);
	}

	@Override
	public List<Customer> viewCustomers(String mc) {
		// TODO Auto-generated method stub
		return dao.viewCustomers(mc);
	}

	@Override
	public List<Account> getAccountsbyCustomer(Long custCod) {
		// TODO Auto-generated method stub
		return dao.getAccountsbyCustomer(custCod);
	}

	@Override
	public List<Account> getAccountsbyEmployees(Long empCod) {
		// TODO Auto-generated method stub
		return dao.getAccountsbyEmployees(empCod);
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return dao.getEmployees();
	}

	@Override
	public List<Group> getGroups() {
		// TODO Auto-generated method stub
		return dao.getGroups();
	}

	@Override
	public List<Employee> getEmployeesByGroup(Long groupCode) {
		// TODO Auto-generated method stub
		return dao.getEmployeesByGroup(groupCode);
	}

	@Override
	public long getNumberOfOperations(String accNo) {
		// TODO Auto-generated method stub
		return dao.getNumberOfOperations(accNo);
	}

}
