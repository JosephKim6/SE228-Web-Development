package action;

import model.Orderitem;
import service.AppService;

import java.math.BigDecimal;

public class AddOrderitemAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private int orderid;
	private int bookid;
	private BigDecimal price;
	private int amount;

	private AppService appService;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	@Override
	public String execute() throws Exception {

		Orderitem orderitem = new Orderitem(orderid, bookid, price, amount);
		appService.addOrderitem(orderitem);

		return SUCCESS;
	}

}
