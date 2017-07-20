package action;

import service.BuyService;

public class BuyBookAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    private int id;
    private int amount;

    private BuyService buyService;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public void setBuyService(BuyService buyService) {
        this.buyService = buyService;
    }

    @Override
    public String execute() throws Exception {
        buyService.buyBook(id, amount);
        return SUCCESS;
    }
}
