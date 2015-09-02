package juegos.estrategia.bots.remotes;

import juegos.estrategia.PlanetWars;
import juegos.estrategia.bots.remotes.strategy.StrategyBot;
import juegos.estrategia.ia.AbstractIA;
import juegos.estrategia.ia.DistanceIA;

public class RemoteBot implements IRemoteBot{

	@Override
	public AbstractIA getAbstractIA(PlanetWars pw) {
		return StrategyBot.getInstance().getStrategy(pw);		
	}
	
	public static void main(String[] args) {
		(new RemoteBot()).play();
	}
	
	public void play() {
		String line = "";
		String message = "";
		int c;
		try {
			while ((c = System.in.read()) >= 0) {
				switch (c) {
				case '\n':
					if (line.equals("go")) {
						PlanetWars pw = new PlanetWars(message);
						getAbstractIA(pw).makeAMove(pw);
						pw.finishTurn();
						message = "";
					} else {
						message += line + "\n";
					}
					line = "";
					break;
				default:
					line += (char) c;
					break;
				}
			}
		} catch (Exception e) {
			// Owned.
		}
	}

}
