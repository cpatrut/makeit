package ro.patrut.services.user;

import ro.patrut.models.user.UserModel;

public interface UserService {
	UserModel findById(int id);

	UserModel findBySso(String sso);
}
