package domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Notification {

	private Integer id;
	private Content content;
	private Category category;
	private Context context;
	private Child child;
	private Date date;
	private Date dateReceived;
	private List<Label> labels = new ArrayList<Label>();
	
	DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Content getContent() {
		return content;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Context getContext() {
		return context;
	}
	public void setContext(Context context) {
		this.context = context;
	}
	public Child getChild() {
		return child;
	}
	public void setChild(Child child) {
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
	
	public Date getDateReceived() {
		return dateReceived;
	}
	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}
	public Object[] toArray() {
		List<String> not = new ArrayList<String>();
		not.add(getId().toString());
		not.add(df.format(this.getDate()));
		not.add(df.format(this.getDateReceived()));
		not.add(this.getContent().getName());
		not.add(this.getContext().getName());
		not.add(this.getCategory().getName());
		not.add(this.getChild().getName());
		String labels = "";
		for (Label label : this.labels) {
			labels += label.getName()+", ";
		}
		if(labels != ""){
			labels = labels.substring(0,labels.length()-2);
		}
		not.add(labels);
		return not.toArray();
	}
	

}

