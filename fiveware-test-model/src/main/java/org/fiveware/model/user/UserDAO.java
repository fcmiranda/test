package org.fiveware.model.user;

import java.util.List;

import org.fiveware.dao.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends AbstractDAO<Integer, User> {

	public User findById(int id) {
		return getByKey(id);
	}

	public void saveUser(User User) {
		persist(User);
	}

	public void deleteUserBySsn(String ssn) {
		Query query = getSession().createSQLQuery("delete from User where ssn = :ssn");
		query.setString("ssn", ssn);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		Criteria criteria = createEntityCriteria();
		criteria.setFetchMode("skills", FetchMode.JOIN);
		criteria.createAlias("skills", "s");
		return (List<User>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	public User findUserBySsn(String ssn) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("ssn", ssn));
		return (User) criteria.uniqueResult();
	}
}
