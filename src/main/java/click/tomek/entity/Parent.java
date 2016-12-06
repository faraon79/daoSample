package click.tomek.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import java.util.List;

@Entity
public class Parent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderColumn(name = "index")
	private List<Something> somethings;

	public Parent(String name, List<Something> somethings) {
		this.name = name;
		this.somethings = somethings;
	}

	public Parent() {
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Something> getSomethings() {
		return somethings;
	}
}
