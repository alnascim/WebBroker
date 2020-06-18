package br.com.WebBroker.domain;

import java.util.Date;

public class Pjuridica {

	
	private String tb_tipocontato;
	private Long RECORD_ID;
	private String STATE;
	private String STREET_ZIPCODE;
	private String CITY;
	private String DISTRICT;
	private String STREET_TYPE;
	private String STREET_NAME;
	private String STREET_COMP;
	private long tb_cep_num;
	private Long tb_numapo;
	private Long tb_numapo_conjug;
	private Long tb_IDPJ;
	private String tb_Cnpj;
	private String tb_cep;
	private String tb_cepcorresp;
	private String tb_Razao;
	private Long tb_Qtd_Socio;
	private String tb_Contato;
	private String tb_email;
	private String tb_ini_ativ;
	private Date Ini_ativ;
	private String tb_pf_nome;
	private String tb_senha_acesso;
	private String segmento;
	private long id_segmento;
	private long id_angariador;
	private long tb_cod_agencia;
	private Angariador_combo angariador_combo = new Angariador_combo();
	private Segmento segmento_combo = new Segmento();
	private Pagencia pagencia_combo = new Pagencia();
	
	public String getTb_cep() {
		return tb_cep;
	}
	public void setTb_cep(String tb_cep) {
		this.tb_cep = tb_cep;
	}
	

	public Long getTb_numapo() {
		return tb_numapo;
	}
	public void setTb_numapo(Long tb_numapo) {
		this.tb_numapo = tb_numapo;
	}
	public Long getTb_IDPJ() {
		return tb_IDPJ;
	}
	public void setTb_IDPJ(Long tb_IDPJ) {
		this.tb_IDPJ = tb_IDPJ;
	}
	public String getTb_Cnpj() {
		return tb_Cnpj;
	}
	public void setTb_Cnpj(String tb_Cnpj) {
		this.tb_Cnpj = tb_Cnpj;
	}
	public String getTb_Razao() {
		return tb_Razao;
	}
	public void setTb_Razao(String tb_Razao) {
		this.tb_Razao = tb_Razao;
	}
	public Long getTb_Qtd_Socio() {
		return tb_Qtd_Socio;
	}
	public void setTb_Qtd_Socio(Long tb_Qtd_Socio) {
		this.tb_Qtd_Socio = tb_Qtd_Socio;
	}
	public String getTb_Contato() {
		return tb_Contato;
	}
	public void setTb_Contato(String tb_Contato) {
		this.tb_Contato = tb_Contato;
	}
	public String getTb_email() {
		return tb_email;
	}
	public void setTb_email(String tb_email) {
		this.tb_email = tb_email;
	}
	public String getTb_ini_ativ() {
		return tb_ini_ativ;
	}
	public void setTb_ini_ativ(String tb_ini_ativ) {
		this.tb_ini_ativ = tb_ini_ativ;
	}
	public Date getIni_ativ() {
		return Ini_ativ;
	}
	public void setIni_ativ(Date ini_ativ) {
		Ini_ativ = ini_ativ;
	}
	public String getTb_pf_nome() {
		return tb_pf_nome;
	}
	public void setTb_pf_nome(String tb_pf_nome) {
		this.tb_pf_nome = tb_pf_nome;
	}
	public String getTb_senha_acesso() {
		return tb_senha_acesso;
	}
	public void setTb_senha_acesso(String tb_senha_acesso) {
		this.tb_senha_acesso = tb_senha_acesso;
	}
	public String getSegmento() {
		return segmento;
	}
	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}
	public long getId_angariador() {
		return id_angariador;
	}
	public void setId_angariador(long id_angariador) {
		this.id_angariador = id_angariador;
	}
	public long getId_segmento() {
		return id_segmento;
	}
	public void setId_segmento(long id_segmento) {
		this.id_segmento = id_segmento;
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
	public Pagencia getPagencia_combo() {
		return pagencia_combo;
	}
	public void setPagencia_combo(Pagencia pagencia_combo) {
		this.pagencia_combo = pagencia_combo;
	}	
	
	public Long getRECORD_ID() {
		return RECORD_ID;
	}
	public void setRECORD_ID(Long rECORD_ID) {
		RECORD_ID = rECORD_ID;
	}
	public String getSTATE() {
		return STATE;
	}
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}
	public String getSTREET_ZIPCODE() {
		return STREET_ZIPCODE;
	}
	public void setSTREET_ZIPCODE(String sTREET_ZIPCODE) {
		STREET_ZIPCODE = sTREET_ZIPCODE;
	}
	public String getCITY() {
		return CITY;
	}
	public void setCITY(String cITY) {
		CITY = cITY;
	}
	public String getDISTRICT() {
		return DISTRICT;
	}
	public void setDISTRICT(String dISTRICT) {
		DISTRICT = dISTRICT;
	}
	public String getSTREET_TYPE() {
		return STREET_TYPE;
	}
	public void setSTREET_TYPE(String sTREET_TYPE) {
		STREET_TYPE = sTREET_TYPE;
	}
	public String getSTREET_NAME() {
		return STREET_NAME;
	}
	public void setSTREET_NAME(String sTREET_NAME) {
		STREET_NAME = sTREET_NAME;
	}
	public String getSTREET_COMP() {
		return STREET_COMP;
	}
	public void setSTREET_COMP(String sTREET_COMP) {
		STREET_COMP = sTREET_COMP;
	}
	public long getTb_cep_num() {
		return tb_cep_num;
	}
	public void setTb_cep_num(long tb_cep_num) {
		this.tb_cep_num = tb_cep_num;
	}
	public String getTb_tipocontato() {
		return tb_tipocontato;
	}
	public void setTb_tipocontato(String tb_tipocontato) {
		this.tb_tipocontato = tb_tipocontato;
	}
	public String getTb_cepcorresp() {
		return tb_cepcorresp;
	}
	public void setTb_cepcorresp(String tb_cepcorresp) {
		this.tb_cepcorresp = tb_cepcorresp;
	}
	public Long getTb_numapo_conjug() {
		return tb_numapo_conjug;
	}
	public void setTb_numapo_conjug(Long tb_numapo_conjug) {
		this.tb_numapo_conjug = tb_numapo_conjug;
	}
	public long getTb_cod_agencia() {
		return tb_cod_agencia;
	}
	public void setTb_cod_agencia(long tb_cod_agencia) {
		this.tb_cod_agencia = tb_cod_agencia;
	}
	@Override
	public String toString() {
		return "Pjuridica [tb_tipocontato=" + tb_tipocontato + ", RECORD_ID="
				+ RECORD_ID + ", STATE=" + STATE + ", STREET_ZIPCODE="
				+ STREET_ZIPCODE + ", CITY=" + CITY + ", DISTRICT=" + DISTRICT
				+ ", STREET_TYPE=" + STREET_TYPE + ", STREET_NAME="
				+ STREET_NAME + ", STREET_COMP=" + STREET_COMP
				+ ", tb_cep_num=" + tb_cep_num + ", tb_numapo=" + tb_numapo
				+ ", tb_numapo_conjug=" + tb_numapo_conjug + ", tb_IDPJ="
				+ tb_IDPJ + ", tb_Cnpj=" + tb_Cnpj + ", tb_cep=" + tb_cep
				+ ", tb_cepcorresp=" + tb_cepcorresp + ", tb_Razao=" + tb_Razao
				+ ", tb_Qtd_Socio=" + tb_Qtd_Socio + ", tb_Contato="
				+ tb_Contato + ", tb_email=" + tb_email + ", tb_ini_ativ="
				+ tb_ini_ativ + ", Ini_ativ=" + Ini_ativ + ", tb_pf_nome="
				+ tb_pf_nome + ", tb_senha_acesso=" + tb_senha_acesso
				+ ", segmento=" + segmento + ", id_segmento=" + id_segmento
				+ ", id_angariador=" + id_angariador + ", tb_cod_agencia="
				+ tb_cod_agencia + ", angariador_combo=" + angariador_combo
				+ ", segmento_combo=" + segmento_combo + ", pagencia_combo="
				+ pagencia_combo + "]";
	}


}
