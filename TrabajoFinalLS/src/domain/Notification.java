package domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Notification {

	private Integer id;
	private String content;
	private String category;
	private String context;
	private String child;
	private Date date;
	private List<Label> labels;
	
	DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getChild() {
		return child;
	}
	public void setChild(String child) {
		this.child = child;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Label> getLabels() {
		return labels;
	}
	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}
	public Object[] toArray() {
		List<String> not = new ArrayList<String>();
		not.add(df.format(this.getDate()));
		not.add(this.getContent());
		not.add(this.getContext());
		not.add(this.getCategory());
		not.add(this.getChild());
		//TODO
		not.add("");
		return not.toArray();
	}
	

}

