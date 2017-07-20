package action;

import model.BookDes;
import service.DetailService;

public class GetBookDetailAction extends BaseAction{

    private static final long serialVersionUID = 1L;

    private DetailService detailService;

    private int id;

    private BookDes bookDes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookDes getBookDes() {
        return bookDes;
    }

    public void setBookDes(BookDes bookDes) {
        this.bookDes = bookDes;
    }

    public void setDetailService (DetailService detailService) { this.detailService = detailService; }

    public String execute() throws Exception {
        BookDes bookDes = new BookDes(id, detailService.getDescriptionById(id));
        setBookDes(bookDes);
        return SUCCESS;
    }
}
