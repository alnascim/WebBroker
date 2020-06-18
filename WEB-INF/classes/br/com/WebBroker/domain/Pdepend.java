package br.com.WebBroker.domain;

import java.util.Date;

public class Pdepend {

	private String tb_num_carteira;
	private Long idtb_pessoafisica;
	private Long idtb_dependente;
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
	private Titular_combo titular_combo = new Titular_combo();	
	private String tb_pf_nome;
	private String tb_pf_nome_t;
	
	public Long getIdtb_pessoafisica() {
		return idtb_pessoafisica;
	}
	public void setIdtb_pessoafisica(Long idtb_pessoafisica) {
		this.idtb_pessoafisica = idtb_pessoafisica;
	}
	public Long getIdtb_dependente() {
		return idtb_dependente;
	}
	public void setIdtb_dependente(Long idtb_dependente) {
		this.idtb_dependente = idtb_dependente;
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
	public String getTb_pf_cpf() {
		return tb_pf_cpf;
	}
	public void setTb_pf_cpf(String tb_pf_cpf) {
		this.tb_pf_cpf = tb_pf_cpf;
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
	public Titular_combo getTitular_combo() {
		return titular_combo;
	}
	public void setTitular_combo(Titular_combo titular_combo) {
		this.titular_combo = titular_combo;
	}
	public String getTb_pf_nome() {
		return tb_pf_nome;
	}
	public void setTb_pf_nome(String tb_pf_nome) {
		this.tb_pf_nome = tb_pf_nome;
	}
	public String getTb_pf_nome_t() {
		return tb_pf_nome_t;
	}
	public void setTb_pf_nome_t(String tb_pf_nome_t) {
		this.tb_pf_nome_t = tb_pf_nome_t;
	}
	public String getTb_num_carteira() {
		return tb_num_carteira;
	}
	public void setTb_num_carteira(String tb_num_carteira) {
		this.tb_num_carteira = tb_num_carteira;
	}
	@Override
	public String toString() {
		return "Pdepend [tb_num_carteira=" + tb_num_carteira
				+ ", idtb_pessoafisica=" + idtb_pessoafisica
				+ ", idtb_dependente=" + idtb_dependente + ", tb_pf_sexo="
				+ tb_pf_sexo + ", tb_pf_datanasc=" + tb_pf_datanasc
				+ ", tb_pf_cpf=" + tb_pf_cpf + ", tb_pf_RIC=" + tb_pf_RIC
				+ ", tb_pf_cartao_saude=" + tb_pf_cartao_saude
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
				+ pf_dt_ini_vig + ", tb_idpj=" + tb_idpj + ", titular_combo="
				+ titular_combo + ", tb_pf_nome=" + tb_pf_nome
				+ ", tb_pf_nome_t=" + tb_pf_nome_t + "]";
	}

	
}
