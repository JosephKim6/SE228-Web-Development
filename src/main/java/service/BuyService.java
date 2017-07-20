package service;

import model.Order;

import java.sql.Timestamp;
import java.util.List;

public interface BuyService {
    public boolean check();

    public Integer buyBook(int id, int amount);

    public Integer payMoney(Timestamp date);

    public Integer deleteBuy(int id);

    public List<Order> getMyOrders();
}
