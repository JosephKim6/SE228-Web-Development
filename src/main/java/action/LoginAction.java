package action;

import java.io.InputStream;
import java.io.ByteArrayInputStream;

import service.UserService;

public class LoginAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    private InputStream inputStream;

    private UserService userService;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute() throws Exception {
        Integer flag = userService.login(username, password);
        if (flag == 0){
            inputStream = new ByteArrayInputStream("success".getBytes("UTF-8"));
        }
        else {
            inputStream = new ByteArrayInputStream("error".getBytes("UTF-8"));
        }
        return SUCCESS;
    }

}