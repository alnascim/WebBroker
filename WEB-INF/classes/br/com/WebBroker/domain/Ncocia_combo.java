package br.com.WebBroker.domain;


public class Ncocia_combo {
	private Integer nco_cia;
	private Integer idsub;
	private String tb_produto;
		
	public Integer getNco_cia() {
		return nco_cia;
	}
	public void setNco_cia(Integer nco_cia) {
		this.nco_cia = nco_cia;
	}
	public String getTb_produto() {
		return tb_produto;
	}
	public Integer getIdsub() {
		return idsub;
	}
	public void setIdsub(Integer idsub) {
		this.idsub = idsub;
	}
	public void setTb_produto(String tb_produto) {
		this.tb_produto = tb_produto;
	}
	@Override
	public String toString() {
		return "Ncocia_combo [nco_cia=" + nco_cia + ", idsub=" + idsub
				+ ", tb_produto=" + tb_produto + "]";
	}
	

	
}
