package action;

import model.Order;
import service.AppService;

import java.util.List;

public class SearchSalesByUserAction extends BaseAction{

    private static final long serialVersionUID = 1L;

    private int userID;
    private List<Order> orderList;

    private AppService appService;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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
        List<Order> orderList = appService.searchSalesByUser(userID);
        setOrderList(orderList);
        return SUCCESS;
    }
}
