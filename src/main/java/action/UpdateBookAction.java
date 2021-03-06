package action;

import java.io.File;
import java.sql.Date;

import model.Book;
import model.BookDetail;
import service.AppService;
import service.DetailService;
import java.math.BigDecimal;

public class UpdateBookAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private int id;
	private String title;
	private String author;
	private BigDecimal price;
	private String publisher;
	private Date date;
	private String description;
	private File image;

	private AppService appService;
	private DetailService detailService;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public File getImage() { return image; }

	public void setImage(File image) {
		this.image = image;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	public void setDetailService(DetailService detailService) { this.detailService = detailService; }

	@Override
	public String execute() throws Exception {

		Book book = appService.getBookById(id);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPrice(price);
		book.setPublisher(publisher);
		book.setDate(date);
		appService.updateBook(book);

		BookDetail bookDetail = new BookDetail();
		bookDetail.setId(id);
		bookDetail.setDescription(description);
		bookDetail.setImage(image);
		detailService.updateBookDetail(bookDetail);

		return SUCCESS;
	}

}
