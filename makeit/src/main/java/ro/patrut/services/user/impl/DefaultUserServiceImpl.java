package ro.patrut.services.user.impl;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import ro.patrut.models.user.User;
import ro.patrut.services.dao.user.UserDao;
import ro.patrut.services.user.UserService;

@Transactional
public class DefaultUserServiceImpl implements UserService{

	UserDao userDao;

	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}
	@Override
	public User findBySso(String sso) {
		return userDao.findBySSo(sso);
	}

	@Required
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
