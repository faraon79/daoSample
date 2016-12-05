package click.tomek.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderColumn;
import java.util.List;

@Entity
public class Something {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@ElementCollection(fetch = FetchType.EAGER)
	@OrderColumn(name = "index")
	private List<Double> values;

	public Something(String name, List<Double> values) {
		this.name = name;
		this.values = values;
	}

	public Something() {
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Double> getValues() {
		return values;
	}
}
