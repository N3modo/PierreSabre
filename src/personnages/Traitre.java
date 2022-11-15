package personnages;

public class Traitre extends Samourai {
	private int niveauTraitrise = 0;

	public Traitre(String nom, String seigneur, String boisson, int argent) {
		super(nom, seigneur, boisson, argent);
	}

	 @Override
	    public void direBonjour(){
	        parler("Bonjour ! Je m’appelle "+getNom()+" et j'aime boire du "+getBoisson()+" ! Je suis fier de servir le seigneur "+getSeigneur()+". Mais je suis un traître et mon niveau de traîtrise est: "+niveauTraitrise+". Chut!");
	    }

	public void ranconner(Commercant commercant) {
		if (niveauTraitrise < 3) {
			int argentCommercant = commercant.getArgent();
			int argentRanconner = argentCommercant * 2 / 10;
			commercant.perdreArgent(argentRanconner);
			gagnerArgent(argentRanconner);
			niveauTraitrise++;
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi " + argentRanconner
					+ " sous ou gare à toi !");
			commercant.parler("Tout de suite grand " + getNom());
		} else {
			parler("Mince je ne peux plus rançonner personne sinon un samouraï risque de me démasquer !");
		}
	}

	public void faireLeGentil() {
		if (nbConnaissance < 1) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
		} else {
			int don = getArgent() / 20;
			int alea = (int) (Math.random() * nbConnaissance);
			Humain ami = memoire[alea];
			String nomAmi = ami.getNom();
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + nomAmi + ".");
			parler("Bonjour l'ami! Je voudrais vous aider en vous donnant " + don + " sous");
			ami.gagnerArgent(don);
			perdreArgent(don);
			ami.parler("Merci " + getNom() + "! Vous êtes quelqu'un de bien.");
			niveauTraitrise--;
		}
	}
}
