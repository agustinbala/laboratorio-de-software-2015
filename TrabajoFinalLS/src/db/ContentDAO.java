package db;

import java.util.List;

import domain.Content;

public interface ContentDAO {

	public Content getContent(Integer id);
	
	public void saveContent(Content content);
	
	public Integer saveContent(String contentName);
	
	public List<Content> listContents();
}
