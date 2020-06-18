package br.com.WebBroker.domain;


public class Congenere_combo {
	private Long tb_idpj;
	private String tb_razao;
	
	public Long getTb_idpj() {
		return tb_idpj;
	}
	public void setTb_idpj(Long tb_idpj) {
		this.tb_idpj = tb_idpj;
	}
	public String getTb_razao() {
		return tb_razao;
	}
	public void setTb_razao(String tb_razao) {
		this.tb_razao = tb_razao;
	}
	@Override
	public String toString() {
		return "Congenere_combo [tb_idpj=" + tb_idpj + ", tb_razao=" + tb_razao
				+ "]";
	}
 

	
}
