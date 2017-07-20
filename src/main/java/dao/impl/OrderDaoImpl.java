package dao.impl;

import java.sql.Timestamp;
import java.util.List;

import model.Order;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.OrderDao;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {

	public Integer save(Order order) {
		return (Integer) getHibernateTemplate().save(order);
	}

	public void delete(Order order) {
		getHibernateTemplate().delete(order);
	}

	public void update(Order order) {
		getHibernateTemplate().merge(order);
	}

	public Order getOrderById(int id) {
		@SuppressWarnings("unchecked")
		List<Order> orders = (List<Order>) getHibernateTemplate().find(
				"from Order as o where o.id=?", id);
		Order order = orders.size() > 0 ? orders.get(0) : null;
		return order;
	}

	public List<Order> getAllOrders() {
		@SuppressWarnings("unchecked")
		List<Order> orders = (List<Order>) getHibernateTemplate().find(
				"from Order");
		return orders;
	}

	public List<Order> searchSalesByUser(int userID) {
		Session session = getSession();
		SQLQuery query = session.createSQLQuery("{Call searchSalesByUserID(?)}");
		query.setString(0, String.valueOf(userID));
		List<Order> list = query.list();
		return list;
	}

	public List<Order> searchSalesByBook(int bookID) {
		Session session = getSession();
		SQLQuery query = session.createSQLQuery("{Call searchSalesByBookID(?)}");
		query.setString(0, String.valueOf(bookID));
		List<Order> list = query.list();
		return list;
	}

	public List<Order> searchSalesByDate(Timestamp startDate, Timestamp endDate) {
		Session session = getSession();
		SQLQuery query = session.createSQLQuery("{Call searchSalesByDate(?,?)}");
		query.setString(0, String.valueOf(startDate));
		query.setString(1, String.valueOf(endDate));
		List<Order> list = query.list();
		return list;
	}
}
