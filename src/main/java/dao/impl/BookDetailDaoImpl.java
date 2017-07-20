package dao.impl;

import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import model.BookDetail;
import model.BookDes;
import dao.BookDetailDao;


public class BookDetailDaoImpl implements BookDetailDao {

    private MongoTemplate mongoTemplate;

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void save(BookDetail bookDetail) {
        try {
            BookDes bookDes = new BookDes(bookDetail.getId(), bookDetail.getDescription());
            mongoTemplate.insert(bookDes, "books");
            DB db = mongoTemplate.getDb();
            GridFS gridFS = new GridFS(db, "bookimage");
            GridFSInputFile gfs = gridFS.createFile(bookDetail.getImage());
            gfs.setFilename(Integer.toString(bookDetail.getId()));
            gfs.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            mongoTemplate.remove(new Query(Criteria.where("_id").is(id)), BookDes.class, "books");
            DB db = mongoTemplate.getDb();
            GridFS gridFS = new GridFS(db, "bookimage");
            GridFSDBFile file = gridFS.findOne(Integer.toString(id));
            gridFS.remove(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(BookDetail bookDetail) {
        try {
            BookDes bookDes = new BookDes(bookDetail.getId(), bookDetail.getDescription());
            mongoTemplate.upsert(new Query(Criteria.where("_id").is(bookDes.getId())),
                    new Update().set("description", bookDes.getDescription()), BookDes.class, "books");
            DB db = mongoTemplate.getDb();
            GridFS gridFS = new GridFS(db, "bookimage");
            GridFSDBFile file = gridFS.findOne(Integer.toString(bookDetail.getId()));
            gridFS.remove(file);
            GridFSInputFile gfs = gridFS.createFile(bookDetail.getImage());
            gfs.setFilename(Integer.toString(bookDetail.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDescriptionById(int id) {
        BookDes bookDes = mongoTemplate.findById(id, BookDes.class, "books");
        return bookDes.getDescription();
    }

    public GridFSDBFile getImageById(int id) {
        DB db = mongoTemplate.getDb();
        GridFS gridFS = new GridFS(db, "bookimage");
        return gridFS.findOne(Integer.toString(id));
    }
}
