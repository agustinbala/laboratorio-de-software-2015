package db;

import java.util.List;

import domain.Label;

public interface LabelDAO {

	public Label getLabel(Integer id);
	
	public Label getLabel(String name);
	
	public void saveLabel(Label label);
	
	public List<Label> listLabels();
	
	public void deleteLabel (Label label);
	
	public void updateLabel (Label label, String name);
}
