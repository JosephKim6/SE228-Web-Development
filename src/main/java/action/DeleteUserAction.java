package action;

import model.User;
import service.AppService;
import service.DetailService;


public class DeleteUserAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private int id;

	private AppService appService;
	private DetailService detailService;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		appService.deleteUser(user);

		detailService.deleteUserDetail(id);

		return SUCCESS;
	}

}
