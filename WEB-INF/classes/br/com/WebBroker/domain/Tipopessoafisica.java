package br.com.WebBroker.domain;

public class Tipopessoafisica {
	
	private long id;
	private String tb_tipo;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTb_tipo() {
		return tb_tipo;
	}
	public void setTb_tipo(String tb_tipo) {
		this.tb_tipo = tb_tipo;
	}
	@Override
	public String toString() {
		return "Tipopessoafisica [id=" + id + ", tb_tipo=" + tb_tipo + "]";
	}

	 


	
}
