package db;

import java.util.List;

import domain.Context;

public interface ContextDAO {

	public Context getContext(Integer id);
	
	public void saveContext(Context context);
	
	public Integer saveContext(String contextName);
	
	public List<Context> listContexts();
}
