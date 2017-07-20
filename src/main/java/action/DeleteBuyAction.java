package action;

import service.BuyService;

public class DeleteBuyAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    private int id;

    private BuyService buyService;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBuyService(BuyService buyService) {
        this.buyService = buyService;
    }

    @Override
    public String execute() throws Exception {
        buyService.deleteBuy(id);
        return SUCCESS;
    }
}
