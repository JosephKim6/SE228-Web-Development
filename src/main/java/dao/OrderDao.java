package dao;

import java.sql.Timestamp;
import java.util.List;

import model.Order;

public interface OrderDao {

	public Integer save(Order order);

	public void delete(Order order);

	public void update(Order order);

	public Order getOrderById(int id);

	public List<Order> getAllOrders();

	public List<Order> searchSalesByUser(int userID);

	public List<Order> searchSalesByBook(int bookID);

	public List<Order> searchSalesByDate(Timestamp startDate, Timestamp endDate);

}