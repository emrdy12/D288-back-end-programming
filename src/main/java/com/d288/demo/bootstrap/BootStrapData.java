package com.d288.demo.bootstrap;

import com.d288.demo.dao.CustomerRepository;
import com.d288.demo.dao.DivisionRepository;
import com.d288.demo.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run (String... args) throws Exception {

        Customer customer1 = new Customer();
        customer1.setFirstName("Becky");
        customer1.setLastName("Smith");
        customer1.setPostal_code("90210");
        customer1.setAddress("123 Juniper St");
        customer1.setPhone("(555)-210-8904");
        customer1.setDivision(divisionRepository.findAll().get(3));
        customer1.setCreate_date(new Date());
        customer1.setLast_update(new Date());

        Customer customer2 = new Customer();
        customer2.setFirstName("Jebidiah");
        customer2.setLastName("Johnson");
        customer2.setPostal_code("78333");
        customer2.setAddress("321 Maple St");
        customer2.setPhone("(555)-932-8474");
        customer2.setDivision(divisionRepository.findAll().get(5));
        customer2.setCreate_date(new Date());
        customer2.setLast_update(new Date());

        Customer customer3 = new Customer();
        customer3.setFirstName("Rocky");
        customer3.setLastName("Balboa");
        customer3.setPostal_code("98321");
        customer3.setAddress("543 Elm St");
        customer3.setPhone("(555)-342-0987");
        customer3.setDivision(divisionRepository.findAll().get(7));
        customer3.setCreate_date(new Date());
        customer3.setLast_update(new Date());

        Customer customer4 = new Customer();
        customer4.setFirstName("Sharonda");
        customer4.setLastName("Jackson");
        customer4.setPostal_code("80250");
        customer4.setAddress("444 Oak St");
        customer4.setPhone("(555)-620-7929");
        customer4.setDivision(divisionRepository.findAll().get(3));
        customer4.setCreate_date(new Date());
        customer4.setLast_update(new Date());

        Customer customer5 = new Customer();
        customer5.setFirstName("William");
        customer5.setLastName("Shakespear");
        customer5.setPostal_code("93350");
        customer5.setAddress("947 Locust St");
        customer5.setPhone("(555)-782-8412");
        customer5.setDivision(divisionRepository.findAll().get(7));
        customer5.setCreate_date(new Date());
        customer5.setLast_update(new Date());

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);

    }
}
