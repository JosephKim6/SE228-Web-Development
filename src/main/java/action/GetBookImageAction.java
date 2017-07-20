package action;

import com.mongodb.gridfs.GridFSDBFile;

import java.io.File;

import service.DetailService;

public class GetBookImageAction extends BaseAction{

    private static final long serialVersionUID = 1L;

    private int id;
    private GridFSDBFile gridFSDBFile;

    private DetailService detailService;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public GridFSDBFile getGridFSDBFile() { return gridFSDBFile; }

    public void setGridFSDBFile(GridFSDBFile gridFSDBFile) { this.gridFSDBFile = gridFSDBFile; }

    public void setDetailService (DetailService detailService) { this.detailService = detailService; }

    public String execute() throws Exception {
        File f = new File("/Users/kevinjyx/IdeaProjects/BookStore/target/BookStore/bookstore/images/tmp.jpg");
        gridFSDBFile = detailService.getBookImageById(id);
        gridFSDBFile.writeTo(f);
        return null;
    }
}