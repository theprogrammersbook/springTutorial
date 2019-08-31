package com.theprogrammersbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.theprogrammersbook.entity.mapping.onetoone.Address11;
import com.theprogrammersbook.entity.mapping.onetoone.Employee11;
import com.theprogrammersbook.entity.mapping.onetoone.OneToOneDao;

@SpringBootApplication
public class OneToOneMappingApplication implements CommandLineRunner {

	@Autowired
	private OneToOneDao oneToOneDao;

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("++++++++++++++++++++Coming to This Area ++++++++++++++++++++");
		for(int i=0;i<10;i++) {
			addEmployeeOneToOne();
		}
		
		List<Employee11> employeeList = oneToOneDao.getEmployee();
		for(Employee11 emp : employeeList) {
			System.out.println("Employee Details::-->"+emp.toString());
			System.out.println("Address Details::-->"+emp.getAddress().toString());
		}
	}

	private void addEmployeeOneToOne() {
		Employee11 e1 = new Employee11();
		e1.setName("Ravi Malik");
		e1.setEmail("ravi@gmail.com");

		Address11 address1 = new Address11();
		address1.setAddressLine1("G-21,Lohia nagar");
		address1.setCity("Ghaziabad");
		address1.setState("UP");
		address1.setCountry("India");
		address1.setPincode(201301);

		e1.setAddress(address1);

		oneToOneDao.addEmployee(e1);
	}

}
