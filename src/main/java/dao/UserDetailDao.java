package dao;

import com.mongodb.gridfs.GridFSDBFile;
import model.UserDes;
import model.UserImg;

public interface UserDetailDao {
    public void save(UserDes userDes, UserImg userImg);

    public void delete(int id);

    public String getDescriptionById(int id);

    public GridFSDBFile getImageById(int id);

    public void saveDes(UserDes userDes);

    public void saveImg(UserImg userImg);
}
