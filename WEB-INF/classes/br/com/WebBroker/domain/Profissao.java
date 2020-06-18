package br.com.WebBroker.domain;

public class Profissao {
	private Long tb_id_prof;
	private String tb_prof;
	
	public Long getTb_id_prof() {
		return tb_id_prof;
	}
	public void setTb_id_prof(Long tb_id_prof) {
		this.tb_id_prof = tb_id_prof;
	}
	public String getTb_prof() {
		return tb_prof;
	}
	public void setTb_prof(String tb_prof) {
		this.tb_prof = tb_prof;
	}
	@Override
	public String toString() {
		return "Profissao [tb_id_prof=" + tb_id_prof + ", tb_prof=" + tb_prof
				+ "]";
	} 
	
	

	
}
