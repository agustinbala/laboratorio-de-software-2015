package juegos.estrategia.bots.remotes;

import juegos.estrategia.PlanetWars;
import juegos.estrategia.bots.remotes.strategy.StrategyBot;
import juegos.estrategia.ia.AbstractIA;

public class StrategicBot extends RemoteBot {

	@Override
	public AbstractIA getAbstractIA(PlanetWars pw) {
		return StrategyBot.getInstance().getStrategy(pw);		
	}
	
	public static void main(String[] args) {
		(new StrategicBot()).play();
	}
}
