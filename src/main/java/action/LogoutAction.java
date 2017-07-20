package action;

import service.UserService;

public class LogoutAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute() throws Exception {
        userService.logout();
        return SUCCESS;
    }

}