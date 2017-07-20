package action;

import com.opensymphony.xwork2.ActionContext;
import service.DetailService;

import java.io.*;

import com.mongodb.gridfs.GridFSDBFile;

import model.User;

public class MyProfileAction extends BaseAction{

    private static final long serialVersionUID = 1L;

    private DetailService detailService;

    public void setDetailService (DetailService detailService) { this.detailService = detailService; }

    public String execute() throws Exception {
        String description = detailService.getUserDescription();
        request().setAttribute("description", description);

        User user = (User) ActionContext.getContext().getSession().get("user");
        request().setAttribute("user", user);

        File f = new File("/Users/kevinjyx/IdeaProjects/BookStore/target/BookStore/bookstore/images/tmp.jpg");
        GridFSDBFile gridFSDBFile = detailService.getUserImage();
        if (gridFSDBFile == null) {
            File tmp = new File("/Users/kevinjyx/IdeaProjects/BookStore/target/BookStore/bookstore/images/timg.jpg");
            InputStream input = new FileInputStream(tmp);
            OutputStream output = new FileOutputStream(f);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
            input.close();
            output.close();
        }
        else {
            gridFSDBFile.writeTo(f);
        }
        return SUCCESS;
    }

}
