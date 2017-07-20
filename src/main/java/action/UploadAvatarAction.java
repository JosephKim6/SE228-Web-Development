package action;

import com.opensymphony.xwork2.ActionContext;
import model.User;
import model.UserImg;
import service.DetailService;

import java.io.File;

public class UploadAvatarAction extends BaseAction{

    private static final long serialVersionUID = 1L;
    private File image;

    private DetailService detailService;

    public File getImage() { return image; }

    public void setImage(File image) { this.image = image; }

    public void setDetailService(DetailService detailService) { this.detailService = detailService; }

    public String execute() throws Exception {
        User user = (User)ActionContext.getContext().getSession().get("user");
        UserImg userImg = new UserImg(user.getId(), image);
        detailService.updateUserImg(userImg);
        return SUCCESS;
    }
}
