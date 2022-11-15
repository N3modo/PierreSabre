package personnages;

public class Ronin extends Humain {
	private int honneur = 1;

	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
	}

	public void donner(Commercant beneficiaire) {
		int argentDonner = (int) (this.getArgent() * 0.1);
		this.perdreArgent(argentDonner);
		this.parler(beneficiaire.getNom() + " prend ces 6 sous.");
		beneficiaire.recevoir(argentDonner);
	}

	public void provoquer(Yakuza adversaire) {
		this.parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		if (this.honneur * 2 >= adversaire.getReputation()) {
			this.parler("Je t’ai eu petit yakusa!");
			this.gagnerArgent(adversaire.perdre());
			this.honneur += 1;

		} else {
			this.honneur -= 1;
			this.parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			int argentPerdu = this.getArgent();
			this.perdreArgent(argentPerdu);
			adversaire.gagner(argentPerdu);
		}
	}

}