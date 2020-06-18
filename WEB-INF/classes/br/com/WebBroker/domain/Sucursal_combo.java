package br.com.WebBroker.domain;


public class Sucursal_combo {
	private Long id_suc;
	private Long tb_codsuc;
	private String tb_sucursal;
	
	public Long getId_suc() {
		return id_suc;
	}
	public void setId_suc(Long id_suc) {
		this.id_suc = id_suc;
	}
	public Long getTb_codsuc() {
		return tb_codsuc;
	}
	public void setTb_codsuc(Long tb_codsuc) {
		this.tb_codsuc = tb_codsuc;
	}
	public String getTb_sucursal() {
		return tb_sucursal;
	}
	public void setTb_sucursal(String tb_sucursal) {
		this.tb_sucursal = tb_sucursal;
	}
	@Override
	public String toString() {
		return "Sucursal_combo [id_suc=" + id_suc + ", tb_codsuc=" + tb_codsuc
				+ ", tb_sucursal=" + tb_sucursal + "]";
	}
	
	 
	
	
}
