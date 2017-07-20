package interceptor;

import model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;


public class UserInterceptor extends MethodFilterInterceptor {

    private static final long serialVersionUID = 1L;

    protected String doIntercept(ActionInvocation invoker) throws Exception {
        User test = (User)ActionContext.getContext().getSession().get("user");
        if (test == null || !test.getRole().equals("1")){
            return "login";
        }
        return invoker.invoke();
    }
}
