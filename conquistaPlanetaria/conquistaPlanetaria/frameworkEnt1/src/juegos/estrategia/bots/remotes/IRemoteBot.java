package juegos.estrategia.bots.remotes;

import juegos.estrategia.PlanetWars;
import juegos.estrategia.ia.AbstractIA;

public interface IRemoteBot {

	AbstractIA getAbstractIA(PlanetWars pw);

}
