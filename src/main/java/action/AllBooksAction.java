package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import model.Book;
import model.User;
import service.AppService;

public class AllBooksAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private AppService appService;

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	@Override
	public String execute() throws Exception {

		List<Book> books = appService.getAllBooks();
		request().setAttribute("books", books);
		User test = (User) ActionContext.getContext().getSession().get("user");
		if (test != null && test.getRole().equals("0")){
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
}
