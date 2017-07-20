package action;

import model.Book;
import model.User;
import service.AppService;

import java.util.List;

public class SalesAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    private AppService appService;

    public void setAppService(AppService appService) {
        this.appService = appService;
    }

    @Override
    public String execute() throws Exception {

        List<Book> books = appService.getAllBooks();
        request().setAttribute("books", books);

        List<User> users = appService.getAllUsers();
        request().setAttribute("users", users);

        return SUCCESS;
    }
}
