package action;


import model.Book;
import model.Order;
import service.BuyService;
import service.AppService;

import java.util.List;

public class MyOrderAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    private BuyService buyService;
    private AppService appService;

    public void setBuyService(BuyService buyService) {
        this.buyService = buyService;
    }

    public void setAppService(AppService appService){
        this.appService = appService;
    }

    @Override
    public String execute() throws Exception {
        List<Order> orders = buyService.getMyOrders();
        request().setAttribute("orders", orders);

        List<Book> books = appService.getAllBooks();
        request().setAttribute("books", books);
        return SUCCESS;
    }
}
