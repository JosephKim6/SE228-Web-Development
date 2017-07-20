package action;

import model.User;
import model.UserDes;
import model.UserImg;
import service.AppService;
import service.DetailService;

import java.io.File;

public class UpdateUserAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private int id;
	private String username;
	private String password;
	private String role;
	private String description;
	private File image;

	private AppService appService;
	private DetailService detailService;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	public void setDetailService(DetailService detailService) {
		this.detailService = detailService;
	}

	@Override
	public String execute() throws Exception {

		User user = appService.getUserById(id);
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		appService.updateUser(user);

		UserDes userDes = new UserDes(id, description);
		UserImg userImg = new UserImg(id, image);
		detailService.updateUserProfile(userDes, userImg);

		return SUCCESS;
	}

}
