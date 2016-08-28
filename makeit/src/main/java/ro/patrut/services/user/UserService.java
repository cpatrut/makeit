package ro.patrut.services.user;

import ro.patrut.models.user.User;

public interface UserService {
	User findById(int id);

	User findBySso(String sso);
}
