package org.management.bp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.management.bp.entities.Account;
import org.management.bp.entities.Customer;
import org.management.bp.entities.Employee;
import org.management.bp.entities.Group;
import org.management.bp.entities.Operation;

public class BankDaoImpl implements IBankDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Customer addCustomer(Customer c) {
		// TODO Auto-generated method stub
		em.persist(c);
		return c;
	}

	@Override
	public Employee addEmployee(Employee e, Long codeSup) {
		// TODO Auto-generated method stub
		if (codeSup != null) {
			Employee sup = em.find(Employee.class, codeSup);
			e.setEmployeeSup(sup);
		}
		em.persist(e);
		return e;
	}

	@Override
	public Group addGroup(Group g) {
		// TODO Auto-generated method stub
		em.persist(g);
		return g;
	}

	@Override
	public void addEmployeeToGroup(Long empCode, Long groupCode) {
		// TODO Auto-generated method stub
		Employee e = em.find(Employee.class, empCode);
		Group g = em.find(Group.class, groupCode);
		e.getGroups().add(g);
		g.getEmployees().add(e);
	}

	@Override
	public Account addAccount(Account ac, Long cusCode, Long empCode) {
		// TODO Auto-generated method stub
		Customer cus = em.find(Customer.class, cusCode);
		Employee emp = em.find(Employee.class, empCode);
		ac.setCustomer(cus);
		ac.setEmployee(emp);
		em.persist(ac);
		return ac;
	}

	@Override
	public Operation addOperation(Operation op, String accCode, Long empCode) {
		// TODO Auto-generated method stub
		Account acc = viewAccount(accCode);
		Employee empl = em.find(Employee.class, empCode);
		op.setAccount(acc);
		op.setEmployee(empl);
		em.persist(op);
		return op;

	}

	@Override
	public Account viewAccount(String accCode) {
		// TODO Auto-generated method stub
		Account ac = em.find(Account.class, accCode);
		if (ac == null)
			throw new RuntimeException("Account "+accCode+" not found !");
		return ac;
	}

	@Override
	public List<Operation> viewOperations(String opCode,int position, int nboperation) {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("select o from Operation o where o.account.accountCode=:x order by o.operationDate desc");
		qry.setParameter("x", opCode);
		qry.setFirstResult(position);
		qry.setMaxResults(nboperation);

		return qry.getResultList();

	}

	@Override
	public Customer viewCustomer(Long custCod) {
		// TODO Auto-generated method stub
		Customer c = em.find(Customer.class, custCod);
		if (c == null)
			throw new RuntimeException("Customer not found !");
		return c;
	}

	@Override
	public List<Account> getAccountsbyCustomer(Long custCod) {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("select a from Account a where a.customer.customercode = :x");
		qry.setParameter("x", custCod);

		return qry.getResultList();

		 
	}

	@Override
	public List<Customer> viewCustomers(String mc) {
		Query qry = em.createQuery("select c from Customer c where c.customerName like :x");
		qry.setParameter("x", "%"+ mc+"%");

		return qry.getResultList();
	}

	@Override
	public List<Account> getAccountsbyEmployees(Long empCod) {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("select a from Account a where a.employee.employeecode = :x");
		qry.setParameter("x", empCod);

		return qry.getResultList();
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("select e from Employee e");
		 

		return qry.getResultList();
	}

	@Override
	public List<Group> getGroups() {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("select g from Group g");
		 

		return qry.getResultList();
	}

	@Override
	public List<Employee> getEmployeesByGroup(Long groupCode) {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("select e from Employee e where e.groups.groupCode =:x");
		qry.setParameter("x", groupCode);

		return qry.getResultList();
	}

	@Override
	public long getNumberOfOperations(String accNo) {
		// TODO Auto-generated method stub
		Query qry=em.createQuery("select count(o) from Operation o where o.account.accountCode=:x");
		qry.setParameter("x",accNo);
		return (Long) qry.getResultList().get(0);
	}

}
