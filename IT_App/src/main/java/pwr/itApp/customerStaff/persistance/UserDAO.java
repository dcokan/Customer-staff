package pwr.itApp.customerStaff.persistance;

import org.springframework.stereotype.Repository;

import pwr.itApp.customerStaff.domain.User;

@Repository
public class UserDAO extends GenericDAO<User> {

	public User find(Object id) {
		return em.find(User.class, id);
	}

	public User findUserByLogin(String login) {
		return em.createNamedQuery("User.findByLogin", User.class)
			.setParameter("login", login)
			.getSingleResult();
	}

}
