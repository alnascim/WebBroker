package br.com.WebBroker.domain;

public class Estadocivil {
	private long tb_id_estado;
	private String tb_estado;
	public long getTb_id_estado() {
		return tb_id_estado;
	}
	public void setTb_id_estado(long tb_id_estado) {
		this.tb_id_estado = tb_id_estado;
	}
	public String getTb_estado() {
		return tb_estado;
	}
	public void setTb_estado(String tb_estado) {
		this.tb_estado = tb_estado;
	}
	@Override
	public String toString() {
		return "Estadocivil [tb_id_estado=" + tb_id_estado + ", tb_estado="
				+ tb_estado + "]";
	}
	 
	
	
}
