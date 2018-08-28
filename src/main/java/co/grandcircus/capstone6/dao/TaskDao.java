package co.grandcircus.capstone6.dao;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;

import co.grandcircus.capstone6.tasklist.Task;



@Repository
@Transactional
public class TaskDao {

	@PersistenceContext
	EntityManager em;
	
	public List<Task> findAll(){

		return em.createQuery("FROM Task", Task.class).getResultList();
		}
		
		
		public Task findById(Long id) {
			return em.find(Task.class, id);
		}
		
		public void create(Task task) {
			em.persist(task);
		}
		
		public List<Task> findByKeyword(String keyword) {
			// HQL queries can have named parameters, such as :regex here.
			return em.createQuery("FROM Task WHERE LOWER(name) LIKE :regex", Task.class)
					.setParameter("regex", "%" + keyword.toLowerCase() + "%")
					.getResultList();
		}
		
		public List<Task> findByCategory(String category) {
			return em.createQuery("FROM Task WHERE LOWER(category) = :category", Task.class)
					.setParameter("category", category.toLowerCase())
					.getResultList();
		}
		
		public void delete(Long id) {
			Task task = em.getReference(Task.class, id);
			em.remove(task);
		}
		
		public void update(Task task) {
			em.merge(task);
		}
		
		public Set<String> findAllCategories() {
			List<String> categoryList = em.createQuery("SELECT DISTINCT category FROM TASK", String.class)
					.getResultList();
			return new TreeSet<>(categoryList);
		}
}
