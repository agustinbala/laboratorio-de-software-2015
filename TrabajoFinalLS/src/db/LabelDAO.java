package db;

import java.util.List;

import domain.Label;

public interface LabelDAO {

	public Label getLabel(Integer id);
	
	public void saveLabel(Label label);
	
	public Integer saveLabel(String labelName);
	
	public List<Label> listLabels();
	
	public void deleteLabel (Integer id);
	
	public void updateLabel (Label label, String name);
}
