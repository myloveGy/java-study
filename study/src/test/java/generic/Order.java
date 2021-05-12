package generic;

import java.util.ArrayList;
import java.util.List;

public class Order<T> {
    String orderName;

    int orderId;

    T orderT;

    public Order() {

    }

    public Order(int id, String name, T orderT) {
        this.orderId = id;
        this.orderName = name;
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    public <E> List <E> copyArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e: arr) {
            list.add(e);
        }

        return list;
    }
}
