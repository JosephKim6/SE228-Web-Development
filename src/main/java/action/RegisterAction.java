package action;

import java.io.InputStream;
import java.io.ByteArrayInputStream;

import model.User;
import service.UserService;

public class RegisterAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private String role;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute() throws Exception {
        User user = new User(username, password, role);
        Integer flag = userService.register(user);
        if (flag == 0){
            inputStream = new ByteArrayInputStream("success".getBytes("UTF-8"));
        }
        else {
            inputStream = new ByteArrayInputStream("error".getBytes("UTF-8"));
        }
        return SUCCESS;
    }

}