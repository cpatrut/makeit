package ro.patrut.services.dao.user;

import ro.patrut.models.user.UserModel;

public interface UserDao {
	UserModel findById(int id);

	UserModel findBySSo(String sso);

}
