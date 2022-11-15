package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		this.parler("Mon clan est celui de " + this.clan + ".");
	}

	public void extorquer(Commercant victime) {
		this.parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par l� ?");
		this.parler(victime.getNom() + ", si tu tiens � la vie donne moi ta bourse !");
		int agentGagner = victime.seFaireExtorquer();
		this.gagnerArgent(agentGagner);
		this.reputation += 1;
		this.parler("J�ai piqu� les " + agentGagner + " sous de " + victime.getNom() + ", ce qui me fait "
				+ this.getArgent() + " sous dans ma poche. Hi ! Hi !");
	}

	public void gagner(int gain) {
		this.gagnerArgent(gain);
		this.reputation += 1;
		this.parler("Ce ronin pensait vraiment battre " + this.getNom() + " du clan de " + this.clan + " ?\n"
				+ "	Je l'ai d�pouill� de ses " + gain + " sous.");
	}

	public int perdre() {
		int argentPerdu = this.getArgent();
		this.perdreArgent(argentPerdu);
		this.reputation -= 1;
		this.parler("J'ai perdu mon duel et mes " + argentPerdu + " sous, snif... J'ai d�shonor� le clan de "
				+ this.clan + ".");
		return argentPerdu;
	}

	public int getReputation() {
		return this.reputation;
	}

}