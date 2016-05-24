package fr.pizzeria.doa.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.apache.commons.codec.digest.DigestUtils;

import fr.pizzeria.model.Client;

public class ClientDaoImplJpa implements IClientDao {

	private EntityManagerFactory em;

	public ClientDaoImplJpa(EntityManagerFactory em) {
		this.em = em;
	}

	@Override
	public Client identification(String email, String pwd) {
		EntityManager emCourant = em.createEntityManager();
		TypedQuery<Client> query = emCourant.createQuery("SELECT c FROM Client c WHERE c.email=:emailCli AND c.mdp=:pwdCli", Client.class);
		
		query.setParameter("emailCli", email);
		query.setParameter("pwdCli", encoderMdp(pwd));
		
		try{
			Client cli = query.getResultList().get(0);
			System.out.println("Vous êtes "+cli.getPrenom()+" "+cli.getNom());
			emCourant.close();
			return cli;
		}catch(IndexOutOfBoundsException e){
			System.err.println("érreur lors de l'identification");
			emCourant.close();
			return null;
		}
		
	}

	@Override
	public void ajouterCLient(Client newClient) {
		newClient.setMdp(encoderMdp(newClient.getMdp()));
		EntityManager emCourant = em.createEntityManager();
		EntityTransaction trans = emCourant.getTransaction();
		// début de la transaction
		trans.begin();
		emCourant.persist(newClient);
		// fin de la trn
		trans.commit();
		emCourant.close();
	}
	
	private String encoderMdp(String pwd) {
		return DigestUtils.md5Hex(pwd);
	}

}
