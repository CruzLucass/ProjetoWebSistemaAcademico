package dao;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Disciplina;

public class DisciplinaDao implements Dao<Disciplina> {
	
	public EntityManager em;
	
	public DisciplinaDao() {
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
	public Disciplina get(int id) {
		return em.find(Disciplina.class, id);
	}

	@Override
	public List<Disciplina> getAll() {
		return em.createQuery("From Disciplina", Disciplina.class).getResultList();
	}

	@Override
	public void save(Disciplina objeto) {
		executeInsideTransaction(em->em.persist(objeto));
	}

	@Override
	public void update(Disciplina objeto) {
		executeInsideTransaction(em->em.merge(objeto));
	}

	@Override
	public void delete(Disciplina objeto) {
		executeInsideTransaction(em->em.remove(objeto));
	}


}
