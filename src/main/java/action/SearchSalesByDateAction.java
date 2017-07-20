package action;

import model.Order;
import service.AppService;

import java.sql.Timestamp;
import java.util.List;

public class SearchSalesByDateAction extends BaseAction{

    private static final long serialVersionUID = 1L;

    private Timestamp startDate;
    private Timestamp endDate;
    private List<Order> orderList;

    private AppService appService;

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
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
        List<Order> orderList = appService.searchSalesByDate(startDate, endDate);
        setOrderList(orderList);
        return SUCCESS;
    }
}