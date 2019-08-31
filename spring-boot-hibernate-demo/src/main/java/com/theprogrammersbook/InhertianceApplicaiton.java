package com.theprogrammersbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.theprogrammersbook.entity.inheritance.percontract.Contract_EmployeePerClass;
import com.theprogrammersbook.entity.inheritance.percontract.EmployeePerClass;
import com.theprogrammersbook.entity.inheritance.percontract.EmployeePerClassDao;
import com.theprogrammersbook.entity.inheritance.percontract.Regular_EmployeePerClass;
import com.theprogrammersbook.entity.inheritance.perheirarchy.Contract_Employee;
import com.theprogrammersbook.entity.inheritance.perheirarchy.Employee;
import com.theprogrammersbook.entity.inheritance.perheirarchy.EmployeeDao;
import com.theprogrammersbook.entity.inheritance.perheirarchy.Regular_Employee;
import com.theprogrammersbook.entity.inheritance.persubclass.Contract_EmployeePerSubClass;
import com.theprogrammersbook.entity.inheritance.persubclass.EmployeePerSubClass;
import com.theprogrammersbook.entity.inheritance.persubclass.EmployeePerSubClassDao;
import com.theprogrammersbook.entity.inheritance.persubclass.Regular_EmployeePerSubClass;

//@SpringBootApplication
public class InhertianceApplicaiton implements CommandLineRunner {
	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private EmployeePerClassDao employeePerClassDao;

	@Autowired
	private EmployeePerSubClassDao employeePerSubClassDao;

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("++++++++++++++++++++Coming to This Area ++++++++++++++++++++");
		singleTable();

		tablePerClass();

		tablePerSubClass();

	}

	private void tablePerSubClass() {
		// Table Per SubClass
		EmployeePerSubClass eps1 = new EmployeePerSubClass();
		eps1.setName("FirstEmployee");
		employeePerSubClassDao.addEmployee(eps1);

		Regular_EmployeePerSubClass eps2 = new Regular_EmployeePerSubClass();
		eps2.setName("Vivek Kumar");
		eps2.setSalary(50000);
		eps2.setBonus(5);
		employeePerSubClassDao.addRegularEmployee(eps2);

		Contract_EmployeePerSubClass eps3 = new Contract_EmployeePerSubClass();
		eps3.setName("Arjun Kumar");
		eps3.setPay_per_hour(1000);
		eps3.setContract_duration("15 hours");
		employeePerSubClassDao.addContractEmployee(eps3);
	}

	private void tablePerClass() {
		// Table Per Class
		EmployeePerClass epc1 = new EmployeePerClass();
		epc1.setName("FirstEmployee");
		employeePerClassDao.addEmployee(epc1);

		Regular_EmployeePerClass epc2 = new Regular_EmployeePerClass();
		epc2.setName("Vivek Kumar");
		epc2.setSalary(50000);
		epc2.setBonus(5);
		employeePerClassDao.addRegularEmployee(epc2);

		Contract_EmployeePerClass epc3 = new Contract_EmployeePerClass();
		epc3.setName("Arjun Kumar");
		epc3.setPay_per_hour(1000);
		epc3.setContract_duration("15 hours");
		employeePerClassDao.addContractEmployee(epc3);

		Contract_EmployeePerClass epc4 = new Contract_EmployeePerClass();
		epc4.setName("Arjuns Kumar");
		epc4.setPay_per_hour(1000);
		epc4.setContract_duration("15 hours");
		employeePerClassDao.addContractEmployee(epc4);

		Regular_EmployeePerClass epc5 = new Regular_EmployeePerClass();
		epc5.setBonus(5);
		employeePerClassDao.addRegularEmployee(epc5);
	}

	private void singleTable() {
		// Table Per Hierarchy
		Employee emp = new Employee();
		emp.setName("FirstEmployee");
		employeeDao.addEmployee(emp);

		Regular_Employee e2 = new Regular_Employee();
		e2.setName("Vivek Kumar");
		e2.setSalary(50000);
		e2.setBonus(5);
		employeeDao.addRegularEmployee(e2);

		Contract_Employee e3 = new Contract_Employee();
		e3.setName("Arjun Kumar");
		e3.setPay_per_hour(1000);
		e3.setContract_duration("15 hours");
		employeeDao.addContractEmployee(e3);
	}

}
