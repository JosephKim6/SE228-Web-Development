package service.impl;

import com.opensymphony.xwork2.ActionContext;
import dao.BookDao;
import dao.OrderDao;
import dao.OrderitemDao;
import model.User;
import model.Book;
import model.Order;
import model.Orderitem;
import service.BuyService;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.math.BigDecimal;

public class BuyServiceImpl implements BuyService {

    private BookDao bookDao;
    private OrderDao orderDao;
    private OrderitemDao orderitemDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setOrderitemDao(OrderitemDao orderitemDao) {
        this.orderitemDao = orderitemDao;
    }


    public boolean check(){
        User test = (User) ActionContext.getContext().getSession().get("user");
        if (test != null && test.getRole().equals("1")){
            return true;
        }
        else{
            return false;
        }
    }

    public Integer buyBook(int id, int amount){
        Map<Integer, Integer> cart = (Map<Integer, Integer>)ActionContext.getContext().getSession().get("cart");
        if (cart == null){
            cart = new HashMap<>();
        }
        if (cart.containsKey(id)){
            int number = cart.get(id);
            cart.put(id, number + amount);
        }
        else{
            cart.put(id, amount);
        }
        ActionContext.getContext().getSession().put("cart", cart);
        return 0;
    }

    public Integer payMoney(Timestamp date){
        Map<Integer, Integer> cart = (Map<Integer, Integer>) ActionContext.getContext().getSession().get("cart");
        User user = (User) ActionContext.getContext().getSession().get("user");
        List<Book> bookList = bookDao.getAllBooks();

        Order order = new Order(user.getId(), date);
        orderDao.save(order);
        Integer orderid = order.getId();

        BigDecimal price = new BigDecimal(0);
        for (Map.Entry<Integer, Integer> entry : cart.entrySet()){
            int bookid = entry.getKey();
            int amount = entry.getValue();
            for (Book book : bookList){
                if (book.getId() == bookid){
                    price = book.getPrice();
                    break;
                }
            }
            Orderitem orderitem = new Orderitem(orderid, bookid, price, amount);
            orderitemDao.save(orderitem);
        }
        ActionContext.getContext().getSession().remove("cart");
        return 0;
    }

    public Integer deleteBuy(int id){
        Map<Integer, Integer> cart = (Map<Integer, Integer>) ActionContext.getContext().getSession().get("cart");
        cart.remove(id);
        ActionContext.getContext().getSession().put("cart", cart);
        return 0;
    }

    public List<Order> getMyOrders(){
        User user = (User) ActionContext.getContext().getSession().get("user");
        List<Order> allOrders = orderDao.getAllOrders();
        Iterator<Order> it = allOrders.iterator();
        while (it.hasNext()){
            Order order = it.next();
            if (order.getUserid() != user.getId()){
                it.remove();
            }
        }
        return allOrders;
    }
}
