package action;

import com.opensymphony.xwork2.ActionContext;
import model.User;

public class CheckUserAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    @Override
    public String execute() throws Exception {
        User test = (User)ActionContext.getContext().getSession().get("user");
        if (test == null){
            return LOGIN;
        }
        else if (test.getRole().equals("1")){
            return SUCCESS;
        }
        else{
            return NONE;
        }
    }

}