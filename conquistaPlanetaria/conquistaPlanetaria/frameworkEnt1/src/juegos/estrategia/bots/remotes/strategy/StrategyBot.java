package juegos.estrategia.bots.remotes.strategy;

import juegos.estrategia.PlanetWars;
import juegos.estrategia.ia.AbstractIA;
import juegos.estrategia.ia.AgressiveIA;
import juegos.estrategia.ia.LessDefenseIA;

public class StrategyBot {
	
	private static StrategyBot instance;
	
	private StrategyBot(){
		super();
	}
	
	public static StrategyBot getInstance(){
		if(instance == null){
			instance = new StrategyBot();
		}
		return instance;
	}
	
	public AbstractIA getStrategy(PlanetWars pw){
		if((pw.enemyPlanets().size() * 2) > pw.myPlanets().size()){
			return new AgressiveIA();
		}
		return new LessDefenseIA();
	}

}
