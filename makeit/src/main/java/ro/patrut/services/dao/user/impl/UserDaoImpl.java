package ro.patrut.services.dao.user.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import ro.patrut.config.AbstractDao;
import ro.patrut.models.user.UserModel;
import ro.patrut.services.dao.user.UserDao;

public class UserDaoImpl extends AbstractDao<Integer, UserModel> implements UserDao {

	@Override
	public UserModel findById(int id) {
		return getByKey(id);
	}

	@Override
	public UserModel findBySSo(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		return (UserModel) crit.uniqueResult();
	}

}
