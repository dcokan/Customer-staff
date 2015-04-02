package pwr.itApp.customerStaff.persistance;


import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pwr.itApp.customerStaff.domain.User;

@Repository
public class UserDAO extends GenericDAO<User> {

	public User find(Object id) {
		return em.find(User.class, id);
	}

	public User findUserByLogin(String login) {
		return findUserByLogin(login, false);
	}
	
	public User findUserByLogin(String login, boolean showDeleted) {
		try {
			if (showDeleted) {
				return em.createNamedQuery("User.findAllByLogin", User.class)
						.setParameter("login", login)
						.getSingleResult();
			} else {
				return em.createNamedQuery("User.findUnDeletedByLogin", User.class)
						.setParameter("login", login)
						.getSingleResult();
			}
		} catch (NoResultException e) {
			return null;
		}
	}

	@Transactional
	public void persistNewEntity(User user) {
		em.persist(user);
//		em.flush();
	}

}
