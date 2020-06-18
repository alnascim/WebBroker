package br.com.WebBroker.domain;


public class BancoCombo {

	private Integer id;
	private String banco;

	public Integer getId() {
		return id;
	}
 
	public String getBanco() {
		return banco;
	}
	 
	public void setId(Integer id) {
		this.id = id;
	}
 
	public void setBanco(String banco) {
		this.banco = banco;
	}
	@Override
	public String toString() {
		return "BancoCombo [id=" + id + ", banco=" + banco + "]";
	} 
	
}
