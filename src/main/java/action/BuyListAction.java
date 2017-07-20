package action;

import java.util.List;

import model.Book;
import service.AppService;
import service.BuyService;

public class BuyListAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    private AppService appService;
    private BuyService buyService;

    public void setAppService(AppService appService) {
        this.appService = appService;
    }

    public void setBuyService(BuyService buyService) {
        this.buyService = buyService;
    }

    @Override
    public String execute() throws Exception {

        List<Book> books = appService.getAllBooks();
        request().setAttribute("books", books);
        boolean flag = buyService.check();
        return flag ? SUCCESS : ERROR;
    }
}
