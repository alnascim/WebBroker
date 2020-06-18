package br.com.WebBroker.domain;


public class Segmento {
	private Long id;
	private Long id_apolice;
	private String sid_apolice;
	private String senha_acesso;
	private String tb_segmento;
	private String tb_sigla;
	private Integer nco_cia;
	private Integer nco_ramo;
	private String event_code;
	private Integer id_subsegmento;
	private String tb_razao;
	private Congenere_combo congenere_combo = new Congenere_combo();
	private Ncocia_combo nco_cia_combo= new Ncocia_combo();
	private Produto produto_combo = new Produto ();

	public Long getId_apolice() {
		return id_apolice;
	}
	public void setId_apolice(Long id_apolice) {
		this.id_apolice = id_apolice;
	}
	public String getSid_apolice() {
		return sid_apolice;
	}
	public void setSid_apolice(String sid_apolice) {
		this.sid_apolice = sid_apolice;
	}
	public String getSenha_acesso() {
		return senha_acesso;
	}
	public void setSenha_acesso(String senha_acesso) {
		this.senha_acesso = senha_acesso;
	}
	public Produto getProduto_combo() {
		return produto_combo;
	}
	public void setProduto_combo(Produto produto_combo) {
		this.produto_combo = produto_combo;
	}
	public String getEvent_code() {
		return event_code;
	}
	public void setEvent_code(String event_code) {
		this.event_code = event_code;
	}
	public Integer getNco_ramo() {
		return nco_ramo;
	}
	public void setNco_ramo(Integer nco_ramo) {
		this.nco_ramo = nco_ramo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTb_segmento() {
		return tb_segmento;
	}
	public void setTb_segmento(String tb_segmento) {
		this.tb_segmento = tb_segmento;
	}
	public String getTb_sigla() {
		return tb_sigla;
	}
	public void setTb_sigla(String tb_sigla) {
		this.tb_sigla = tb_sigla;
	}
	public Integer getNco_cia() {
		return nco_cia;
	}
	public void setNco_cia(Integer nco_cia) {
		this.nco_cia = nco_cia;
	}
	public String getTb_razao() {
		return tb_razao;
	}
	public void setTb_razao(String tb_razao) {
		this.tb_razao = tb_razao;
	}
	public Congenere_combo getCongenere_combo() {
		return congenere_combo;
	}
	public void setCongenere_combo(Congenere_combo congenere_combo) {
		this.congenere_combo = congenere_combo;
	}
	public Ncocia_combo getNco_cia_combo() {
		return nco_cia_combo;
	}
	public void setNco_cia_combo(Ncocia_combo nco_cia_combo) {
		this.nco_cia_combo = nco_cia_combo;
	}
	public Integer getId_subsegmento() {
		return id_subsegmento;
	}
	public void setId_subsegmento(Integer id_subsegmento) {
		this.id_subsegmento = id_subsegmento;
	}
	@Override
	public String toString() {
		return "Segmento [id=" + id + ", id_apolice=" + id_apolice
				+ ", sid_apolice=" + sid_apolice + ", senha_acesso="
				+ senha_acesso + ", tb_segmento=" + tb_segmento + ", tb_sigla="
				+ tb_sigla + ", nco_cia=" + nco_cia + ", nco_ramo=" + nco_ramo
				+ ", event_code=" + event_code + ", id_subsegmento="
				+ id_subsegmento + ", tb_razao=" + tb_razao
				+ ", congenere_combo=" + congenere_combo + ", nco_cia_combo="
				+ nco_cia_combo + ", produto_combo=" + produto_combo + "]";
	} 
}
