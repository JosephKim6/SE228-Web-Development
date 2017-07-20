package model;

import java.io.File;

public class BookDetail {
    private int id;
    private String description;
    private File image;

    public BookDetail () {}

    public BookDetail(int id, String description, File image){
        this.id = id;
        this.description = description;
        this.image = image;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description) { this.description = description; }

    public File getImage() { return image; }

    public void setImage(File image) { this.image = image; }

}
