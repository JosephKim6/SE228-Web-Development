package dao;

import com.mongodb.gridfs.GridFSDBFile;
import model.BookDetail;

public interface BookDetailDao {
    public void save(BookDetail bookDetail);

    public void delete(int id);

    public void update(BookDetail bookDetail);

    public String getDescriptionById(int id);

    public GridFSDBFile getImageById(int id);
}
