package juegos.estrategia.bots.remotes.strategy;

import juegos.estrategia.PlanetWars;
import juegos.estrategia.bots.remotes.estratega.Estratega;
import juegos.estrategia.ia.AbstractIA;
import juegos.estrategia.ia.AgressiveIA;
import juegos.estrategia.ia.DistanceIA;
import juegos.estrategia.ia.LessDefenseIA;

public class StrategyBot {
	
	private static StrategyBot instance;
	
	public final static Estratega estratega1= new AgressiveEstratega();
	
	public final static Estratega estratega2= new PasiveEstratega();
	
	
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
		
		if(pw.myFleets().size() > (pw.numFleets()/2)){
			return estratega1.getIA(pw);
		}else{
			return estratega2.getIA(pw);
		}						
		
		
	}
	
	
	private static class AgressiveEstratega implements Estratega{

		@Override
		public AbstractIA getIA(PlanetWars pw) {
			if((pw.enemyPlanets().size() * 2) > pw.myPlanets().size()){
				return new AgressiveIA();
			}
			return new DistanceIA();
		}

	}

	private static class PasiveEstratega implements Estratega {

		@Override
		public AbstractIA getIA(PlanetWars pw) {

			return new LessDefenseIA();
		}

	}

}
