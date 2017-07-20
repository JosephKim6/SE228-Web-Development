package dao.impl;

import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import dao.UserDetailDao;
import model.UserDes;
import model.UserImg;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class UserDetailDaoImpl implements UserDetailDao {

    private MongoTemplate mongoTemplate;

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void save(UserDes userDes, UserImg userImg){
        try {
            mongoTemplate.upsert(new Query(Criteria.where("_id").is(userDes.getId())),
                    new Update().set("description", userDes.getDescription()), UserDes.class, "users");
            DB db = mongoTemplate.getDb();
            GridFS gridFS = new GridFS(db, "userimage");
            GridFSDBFile file = gridFS.findOne(Integer.toString(userImg.getId()));
            if (file != null) {
                gridFS.remove(file);
            }
            GridFSInputFile gfs = gridFS.createFile(userImg.getImage());
            gfs.setFilename(Integer.toString(userImg.getId()));
            gfs.save();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try {
            mongoTemplate.remove(new Query(Criteria.where("_id").is(id)), UserDes.class, "users");
            DB db = mongoTemplate.getDb();
            GridFS gridFS = new GridFS(db, "userimage");
            GridFSDBFile file = gridFS.findOne(Integer.toString(id));
            gridFS.remove(file);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getDescriptionById(int id) {
        UserDes userDes = mongoTemplate.findById(id, UserDes.class, "users");
        if (userDes == null) {
            return "";
        }
        return userDes.getDescription();
    }

    public GridFSDBFile getImageById(int id){
        DB db = mongoTemplate.getDb();
        GridFS gridFS = new GridFS(db, "userimage");
        GridFSDBFile gridFSDBFile =  gridFS.findOne(Integer.toString(id));
        return gridFSDBFile;
    }

    public void saveDes(UserDes userDes) {
        try {
            mongoTemplate.upsert(new Query(Criteria.where("_id").is(userDes.getId())),
                    new Update().set("description", userDes.getDescription()), UserDes.class, "users");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveImg(UserImg userImg) {
        try {
            DB db = mongoTemplate.getDb();
            GridFS gridFS = new GridFS(db, "userimage");
            GridFSDBFile file = gridFS.findOne(Integer.toString(userImg.getId()));
            if (file != null) {
                gridFS.remove(file);
            }
            GridFSInputFile gfs = gridFS.createFile(userImg.getImage());
            gfs.setFilename(Integer.toString(userImg.getId()));
            gfs.save();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
