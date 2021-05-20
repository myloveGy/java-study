package dao.impl;

import model.Customer;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

public class CustomerDaoImplTest {

    @Test
    public void insert() throws Exception {
        new CustomerDaoImpl().insert(new Customer(1, "jinxing.liu", "821901008@qq.com", new Date(new java.util.Date().getTime())));
    }

    @Test
    public void deleteById() throws Exception {
        new CustomerDaoImpl().deleteById(24);
    }

    @Test
    public void update() throws Exception {
        new CustomerDaoImpl().update(new Customer(25, "my test", "time@qq.com", new Date(new java.util.Date().getTime())));
    }

    @Test
    public void getById() throws Exception {
        Customer customer = new CustomerDaoImpl().getById(25);
        System.out.println(customer);
    }

    @Test
    public void getAll() throws Exception {
        List<Customer> customers = new CustomerDaoImpl().getAll();
        System.out.println(customers);
    }

    @Test
    public void count() {
        Long count = new CustomerDaoImpl().count();
        System.out.println(count);
    }
}