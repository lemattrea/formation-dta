package fr.pizzeria.doa.commande;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import fr.pizzeria.model.Commande;

public class CommandeDaoImplJpa implements ICommandeDao {

	private EntityManagerFactory em;

	public CommandeDaoImplJpa(EntityManagerFactory em) {
		this.em = em;
	}

	@Override
	public void commanderPizza(Commande com) {
		EntityManager emCourant = em.createEntityManager();
		EntityTransaction trans = emCourant.getTransaction();
		// début de la transaction
		trans.begin();
		emCourant.persist(com);
		// fin de la trn
		trans.commit();
		emCourant.close();
		
	}

	@Override
	public void listerCommande() {
		// TODO Auto-generated method stub
		
	}

}
