package juegos.estrategia.bots.remotes;

import juegos.estrategia.ia.AbstractIA;
import juegos.estrategia.ia.DistanceIA;

public class DistanceRemoteBot extends AbstractRemoteBot {

	@Override
	public AbstractIA getAbstractIA() {
		return new DistanceIA();
	}
	
	public static void main(String[] args) {
		(new DistanceRemoteBot()).play();
	}

}
