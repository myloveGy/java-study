package customer;

public class Model {
    private final Customer[] customers;

    private int total = 0;

    /**
     * 初始化数组的
     *
     * @param totalCustomer 设置数组的长度
     */
    public Model(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    public boolean create(Customer customer) {
        if (total >= customers.length) {
            return false;
        }

        customers[total++] = customer;
        return true;
    }

    public boolean update(int index, Customer customer) {
        if (isErrorIndex(index)) {
            return false;
        }

        customers[index] = customer;
        return true;
    }

    public boolean delete(int index) {

        if (isErrorIndex(index)) {
            return false;
        }

        if (total - index >= 0) {
            System.arraycopy(customers, index + 1, customers, index, total - index);
        }

        // 最后一个元素需要置空
        customers[total--] = null;

        return true;
    }

    public Customer[] getCustomerList() {
        Customer[] list = new Customer[total];
        if (total >= 0) {
            System.arraycopy(customers, 0, list, 0, total);
        }

        return list;
    }

    public int getTotal() {
        return total;
    }

    public Customer getCustomer(int index) {

        if (isErrorIndex(index)) {
            return null;
        }

        return customers[index];
    }

    private boolean isErrorIndex(int index) {
        return index < 0 || index >= total;
    }
}