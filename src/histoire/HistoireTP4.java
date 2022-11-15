package histoire;

import personnages.*;

public class HistoireTP4 {
	public static void main(String[] args) {
		Commercant marco = new Commercant("marco", 15);
		Yakuza yaku = new Yakuza("Yaku le noir", "whisky", 45, "Warsong");
		Ronin roro = new Ronin("roro", "shochu", 54);
		roro.provoquer(yaku);

	}

}