package ro.patrut.services.dao.user.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import ro.patrut.config.AbstractDao;
import ro.patrut.models.user.User;
import ro.patrut.services.dao.user.UserDao;

public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Override
	public User findById(int id) {
		return getByKey(id);
	}

	@Override
	public User findBySSo(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		return (User) crit.uniqueResult();
	}

}
