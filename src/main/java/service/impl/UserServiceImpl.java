package service.impl;

import com.opensymphony.xwork2.ActionContext;
import dao.UserDao;
import model.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public Integer register(User user){
        User ui;
        List list = userDao.getAllUsers();
        for (int i = 0; i < list.size(); i++){
            ui = (User)list.get(i);
            if (ui.getUsername().equals(user.getUsername())){
                return 1;
            }
        }
        userDao.save(user);
        ActionContext.getContext().getSession().put("user", user);
        return 0;
    }

    public Integer login(String username, String password){
        User user = userDao.getUserByName(username);
        if (user == null || !user.getPassword().equals(password)){
            return 1;
        }
        else{
            ActionContext.getContext().getSession().clear();
            ActionContext.getContext().getSession().put("user", user);
            return 0;
        }
    }

    public Integer logout(){
        ActionContext.getContext().getSession().clear();
        return 0;
    }
}
