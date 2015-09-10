package juegos.estrategia.ia;

import juegos.estrategia.Planet;
import juegos.estrategia.PlanetWars;

public class LessDefenseIA implements AbstractIA {

	@Override
	public void makeAMove(PlanetWars pw) {
		
		
		if (pw.getMyPlanets().length == 0) {
		
			return;

		}
		if (pw.getNotMyPlanets().length == 0) {
			return;

		}
		
		int maxCantNaves = 0;
		Planet mioMayor = null;
		for (Planet mio : pw.getMyPlanets()) {
			int numberOfNavesInPlaneta = mio.numShips();
			if (maxCantNaves < numberOfNavesInPlaneta) {
				maxCantNaves = numberOfNavesInPlaneta;
				mioMayor = mio;
			}
		}
		
		int minCantNaves = 99999;
		Planet minPlanet = null;
		for (Planet planeta : pw.getNotMyPlanets()) {
			int numberOfNavesInPlaneta = planeta.numShips();
				if (minCantNaves > numberOfNavesInPlaneta) {
					minCantNaves = numberOfNavesInPlaneta;
					minPlanet = planeta;
				}
		}
		if(minCantNaves >= maxCantNaves){
			pw.issueOrder(mioMayor.planetID(), minPlanet.planetID(), 1);	
		}else{
			pw.issueOrder(mioMayor.planetID(), minPlanet.planetID(), minCantNaves + 1);
		}
		return;
		
	}

}
