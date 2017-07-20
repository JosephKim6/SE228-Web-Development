package service;

import com.mongodb.gridfs.GridFSDBFile;
import model.BookDetail;
import model.UserDes;
import model.UserImg;

public interface DetailService {

    public void addBookDetail(BookDetail bookDetail);

    public void deleteBookDetail(int id);

    public void deleteUserDetail(int id);

    public void updateBookDetail(BookDetail bookDetail);

    public String getDescriptionById(int id);

    public GridFSDBFile getBookImageById(int id);

    public String getUserDescription();

    public String getUserDescriptionById(int id);

    public GridFSDBFile getUserImage();

    public void updateUserProfile(UserDes userDes, UserImg userImg);

    public void updateUserDes(UserDes userDes);

    public void updateUserImg(UserImg userImg);
}
