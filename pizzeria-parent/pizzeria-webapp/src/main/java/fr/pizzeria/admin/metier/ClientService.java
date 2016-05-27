/**
 * 
 */
package fr.pizzeria.admin.metier;

import java.util.Set;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Client;

/**
 * @author ETY
 *
 */
@Stateless
public class ClientService{
	
	@PersistenceContext(unitName="pizzeria-webapp") private EntityManager em;
	
	public Set<Client> findAll() {
		
		Set<Client> clients;
		TypedQuery<Client> query = em.createQuery("select p from Client p", Client.class);
		clients = query.getResultList().stream().collect(Collectors.toSet());

		return clients;
	}

	public void saveNew(Client newClient) {
		em.persist(newClient);
	}

	public void update(int code, Client updateClient) {
		TypedQuery<Client> query = em.createQuery("select c from Client c where c.id=:idClient", Client.class);
		query.setParameter("idClient", code);

		Client client = query.getSingleResult();
		if (client != null) {
			Client newClient = new Client();
			newClient.setId(code);
			newClient.setNom(updateClient.getNom());
			newClient.setPrenom(updateClient.getPrenom());
			newClient.setEmail(updateClient.getEmail());
			em.merge(newClient);
		}
	}

	public void delete(String code) {
		Client p = em.find(Client.class, code);
		if (p != null) {
			em.remove(p);
		}
	}

}
