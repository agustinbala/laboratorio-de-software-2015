package ejercicio5;

public class PoolConexiones {
	
	private PoolConexiones pool;
	
	private PoolConexiones(){
		super();
	}
	
	public PoolConexiones getInstance(){
		if(pool != null){
			pool = new PoolConexiones();			
		}
		return pool;
	}

}
