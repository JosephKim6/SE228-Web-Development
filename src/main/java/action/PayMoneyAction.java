package action;

import java.sql.Timestamp;

import service.BuyService;

public class PayMoneyAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    private Timestamp date;

    private BuyService buyService;

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setBuyService(BuyService buyService) {
        this.buyService = buyService;
    }

    @Override
    public String execute() throws Exception {
        buyService.payMoney(date);
        /*Map<Integer, Integer> cart = (Map<Integer, Integer>) ActionContext.getContext().getSession().get("cart");
        User user = (User) ActionContext.getContext().getSession().get("user");
        List<Book> bookList = appService.getAllBooks();

        Order order = new Order(user.getId(), date);
        appService.addOrder(order);
        Integer orderid = order.getId();

        BigDecimal price = new BigDecimal(0);
        for (Map.Entry<Integer, Integer> entry : cart.entrySet()){
            int bookid = entry.getKey();
            int amount = entry.getValue();
            for (Book book : bookList){
                if (book.getId() == bookid){
                    price = book.getPrice();
                    break;
                }
            }
            Orderitem orderitem = new Orderitem(orderid, bookid, price, amount);
            appService.addOrderitem(orderitem);
        }
        ActionContext.getContext().getSession().remove("cart");*/
        return SUCCESS;
    }
}