package dao;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Endereco;

public class EnderecoDao implements Dao<Endereco> {
	
	public EntityManager em;
	
	public EnderecoDao() {
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
	public Endereco get(int id) {
		return em.find(Endereco.class, id);
	}

	@Override
	public List<Endereco> getAll() {
		return em.createQuery("From Endereco", Endereco.class).getResultList();
	}

	@Override
	public void save(Endereco objeto) {
		executeInsideTransaction(em->em.persist(objeto));
	}

	@Override
	public void update(Endereco objeto) {
		executeInsideTransaction(em->em.merge(objeto));
	}

	@Override
	public void delete(Endereco objeto) {
		executeInsideTransaction(em->em.remove(objeto));
	}


}
