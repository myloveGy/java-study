package dao;

import model.Customer;

import java.util.List;

public interface CustomerDao {
    /**
     * 新增数据
     *
     * @param customer 对象
     */
    void insert(Customer customer);

    /**
     * 通过ID删除
     *
     * @param id ID
     */
    void deleteById(int id);

    /**
     * 修改
     *
     * @param customer 对象
     */
    void update(Customer customer);

    Customer getById(int id);

    List<Customer> getAll();
}
