package br.com.WebBroker.domain;
public class PGrade {

	private Long id_grade;
	private Long id_angariador;
	private Long id_segmento;
	private Long id_parcela;
	private double tb_perccomis;
	private String tb_flag_clt;
	private String tb_nome;
	private String tb_segmento;
	private Angariador_combo angariador_combo = new Angariador_combo();
	private Segmento segmento_combo = new Segmento();
	
	public Long getId_grade() {
		return id_grade;
	}
	public void setId_grade(Long id_grade) {
		this.id_grade = id_grade;
	}
	public Long getId_angariador() {
		return id_angariador;
	}
	public void setId_angariador(Long id_angariador) {
		this.id_angariador = id_angariador;
	}
	public Long getId_segmento() {
		return id_segmento;
	}
	public void setId_segmento(Long id_segmento) {
		this.id_segmento = id_segmento;
	}
	public Long getId_parcela() {
		return id_parcela;
	}
	public void setId_parcela(Long id_parcela) {
		this.id_parcela = id_parcela;
	}
	public double getTb_perccomis() {
		return tb_perccomis;
	}
	public void setTb_perccomis(double tb_perccomis) {
		this.tb_perccomis = tb_perccomis;
	}
	public String getTb_flag_clt() {
		return tb_flag_clt;
	}
	public void setTb_flag_clt(String tb_flag_clt) {
		this.tb_flag_clt = tb_flag_clt;
	}
	public String getTb_nome() {
		return tb_nome;
	}
	public void setTb_nome(String tb_nome) {
		this.tb_nome = tb_nome;
	}
	public String getTb_segmento() {
		return tb_segmento;
	}
	public void setTb_segmento(String tb_segmento) {
		this.tb_segmento = tb_segmento;
	}
	public Angariador_combo getAngariador_combo() {
		return angariador_combo;
	}
	public void setAngariador_combo(Angariador_combo angariador_combo) {
		this.angariador_combo = angariador_combo;
	}
	public Segmento getSegmento_combo() {
		return segmento_combo;
	}
	public void setSegmento_combo(Segmento segmento_combo) {
		this.segmento_combo = segmento_combo;
	}

	@Override
	public String toString() {
		return "PGrade [id_grade=" + id_grade + ", id_angariador="
				+ id_angariador + ", id_segmento=" + id_segmento
				+ ", id_parcela=" + id_parcela + ", tb_perccomis="
				+ tb_perccomis + ", tb_flag_clt=" + tb_flag_clt + ", tb_nome="
				+ tb_nome + ", tb_segmento=" + tb_segmento
				+ ", angariador_combo=" + angariador_combo
				+ ", segmento_combo=" + segmento_combo + "]";
	}
	
	
	
	 
	
}
