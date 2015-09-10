package juegos.estrategia.bots.remotes.estratega;

import juegos.estrategia.PlanetWars;
import juegos.estrategia.ia.AbstractIA;

public interface Estratega {

	AbstractIA getIA(PlanetWars pw);
}
