package action;

import model.Order;
import service.AppService;

import java.util.List;

public class SearchSalesByBookAction extends BaseAction{

    private static final long serialVersionUID = 1L;

    private int bookID;
    private List<Order> orderList;

    private AppService appService;

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void setAppService(AppService appService) {
        this.appService = appService;
    }

    @Override
    public String execute() throws Exception {
        List<Order> orderList = appService.searchSalesByBook(bookID);
        setOrderList(orderList);
        return SUCCESS;
    }
}
