package action;

import com.opensymphony.xwork2.ActionContext;
import model.User;
import model.UserDes;
import service.DetailService;

public class ChangeProfileAction extends BaseAction{

    private static final long serialVersionUID = 1L;

    private String description;

    private DetailService detailService;

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public void setDetailService(DetailService detailService) { this.detailService = detailService; }

    public String execute() throws Exception {
        User user = (User)ActionContext.getContext().getSession().get("user");
        UserDes userDes = new UserDes(user.getId(), description);
        detailService.updateUserDes(userDes);
        return SUCCESS;
    }
}
