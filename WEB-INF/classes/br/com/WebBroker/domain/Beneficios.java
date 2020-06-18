package br.com.WebBroker.domain;


public class Beneficios {
	
	private Long id;
	private Long id_pessoa;
	private Long id_apolice;
	private String num_carteira;
	private Integer id_congenere;
	private Integer id_estipulante;
	private String s_apolice;
	private String s_segmento;
	private Integer id_subsegmento;
	private String tb_razao;
	private Empresa_combo empresa_combo = new Empresa_combo();
	private Congenere_combo congenere_combo = new Congenere_combo();
	private Segmento segmento_combo = new Segmento();
	private Segmento apolice_combo = new Segmento();

	
	public String getS_segmento() {
		return s_segmento;
	}
	public void setS_segmento(String s_segmento) {
		this.s_segmento = s_segmento;
	}
	public Empresa_combo getEmpresa_combo() {
		return empresa_combo;
	}
	public void setEmpresa_combo(Empresa_combo empresa_combo) {
		this.empresa_combo = empresa_combo;
	}
	public Congenere_combo getCongenere_combo() {
		return congenere_combo;
	}
	public void setCongenere_combo(Congenere_combo congenere_combo) {
		this.congenere_combo = congenere_combo;
	}
	public Segmento getSegmento_combo() {
		return segmento_combo;
	}
	public void setSegmento_combo(Segmento segmento_combo) {
		this.segmento_combo = segmento_combo;
	}
	public Segmento getApolice_combo() {
		return apolice_combo;
	}
	public void setApolice_combo(Segmento apolice_combo) {
		this.apolice_combo = apolice_combo;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_pessoa() {
		return id_pessoa;
	}
	public void setId_pessoa(Long id_pessoa) {
		this.id_pessoa = id_pessoa;
	}
	public Long getId_apolice() {
		return id_apolice;
	}
	public void setId_apolice(Long id_apolice) {
		this.id_apolice = id_apolice;
	}
	public String getNum_carteira() {
		return num_carteira;
	}
	public void setNum_carteira(String num_carteira) {
		this.num_carteira = num_carteira;
	}
	public Integer getId_congenere() {
		return id_congenere;
	}
	public void setId_congenere(Integer id_congenere) {
		this.id_congenere = id_congenere;
	}
	public Integer getId_estipulante() {
		return id_estipulante;
	}
	public void setId_estipulante(Integer id_estipulante) {
		this.id_estipulante = id_estipulante;
	}
	public String getS_apolice() {
		return s_apolice;
	}
	public void setS_apolice(String s_apolice) {
		this.s_apolice = s_apolice;
	}
	public Integer getId_subsegmento() {
		return id_subsegmento;
	}
	public void setId_subsegmento(Integer id_subsegmento) {
		this.id_subsegmento = id_subsegmento;
	}
	public String getTb_razao() {
		return tb_razao;
	}
	public void setTb_razao(String tb_razao) {
		this.tb_razao = tb_razao;
	}
	 
	@Override
	public String toString() {
		return "Beneficios [id=" + id + ", id_pessoa=" + id_pessoa
				+ ", id_apolice=" + id_apolice + ", num_carteira="
				+ num_carteira + ", id_congenere=" + id_congenere
				+ ", id_estipulante=" + id_estipulante + ", s_apolice="
				+ s_apolice + ", s_segmento=" + s_segmento
				+ ", id_subsegmento=" + id_subsegmento + ", tb_razao="
				+ tb_razao + ", empresa_combo=" + empresa_combo
				+ ", congenere_combo=" + congenere_combo + ", segmento_combo="
				+ segmento_combo + ", apolice_combo=" + apolice_combo + "]";
	}
		
}
