package action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import model.Book;
import service.AppService;

public class GetCartAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    private AppService appService;

    public void setAppService(AppService appService) {
        this.appService = appService;
    }

    @Override
    public String execute() throws Exception {
        Map<Integer, Integer> cart = (Map<Integer, Integer>) ActionContext.getContext().getSession().get("cart");
        request().setAttribute("cart", cart);
        List<Book> books = appService.getAllBooks();
        request().setAttribute("books", books);
        return SUCCESS;
    }
}