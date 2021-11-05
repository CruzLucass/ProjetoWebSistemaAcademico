package dao;

import java.util.List;
import java.util.function.Consumer;

import model.Curso;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CursoDao implements Dao<Curso>{

	private EntityManager em;
	
	public CursoDao() {
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
	public Curso get(int id) {
		return em.find(Curso.class, id);
	}

	@Override
	public List<Curso> getAll() {
		return em.createQuery("From Curso", Curso.class).getResultList();
	}

	@Override
	public void save(Curso objeto) {
		executeInsideTransaction(em->em.persist(objeto));
	}

	@Override
	public void update(Curso objeto) {
		executeInsideTransaction(em->em.merge(objeto));
	}

	@Override
	public void delete(Curso objeto) {
		executeInsideTransaction(em->em.remove(objeto));
	}
	
}
