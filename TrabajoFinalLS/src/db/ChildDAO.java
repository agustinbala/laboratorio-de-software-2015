package db;

import java.util.List;

import domain.Child;

public interface ChildDAO {

	public Child getChild(Integer id);
	
	public void saveChild(Child child);
	
	public Integer saveChild(String childName);
	
	public List<Child> listChilds();
}
