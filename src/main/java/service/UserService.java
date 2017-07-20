package service;

import model.User;

public interface UserService {

    public Integer register(User user);

    public Integer login(String username, String password);

    public Integer logout();
}
