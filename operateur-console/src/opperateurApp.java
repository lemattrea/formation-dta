import java.util.Scanner;

public class opperateurApp {
	public static void main(String args[]) {
		System.out.println("Bonjour");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Veuiller saisir le premier nombre");
		double nb_1 = sc.nextDouble();
		System.out.println("Veuiller saisir le deuxième nombre");
		double nb_2 = sc.nextDouble();
		double somme = nb_1 + nb_2;
		double dif = nb_1 - nb_2;
		double mult = nb_1 * nb_2;
		double div = nb_1 / nb_2;
		double mod = nb_1 % nb_2;
		System.out.println("la somme de vos deux nombre est "+somme);
		System.out.println("la différence de vos deux nombre est "+dif);
		System.out.println("la multiplication de vos deux nombre est "+mult);
		System.out.println("la division de votre premier nombre par votre deuxième nombre est "+div);
		System.out.println("le modulo de votre premier nombre par votre deuxième nombre est "+mod);
		
		sc.close();
		
	}
}
