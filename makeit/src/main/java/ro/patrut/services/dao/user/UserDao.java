package ro.patrut.services.dao.user;

import ro.patrut.models.user.User;

public interface UserDao {
	User findById(int id);

	User findBySSo(String sso);

}
