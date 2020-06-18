package br.com.WebBroker.domain;


public class Produto {


	private Long idsub;
	private String tb_subsegmento;
	private int tb_idpj;
	private String tb_razao;
	private int nco_cia;
	private Congenere_combo congenere_combo = new Congenere_combo();	

	

	public Long getIdsub() {
		return idsub;
	}
	public void setIdsub(Long idsub) {
		this.idsub = idsub;
	}
	public String getTb_subsegmento() {
		return tb_subsegmento;
	}
	public void setTb_subsegmento(String tb_subsegmento) {
		this.tb_subsegmento = tb_subsegmento;
	}
	public int getTb_idpj() {
		return tb_idpj;
	}
	public void setTb_idpj(int tb_idpj) {
		this.tb_idpj = tb_idpj;
	}
	public Congenere_combo getCongenere_combo() {
		return congenere_combo;
	}
	public void setCongenere_combo(Congenere_combo congenere_combo) {
		this.congenere_combo = congenere_combo;
	}
	public String getTb_razao() {
		return tb_razao;
	}
	public void setTb_razao(String tb_razao) {
		this.tb_razao = tb_razao;
	}
	public int getNco_cia() {
		return nco_cia;
	}
	public void setNco_cia(int nco_cia) {
		this.nco_cia = nco_cia;
	}

	@Override
	public String toString() {
		return "Produto [idsub=" + idsub + ", tb_subsegmento=" + tb_subsegmento
				+ ", tb_idpj=" + tb_idpj + ", tb_razao=" + tb_razao
				+ ", nco_cia=" + nco_cia + ", congenere_combo="
				+ congenere_combo + "]";
	}
	 
}
