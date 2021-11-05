package dao;

import java.util.List;
import java.util.function.Consumer;

import model.Professor;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ProfessorDao implements Dao<Professor>{

	private EntityManager em;
	
	public ProfessorDao() {
		em = JPAUtil.getEntityManagerFactory().createEntityManager();
	}
	
	private void executeInsideTransaction(Consumer<EntityManager> action) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			action.accept(em);
			tx.commit();
			
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
	}
	
	
	@Override
	public Professor get(int id) {
		return em.find(Professor.class, id);
	}

	@Override
	public List<Professor> getAll() {
		return em.createQuery("From Professor", Professor.class).getResultList();
	}

	@Override
	public void save(Professor objeto) {
		executeInsideTransaction(em->em.persist(objeto));
	}

	@Override
	public void update(Professor objeto) {
		executeInsideTransaction(em->em.merge(objeto));
	}

	@Override
	public void delete(Professor objeto) {
		executeInsideTransaction(em->em.remove(objeto));
	}
	
}
