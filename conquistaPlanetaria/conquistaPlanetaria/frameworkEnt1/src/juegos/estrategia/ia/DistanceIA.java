package juegos.estrategia.ia;

import java.util.HashMap;
import java.util.Set;
import juegos.estrategia.Planet;
import juegos.estrategia.PlanetWars;

public class DistanceIA implements AbstractIA {

	public void makeAMove(PlanetWars pw) {
		HashMap<Planet, Planet> ataques = new HashMap<Planet, Planet>();
		if (pw.getMyPlanets().length == 0) {
			return;

		}
		if (pw.getNotMyPlanets().length == 0) {
			return;

		}
		for (Planet mio : pw.getMyPlanets()) {
			double minDist = 99999;
			Planet minPlanet = null;
			for (Planet planeta : pw.getNotMyPlanets()) {
				double distance = pw.distance(mio.planetID(), planeta
							.planetID());
					if (minDist > distance) {
						minDist = distance;
						minPlanet = planeta;
					}
			}
			ataques.put(mio, minPlanet);
				
			
			}

		Set<Planet> keys = ataques.keySet();
		for (Planet planet : keys) {
			pw.issueOrder(planet.planetID(), ataques.get(planet).planetID(), planet.numShips() / 2);
			return;
		}

	}

}
