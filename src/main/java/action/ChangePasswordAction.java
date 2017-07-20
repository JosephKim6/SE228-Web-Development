package action;


import com.opensymphony.xwork2.ActionContext;
import model.User;
import service.AppService;

public class ChangePasswordAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    private String password;

    private AppService appService;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAppService(AppService appService) {
        this.appService = appService;
    }

    @Override
    public String execute() throws Exception {

        User user = (User) ActionContext.getContext().getSession().get("user");
        user.setPassword(password);
        appService.updateUser(user);

        return SUCCESS;
    }
}
