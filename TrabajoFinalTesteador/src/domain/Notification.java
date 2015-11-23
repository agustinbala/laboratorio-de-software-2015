package domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Mock
public class Notification {

	@MockStringAttribute ({"descriptivo1", "descriptivo2","descriptivo3"})
	private Content content;
	
	@MockStringAttribute ({"Predeterminada", "Emociones", "Alimentos", "Actividades y Paseos"})
	private Category category;
	
	@MockStringAttribute ({"Establo­Terapia", "Pista", "Hogar"})
	private Context context;
	
	@MockStringAttribute({"Juan", "Pedro", "Juana", "Manuela"})
	private Child child;
	
	@MockTodayAttribute()
	private Date dateReceived;

	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	
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

	public Date getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}

}
