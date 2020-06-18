package br.com.WebBroker.domain;


public class GrupoConta {
	private Integer id;
	private String name;	
	private Integer sign;
	
	public Integer getSign() {
		return sign;
	}
	public void setSign(Integer sign) {
		this.sign = sign;
	}
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
		return "GrupoConta [id=" + id + ", name=" + name + ", sign=" + sign
				+ "]";
	}
 

	
}
