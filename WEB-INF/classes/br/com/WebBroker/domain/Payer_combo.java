package br.com.WebBroker.domain;


public class Payer_combo {

	private Integer id;
	private String payer_name;
	public Integer getId() {
		return id;
	}
	public String getPayer_name() {
		return payer_name;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setPayer_name(String payer_name) {
		this.payer_name = payer_name;
	}
	@Override
	public String toString() {
		return "Payer_combo [id=" + id + ", payer_name=" + payer_name + "]";
	}
	
}
