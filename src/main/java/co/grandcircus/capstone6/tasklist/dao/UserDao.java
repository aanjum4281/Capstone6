package co.grandcircus.capstone6.tasklist.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;

import co.grandcircus.capstone6.tasklist.User;


@Repository
@Transactional

public class UserDao {
	
	@PersistenceContext
	EntityManager em;
	
	public List<User> findAll(){
		return em.createQuery("FROM User", User.class).getResultList();
	}
	
	public User findById(Long id) {
		return em.find(User.class, id);
	}
	
	//find by email method
	
	
	public  void create(User user) {
		em.merge(user);
	}
	
	public void delete(Long id) {
		User user = em.getReference(User.class, id);
		em.remove(user);
	}

	public User findByEmailAddress(String emailAddress) {
		// TODO Auto-generated method stub
		return User.values().stream().filter(user -> emailAddress.equals(user.getEmailAddress())).findAny().orElse(null);
	}
	
	
}
