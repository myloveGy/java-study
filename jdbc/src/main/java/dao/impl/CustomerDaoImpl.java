package dao.impl;

import dao.BaseDAO;
import dao.CustomerDao;
import model.Customer;

import java.util.List;

public class CustomerDaoImpl extends BaseDAO<Customer> implements CustomerDao {

    @Override
    public void insert(Customer customer) {
        String sql = "INSERT INTO `customers` (`name`, `email`, `birth`) VALUES (?, ?, ?)";
        update(sql, customer.getEmail(), customer.getBirth());
    }

    @Override
    public void deleteById(int id) {
        update("DELETE FROM `customers` WHERE `id` = ?", id);
    }

    @Override
    public void update(Customer customer) {
        update(
                "UPDATE `customers` SET `name` = ?, `email` = ?, `birth` = ? WHERE `id` = ?",
                customer.getName(),
                customer.getEmail(),
                customer.getBirth(),
                customer.getId()
        );
    }

    @Override
    public Customer getById(int id) {
        return find("SELECT `id`, `name`, `email`, `birth` FROM `customers` WHERE `id` = ?",  id);
    }

    @Override
    public List<Customer> getAll() {
        return findAll("SELECT `id`, `name`, `email`, `birth` FROM `customers`");
    }

    public Long count() {
        return findBy("SELECT COUNT(*) FROM `customers`");
    }
}
