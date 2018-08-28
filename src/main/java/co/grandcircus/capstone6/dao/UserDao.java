package co.grandcircus.capstone6.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDao {
	
	
	@PersistenceContext
	EntityManager em;

}
