package test;

import java.util.Date;

import org.management.bp.domain.IBankDomain;
import org.management.bp.entities.CurrentAccount;
import org.management.bp.entities.Customer;
import org.management.bp.entities.Employee;
import org.management.bp.entities.Group;
import org.management.bp.entities.SavingAccount;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		IBankDomain domain = (IBankDomain) context.getBean("domain");
		domain.addCustomer(new Customer("C1", "AD1"));
		domain.addCustomer(new Customer("C2", "AD2"));
		domain.addEmployee(new Employee("E1"), null);
		domain.addEmployee(new Employee("E2"), 1L);
		domain.addEmployee(new Employee("E3"), 1L);
		domain.addGroup(new Group("G1"));
		domain.addGroup(new Group("G2"));

		domain.addEmployeeToGroup(1L, 1L);
		domain.addEmployeeToGroup(2L, 2L);
		domain.addEmployeeToGroup(3L, 2L);

		domain.addAccount(new CurrentAccount("CA1", new Date(), 9000, null),1L,2L);
		domain.addAccount(new SavingAccount("SA1", new Date(), 9000, null),1L,2L);
		domain.deposit("CA1", 5000, 1L);
		domain.withdraw("CA1", 7000, 1L);
		domain.transfer("SA1", "CA1", 4000, 1L);;
	}

}
