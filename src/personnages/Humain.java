package personnages;

public class Humain {

	private String nom;
	private String boisson;
	private int argent;
	protected Humain[] memoire = new Humain[30];
	protected int nbConnaissance = 0;
	private int insertionHumain = 0;

	public Humain(String nom, String boisson, int argent) {
		super();
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
	}

	protected void parler(String text) {
		System.out.println("(" + this.getNom() + ") - " + text);
	}

	public void direBonjour() {
		this.parler("Bonjour ! Je m'appelle " + this.getNom() + " et j'aime boire du " + this.boisson + ".");
	}

	public void boire() {
		this.parler("Mmmm, un bon verre de " + this.boisson + " ! GLOUPS !");
	}

	public void acheter(String bien, int prix) {
		if (this.argent >= prix) {
			this.parler("j'ai " + this.getArgent() + " sous en poche. Je vais pouvoir m'offrir une " + bien + " à "
					+ prix + " sous");
			this.argent -= prix;
		} else {
			this.parler(" Je n'ai plus que " + this.argent + " sous en poche. Je ne peux même pas m'offrir un kimono à "
					+ prix + " sous.");
		}
	}

	protected int gagnerArgent(int gain) {
		this.argent += gain;
		return this.getArgent();
	}

	protected int perdreArgent(int perte) {
		this.argent -= perte;
		return this.getArgent();
	}

	public void faireConnaissanceAvec(Humain autreHumain) {
		this.direBonjour();
		autreHumain.repondre(this);
		this.memoriser(autreHumain);
	}

	private void repondre(Humain humain) {
		this.direBonjour();
		this.memoriser(humain);
	}

	private void memoriser(Humain humain) {
		if (this.insertionHumain >= this.memoire.length)
			this.insertionHumain = 0;
		this.memoire[this.insertionHumain++] = humain;
		if (this.nbConnaissance < this.memoire.length)
			this.nbConnaissance++;
	}

	public void listerConnaissance() {
		String text = "Je connais beaucoup de monde dont : ";
		for (int i = 0; i < this.nbConnaissance; i++) {
			text += this.memoire[i].getNom();
			if (i + 1 < this.nbConnaissance)
				text += ", ";
		}
		this.parler(text);
	}

	public String getNom() {
		return this.nom;
	}

	public int getArgent() {
		return this.argent;
	}

	public String getBoisson() {
		return boisson;
	}

}