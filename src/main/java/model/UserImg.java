package model;

import java.io.File;

public class UserImg {
    private int id;
    private File image;

    public UserImg () {}

    public UserImg(int id, File image){
        this.id = id;
        this.image = image;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) { this.id = id; }

    public File getImage() { return image; }

    public void setImage(File image) { this.image = image; }

}
