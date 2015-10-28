package db;

import java.util.List;

import domain.Label;

public interface LabelDAO {

	public Label getLabel(Integer id);
	
	public void saveLabel(Label label);
	
	public List<Label> listLabels();
}
