package test;

import java.util.List;

import org.management.bp.domain.IBankDomain;
import org.management.bp.entities.Account;
import org.management.bp.entities.Operation;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		IBankDomain domain = (IBankDomain) context.getBean("domain");
		Account ac = domain.viewAccount("CA1");

		System.out.println("Solde :" + ac.getAmount());
		System.out.println("Date :" + ac.getCreationDate());
		System.out.println("Customer :" + ac.getCustomer().getCustomerName());
		System.out.println("Employee:" + ac.getEmployee().getEmployeeName());
		List<Operation> ops = domain.viewOperations("CA1",0,5);
		for (Operation op : ops) {
			System.out.println("************************");
			System.out.print(op.getOpnumber());
			System.out.print(op.getOperationDate());
			System.out.println(op.getAmount());
			System.out.println(op.getClass().getSimpleName());
		}

	}

}
