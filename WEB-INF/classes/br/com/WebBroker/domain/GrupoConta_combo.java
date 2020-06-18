package br.com.WebBroker.domain;


public class GrupoConta_combo {
	private Integer id;
	private String name;
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "GrupoConta_combo [id=" + id + ", name=" + name + "]";
	}

	
}
