package action;

import model.UserDes;
import service.DetailService;

public class GetUserDescriptionAction extends BaseAction{

    private static final long serialVersionUID = 1L;

    private DetailService detailService;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDetailService (DetailService detailService) { this.detailService = detailService; }

    public String execute() throws Exception {
        String description = detailService.getUserDescription();
        setDescription(description);
        return SUCCESS;
    }
}