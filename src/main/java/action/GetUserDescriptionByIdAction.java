package action;

import service.DetailService;

public class GetUserDescriptionByIdAction extends BaseAction{

    private static final long serialVersionUID = 1L;

    private DetailService detailService;

    private int id;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDetailService (DetailService detailService) { this.detailService = detailService; }

    public String execute() throws Exception {
        String description = detailService.getUserDescriptionById(id);
        setDescription(description);
        return SUCCESS;
    }
}
