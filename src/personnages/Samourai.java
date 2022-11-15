package personnages;

public class Samourai extends Ronin {

	private String seigneur;

	public Samourai(String nom, String seigneur, String boisson, int argent) {
		super(nom, boisson, argent);
		this.seigneur = seigneur;
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		this.parler("Je suis fier de servir le seigneur " + this.seigneur + ".");
	}

	public void boire(String boison) {
		this.parler("Qu'est-ce que je vais choisir comme boisson ? Tiens je vais prendre du " + boison + ".");
	}

	public String getSeigneur() {
		return seigneur;
	}

}