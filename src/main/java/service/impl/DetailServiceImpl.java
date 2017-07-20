package service.impl;

import com.mongodb.gridfs.GridFSDBFile;
import com.opensymphony.xwork2.ActionContext;
import dao.UserDetailDao;
import model.BookDetail;
import model.User;
import model.UserDes;
import model.UserImg;
import service.DetailService;
import dao.BookDetailDao;

import java.io.File;

public class DetailServiceImpl implements DetailService {
    private BookDetailDao bookDetailDao;
    private UserDetailDao userDetailDao;

    public void setBookDetailDao(BookDetailDao bookDetailDao) {
        this.bookDetailDao = bookDetailDao;
    }

    public void setUserDetailDao(UserDetailDao userDetailDao) {
        this.userDetailDao = userDetailDao;
    }

    public void addBookDetail(BookDetail bookDetail) {
        bookDetailDao.save(bookDetail);
    }

    public void deleteBookDetail(int id) {
        bookDetailDao.delete(id);
    }

    public void deleteUserDetail(int id) {
        userDetailDao.delete(id);
    }

    public void updateBookDetail(BookDetail bookDetail) {
        bookDetailDao.update(bookDetail);
    }

    public String getDescriptionById(int id) {
        return bookDetailDao.getDescriptionById(id);
    }

    public GridFSDBFile getBookImageById(int id) {
        return bookDetailDao.getImageById(id);
    }

    public String getUserDescription() {
        User user = (User)ActionContext.getContext().getSession().get("user");
        String des =  userDetailDao.getDescriptionById(user.getId());
        if (des.equals("")) {
            des = "No self description yet. Try adding one!";
        }
        return des;
    }

    public GridFSDBFile getUserImage() {
        User user = (User)ActionContext.getContext().getSession().get("user");
        return userDetailDao.getImageById(user.getId());
    }

    public void updateUserProfile(UserDes userDes, UserImg userImg) {
        userDetailDao.save(userDes, userImg);
    }

    public void updateUserDes(UserDes userDes) {
        userDetailDao.saveDes(userDes);
    }

    public void updateUserImg(UserImg userImg) {
        userDetailDao.saveImg(userImg);
    }

    public String getUserDescriptionById(int id) {
        String des = userDetailDao.getDescriptionById(id);
        return des;
    }
}
