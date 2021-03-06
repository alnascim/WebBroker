package br.com.WebBroker.domain;

import java.util.Date;

public class Pfisica {


	private String tb_razao;
	private Long id_beneficio;
	private String tb_num_carteira;
	private Long RECORD_ID;
	private String STATE;
	private String STREET_ZIPCODE;
	private String SVERIFY_CPF;
	private String CITY;
	private String DISTRICT;
	private String STREET_TYPE;
	private String STREET_NAME;
	private String STREET_COMP;
	private long tb_cep_num;
	private String tb_cep_compl;
	private Long idtb_pessoafisica;
	private String tb_pf_sexo;
	private String tb_pf_datanasc;
	private String tb_pf_cpf;
	private String tb_pf_RIC;
	private String tb_pf_cartao_saude;
	private String tb_pf_nascido_vivo;
	private String tb_pf_matricula_func;
	private String tb_pf_data_adm;
	private String tb_pf_nro_docto;
	private String tb_pf_natur_id;
	private String tb_pf_orgao_exp;
	private String tb_pf_DataExped;
	private String tb_pf_PISPASEP;
	private String tb_pf_nome_respons;
	private Long tb_pf_estciv;
	private String tb_pf_altura;
	private String tb_pf_peso;
	private String tb_pf_profissao;
	private String tb_pf_nome_mae;
	private String tb_pf_CEP;
	private String tb_pf_email;
	private String tb_pf_fone01;
	private String tb_pf_ddd01;
	private String tb_pf_fone02;
	private String tb_pf_ddd02;
	private String tb_pf_transf_titular;
	private String tb_pf_forma_reemb;
	private String tb_pf_nro_banco;
	private String tb_pf_nome_banco;
	private String tb_pf_agencia;
	private String tb_pf_conta;
	private String tb_pessoafisicacol;
	private String tb_dt_ini_vig;
	private Date pf_datanasc;
	private Date pf_data_adm;
	private Date pf_DataExped;
	private Date pf_dt_ini_vig;
	private Long tb_idpj;
	private Long tb_id_prof;
	private Long tb_id_est_civ;
	private Long tb_id_parent;
	private Parentesco parentesco_combo = new Parentesco();
	private Estadocivil estadocivil_combo = new Estadocivil();
	private Profissao profissao_combo = new Profissao();
	private Empresa_combo empresa_combo = new Empresa_combo();
	private Congenere_combo congenere_combo = new Congenere_combo();
	private Segmento segmento_combo = new Segmento();
	private Titular_combo titular_combo = new Titular_combo();
	private Pjuridica pjuridica = new Pjuridica();
	private String tb_pf_nome;
	private Tipopessoafisica tipopessoafisica = new Tipopessoafisica();
	private Segmento apolice_combo = new Segmento();
	private Segmento apolices_combo = new Segmento();
	public Segmento getApolices_combo() {
		return apolices_combo;
	}

	public void setApolices_combo(Segmento apolices_combo) {
		this.apolices_combo = apolices_combo;
	}
	public Segmento getApolice_combo() {
		return apolice_combo;
	}

	public void setApolice_combo(Segmento apolice_combo) {
		this.apolice_combo = apolice_combo;
	}

	public String getTb_razao() {
		return tb_razao;
	}

	public void setTb_razao(String tb_razao) {
		this.tb_razao = tb_razao;
	}

	public Long getId_beneficio() {
		return id_beneficio;
	}

	public void setId_beneficio(Long id_beneficio) {
		this.id_beneficio = id_beneficio;
	}

	public Segmento getSegmento_combo() {
		return segmento_combo;
	}

	public void setSegmento_combo(Segmento segmento_combo) {
		this.segmento_combo = segmento_combo;
	}

	public Congenere_combo getCongenere_combo() {
		return congenere_combo;
	}

	public void setCongenere_combo(Congenere_combo congenere_combo) {
		this.congenere_combo = congenere_combo;
	}

	public String gettb_razao() {
		return tb_razao;
	}

	public void settb_razao(String tb_razao) {
		this.tb_razao = tb_razao;
	}

	public String getSTREET_ZIPCODE() {
		return STREET_ZIPCODE;
	}

	public void setSTREET_ZIPCODE(String sTREET_ZIPCODE) {
		STREET_ZIPCODE = sTREET_ZIPCODE;
	}

	public String getTb_pf_cpf() {
		return tb_pf_cpf;
	}

	public void setTb_pf_cpf(String tb_pf_cpf) {
		this.tb_pf_cpf = tb_pf_cpf;
	}

	public String getSVERIFY_CPF() {
		return SVERIFY_CPF;
	}

	public void setSVERIFY_CPF(String sVERIFY_CPF) {
		SVERIFY_CPF = sVERIFY_CPF;
	}

	public Long getIdtb_pessoafisica() {
		return idtb_pessoafisica;
	}

	public void setIdtb_pessoafisica(Long idtb_pessoafisica) {
		this.idtb_pessoafisica = idtb_pessoafisica;
	}

	public String getTb_pf_sexo() {
		return tb_pf_sexo;
	}

	public void setTb_pf_sexo(String tb_pf_sexo) {
		this.tb_pf_sexo = tb_pf_sexo;
	}

	public String getTb_pf_datanasc() {
		return tb_pf_datanasc;
	}

	public void setTb_pf_datanasc(String tb_pf_datanasc) {
		this.tb_pf_datanasc = tb_pf_datanasc;
	}

	public String getTb_pf_RIC() {
		return tb_pf_RIC;
	}

	public void setTb_pf_RIC(String tb_pf_RIC) {
		this.tb_pf_RIC = tb_pf_RIC;
	}

	public String getTb_pf_cartao_saude() {
		return tb_pf_cartao_saude;
	}

	public void setTb_pf_cartao_saude(String tb_pf_cartao_saude) {
		this.tb_pf_cartao_saude = tb_pf_cartao_saude;
	}

	public String getTb_pf_nascido_vivo() {
		return tb_pf_nascido_vivo;
	}

	public void setTb_pf_nascido_vivo(String tb_pf_nascido_vivo) {
		this.tb_pf_nascido_vivo = tb_pf_nascido_vivo;
	}

	public String getTb_pf_matricula_func() {
		return tb_pf_matricula_func;
	}

	public void setTb_pf_matricula_func(String tb_pf_matricula_func) {
		this.tb_pf_matricula_func = tb_pf_matricula_func;
	}

	public String getTb_pf_data_adm() {
		return tb_pf_data_adm;
	}

	public void setTb_pf_data_adm(String tb_pf_data_adm) {
		this.tb_pf_data_adm = tb_pf_data_adm;
	}

	public String getTb_pf_nro_docto() {
		return tb_pf_nro_docto;
	}

	public void setTb_pf_nro_docto(String tb_pf_nro_docto) {
		this.tb_pf_nro_docto = tb_pf_nro_docto;
	}

	public String getTb_pf_natur_id() {
		return tb_pf_natur_id;
	}

	public void setTb_pf_natur_id(String tb_pf_natur_id) {
		this.tb_pf_natur_id = tb_pf_natur_id;
	}

	public String getTb_pf_orgao_exp() {
		return tb_pf_orgao_exp;
	}

	public void setTb_pf_orgao_exp(String tb_pf_orgao_exp) {
		this.tb_pf_orgao_exp = tb_pf_orgao_exp;
	}

	public String getTb_pf_DataExped() {
		return tb_pf_DataExped;
	}

	public void setTb_pf_DataExped(String tb_pf_DataExped) {
		this.tb_pf_DataExped = tb_pf_DataExped;
	}

	public String getTb_pf_PISPASEP() {
		return tb_pf_PISPASEP;
	}

	public void setTb_pf_PISPASEP(String tb_pf_PISPASEP) {
		this.tb_pf_PISPASEP = tb_pf_PISPASEP;
	}

	public String getTb_pf_nome_respons() {
		return tb_pf_nome_respons;
	}

	public void setTb_pf_nome_respons(String tb_pf_nome_respons) {
		this.tb_pf_nome_respons = tb_pf_nome_respons;
	}

	public Long getTb_pf_estciv() {
		return tb_pf_estciv;
	}

	public void setTb_pf_estciv(Long tb_pf_estciv) {
		this.tb_pf_estciv = tb_pf_estciv;
	}

	public String getTb_pf_altura() {
		return tb_pf_altura;
	}

	public void setTb_pf_altura(String tb_pf_altura) {
		this.tb_pf_altura = tb_pf_altura;
	}

	public String getTb_pf_peso() {
		return tb_pf_peso;
	}

	public void setTb_pf_peso(String tb_pf_peso) {
		this.tb_pf_peso = tb_pf_peso;
	}

	public String getTb_pf_profissao() {
		return tb_pf_profissao;
	}

	public void setTb_pf_profissao(String tb_pf_profissao) {
		this.tb_pf_profissao = tb_pf_profissao;
	}

	public String getTb_pf_nome_mae() {
		return tb_pf_nome_mae;
	}

	public void setTb_pf_nome_mae(String tb_pf_nome_mae) {
		this.tb_pf_nome_mae = tb_pf_nome_mae;
	}

	public String getTb_pf_CEP() {
		return tb_pf_CEP;
	}

	public void setTb_pf_CEP(String tb_pf_CEP) {
		this.tb_pf_CEP = tb_pf_CEP;
	}

	public String getTb_pf_email() {
		return tb_pf_email;
	}

	public void setTb_pf_email(String tb_pf_email) {
		this.tb_pf_email = tb_pf_email;
	}

	public String getTb_pf_fone01() {
		return tb_pf_fone01;
	}

	public void setTb_pf_fone01(String tb_pf_fone01) {
		this.tb_pf_fone01 = tb_pf_fone01;
	}

	public String getTb_pf_ddd01() {
		return tb_pf_ddd01;
	}

	public void setTb_pf_ddd01(String tb_pf_ddd01) {
		this.tb_pf_ddd01 = tb_pf_ddd01;
	}

	public String getTb_pf_fone02() {
		return tb_pf_fone02;
	}

	public void setTb_pf_fone02(String tb_pf_fone02) {
		this.tb_pf_fone02 = tb_pf_fone02;
	}

	public String getTb_pf_ddd02() {
		return tb_pf_ddd02;
	}

	public void setTb_pf_ddd02(String tb_pf_ddd02) {
		this.tb_pf_ddd02 = tb_pf_ddd02;
	}

	public String getTb_pf_transf_titular() {
		return tb_pf_transf_titular;
	}

	public void setTb_pf_transf_titular(String tb_pf_transf_titular) {
		this.tb_pf_transf_titular = tb_pf_transf_titular;
	}

	public String getTb_pf_forma_reemb() {
		return tb_pf_forma_reemb;
	}

	public void setTb_pf_forma_reemb(String tb_pf_forma_reemb) {
		this.tb_pf_forma_reemb = tb_pf_forma_reemb;
	}

	public String getTb_pf_nro_banco() {
		return tb_pf_nro_banco;
	}

	public void setTb_pf_nro_banco(String tb_pf_nro_banco) {
		this.tb_pf_nro_banco = tb_pf_nro_banco;
	}

	public String getTb_pf_nome_banco() {
		return tb_pf_nome_banco;
	}

	public void setTb_pf_nome_banco(String tb_pf_nome_banco) {
		this.tb_pf_nome_banco = tb_pf_nome_banco;
	}

	public String getTb_pf_agencia() {
		return tb_pf_agencia;
	}

	public void setTb_pf_agencia(String tb_pf_agencia) {
		this.tb_pf_agencia = tb_pf_agencia;
	}

	public String getTb_pf_conta() {
		return tb_pf_conta;
	}

	public void setTb_pf_conta(String tb_pf_conta) {
		this.tb_pf_conta = tb_pf_conta;
	}

	public String getTb_pessoafisicacol() {
		return tb_pessoafisicacol;
	}

	public void setTb_pessoafisicacol(String tb_pessoafisicacol) {
		this.tb_pessoafisicacol = tb_pessoafisicacol;
	}

	public String getTb_dt_ini_vig() {
		return tb_dt_ini_vig;
	}

	public void setTb_dt_ini_vig(String tb_dt_ini_vig) {
		this.tb_dt_ini_vig = tb_dt_ini_vig;
	}

	public Date getPf_datanasc() {
		return pf_datanasc;
	}

	public void setPf_datanasc(Date pf_datanasc) {
		this.pf_datanasc = pf_datanasc;
	}

	public Date getPf_data_adm() {
		return pf_data_adm;
	}

	public void setPf_data_adm(Date pf_data_adm) {
		this.pf_data_adm = pf_data_adm;
	}

	public Date getPf_DataExped() {
		return pf_DataExped;
	}

	public void setPf_DataExped(Date pf_DataExped) {
		this.pf_DataExped = pf_DataExped;
	}

	public Date getPf_dt_ini_vig() {
		return pf_dt_ini_vig;
	}

	public void setPf_dt_ini_vig(Date pf_dt_ini_vig) {
		this.pf_dt_ini_vig = pf_dt_ini_vig;
	}

	public Long getTb_idpj() {
		return tb_idpj;
	}

	public void setTb_idpj(Long tb_idpj) {
		this.tb_idpj = tb_idpj;
	}

	public Long getTb_id_prof() {
		return tb_id_prof;
	}

	public void setTb_id_prof(Long tb_id_prof) {
		this.tb_id_prof = tb_id_prof;
	}

	public Long getTb_id_est_civ() {
		return tb_id_est_civ;
	}

	public void setTb_id_est_civ(Long tb_id_est_civ) {
		this.tb_id_est_civ = tb_id_est_civ;
	}

	public Long getTb_id_parent() {
		return tb_id_parent;
	}

	public void setTb_id_parent(Long tb_id_parent) {
		this.tb_id_parent = tb_id_parent;
	}

	public Parentesco getParentesco_combo() {
		return parentesco_combo;
	}

	public void setParentesco_combo(Parentesco parentesco_combo) {
		this.parentesco_combo = parentesco_combo;
	}

	public Estadocivil getEstadocivil_combo() {
		return estadocivil_combo;
	}

	public void setEstadocivil_combo(Estadocivil estadocivil_combo) {
		this.estadocivil_combo = estadocivil_combo;
	}

	public Profissao getProfissao_combo() {
		return profissao_combo;
	}

	public void setProfissao_combo(Profissao profissao_combo) {
		this.profissao_combo = profissao_combo;
	}

	public Empresa_combo getEmpresa_combo() {
		return empresa_combo;
	}

	public void setEmpresa_combo(Empresa_combo empresa_combo) {
		this.empresa_combo = empresa_combo;
	}

	public Titular_combo getTitular_combo() {
		return titular_combo;
	}

	public void setTitular_combo(Titular_combo titular_combo) {
		this.titular_combo = titular_combo;
	}

	public Pjuridica getPjuridica() {
		return pjuridica;
	}

	public void setPjuridica(Pjuridica pjuridica) {
		this.pjuridica = pjuridica;
	}

	public String getTb_pf_nome() {
		return tb_pf_nome;
	}

	public void setTb_pf_nome(String tb_pf_nome) {
		this.tb_pf_nome = tb_pf_nome;
	}

	public Tipopessoafisica getTipopessoafisica() {
		return tipopessoafisica;
	}

	public void setTipopessoafisica(Tipopessoafisica tipopessoafisica) {
		this.tipopessoafisica = tipopessoafisica;
	}

	public long getTb_cep_num() {
		return tb_cep_num;
	}

	public void setTb_cep_num(long tb_cep_num) {
		this.tb_cep_num = tb_cep_num;
	}

	public String getTb_cep_compl() {
		return tb_cep_compl;
	}

	public void setTb_cep_compl(String tb_cep_compl) {
		this.tb_cep_compl = tb_cep_compl;
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

	public String getTb_num_carteira() {
		return tb_num_carteira;
	}

	public void setTb_num_carteira(String tb_num_carteira) {
		this.tb_num_carteira = tb_num_carteira;
	}

	@Override
	public String toString() {
		return "Pfisica [tb_razao=" + tb_razao + ", id_beneficio="
				+ id_beneficio + ", tb_num_carteira=" + tb_num_carteira
				+ ", RECORD_ID=" + RECORD_ID + ", STATE=" + STATE
				+ ", STREET_ZIPCODE=" + STREET_ZIPCODE + ", SVERIFY_CPF="
				+ SVERIFY_CPF + ", CITY=" + CITY + ", DISTRICT=" + DISTRICT
				+ ", STREET_TYPE=" + STREET_TYPE + ", STREET_NAME="
				+ STREET_NAME + ", STREET_COMP=" + STREET_COMP
				+ ", tb_cep_num=" + tb_cep_num + ", tb_cep_compl="
				+ tb_cep_compl + ", idtb_pessoafisica=" + idtb_pessoafisica
				+ ", tb_pf_sexo=" + tb_pf_sexo + ", tb_pf_datanasc="
				+ tb_pf_datanasc + ", tb_pf_cpf=" + tb_pf_cpf + ", tb_pf_RIC="
				+ tb_pf_RIC + ", tb_pf_cartao_saude=" + tb_pf_cartao_saude
				+ ", tb_pf_nascido_vivo=" + tb_pf_nascido_vivo
				+ ", tb_pf_matricula_func=" + tb_pf_matricula_func
				+ ", tb_pf_data_adm=" + tb_pf_data_adm + ", tb_pf_nro_docto="
				+ tb_pf_nro_docto + ", tb_pf_natur_id=" + tb_pf_natur_id
				+ ", tb_pf_orgao_exp=" + tb_pf_orgao_exp + ", tb_pf_DataExped="
				+ tb_pf_DataExped + ", tb_pf_PISPASEP=" + tb_pf_PISPASEP
				+ ", tb_pf_nome_respons=" + tb_pf_nome_respons
				+ ", tb_pf_estciv=" + tb_pf_estciv + ", tb_pf_altura="
				+ tb_pf_altura + ", tb_pf_peso=" + tb_pf_peso
				+ ", tb_pf_profissao=" + tb_pf_profissao + ", tb_pf_nome_mae="
				+ tb_pf_nome_mae + ", tb_pf_CEP=" + tb_pf_CEP
				+ ", tb_pf_email=" + tb_pf_email + ", tb_pf_fone01="
				+ tb_pf_fone01 + ", tb_pf_ddd01=" + tb_pf_ddd01
				+ ", tb_pf_fone02=" + tb_pf_fone02 + ", tb_pf_ddd02="
				+ tb_pf_ddd02 + ", tb_pf_transf_titular="
				+ tb_pf_transf_titular + ", tb_pf_forma_reemb="
				+ tb_pf_forma_reemb + ", tb_pf_nro_banco=" + tb_pf_nro_banco
				+ ", tb_pf_nome_banco=" + tb_pf_nome_banco + ", tb_pf_agencia="
				+ tb_pf_agencia + ", tb_pf_conta=" + tb_pf_conta
				+ ", tb_pessoafisicacol=" + tb_pessoafisicacol
				+ ", tb_dt_ini_vig=" + tb_dt_ini_vig + ", pf_datanasc="
				+ pf_datanasc + ", pf_data_adm=" + pf_data_adm
				+ ", pf_DataExped=" + pf_DataExped + ", pf_dt_ini_vig="
				+ pf_dt_ini_vig + ", tb_idpj=" + tb_idpj + ", tb_id_prof="
				+ tb_id_prof + ", tb_id_est_civ=" + tb_id_est_civ
				+ ", tb_id_parent=" + tb_id_parent + ", parentesco_combo="
				+ parentesco_combo + ", estadocivil_combo=" + estadocivil_combo
				+ ", profissao_combo=" + profissao_combo + ", empresa_combo="
				+ empresa_combo + ", congenere_combo=" + congenere_combo
				+ ", segmento_combo=" + segmento_combo + ", titular_combo="
				+ titular_combo + ", pjuridica=" + pjuridica + ", tb_pf_nome="
				+ tb_pf_nome + ", tipopessoafisica=" + tipopessoafisica
				+ ", apolice_combo=" + apolice_combo + ", apolices_combo="
				+ apolices_combo + "]";
	}

}
