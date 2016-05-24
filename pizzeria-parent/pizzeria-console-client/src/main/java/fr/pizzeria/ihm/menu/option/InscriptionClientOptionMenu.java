package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.doa.DaoFactory;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Client;

public class InscriptionClientOptionMenu extends AbstractOptionMenu{
	private static final String INSCRIPTION_LIBELLE = "S'inscrire";

	public InscriptionClientOptionMenu(Scanner scanner, DaoFactory daoFactory) {
		super(INSCRIPTION_LIBELLE, scanner, daoFactory);
	}

	@Override
	public boolean execute() {
		System.out.println("Nouveau Client");
		
		Client cli = new Client();
		System.out.println("Veuillez saisir votre nom");
		cli.setNom(sc.next());
		System.out.println("Veuillez saisir votre prénom");
		cli.setPrenom(sc.next());
		System.out.println("Veuillez saisir votre email");
		cli.setEmail(sc.next());
		String mdp;
		System.out.println("Veuillez saisir un mot de passe");
		mdp = sc.next();
		System.out.println("Veuillez re-saisir le mot de passe");
		
		if(mdp.compareTo(sc.next()) != 0) {
			System.err.println("mot de passe non identique");
			return true;
		}
		cli.setMdp(mdp);
		
		try{
			daoFactory.getClientDao().ajouterCLient(cli);
			System.out.println("Client ajouté");
		}catch(DaoException e){
			System.err.println(e.getMessage());
		}
		return true;
	}

}
