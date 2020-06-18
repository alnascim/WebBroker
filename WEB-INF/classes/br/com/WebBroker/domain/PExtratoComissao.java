package br.com.WebBroker.domain;

import java.math.BigDecimal;

public class PExtratoComissao {


	private Integer ID_EXT;
	private String segmento;
	private String nco_nm_segurado;
	private String tb_Cnpj;
	private String tb_Razao;
	private String vl_premio;
	private String nco_comis;
	private String net_comis;
	private BigDecimal nco_comis_b = BigDecimal.ZERO;
	private String nco_fat_comis;
	private String nco_apol;
	private String nco_amd_cobranca;
	private String nco_date_str;
	private String nco_long_date;
	private String nco_ramo;
	private String nco_prest;
	private String nco_perc;
	private String nco_nr_proposta;
	private String tb_pf_nome;
	private String tb_surcursal;
	private String tb_ano_mes_prod;
	private String nse_nm_agencia;
	
	public Integer getID_EXT() {
		return ID_EXT;
	}
	public void setID_EXT(Integer iD_EXT) {
		ID_EXT = iD_EXT;
	}
	public String getNse_nm_agencia() {
		return nse_nm_agencia;
	}
	public void setNse_nm_agencia(String nse_nm_agencia) {
		this.nse_nm_agencia = nse_nm_agencia;
	}
	public String getNco_long_date() {
		return nco_long_date;
	}
	public void setNco_long_date(String nco_long_date) {
		this.nco_long_date = nco_long_date;
	}
	public String getSegmento() {
		return segmento;
	}
	public String getNco_nm_segurado() {
		return nco_nm_segurado;
	}
	public String getTb_Cnpj() {
		return tb_Cnpj;
	}
	public String getTb_Razao() {
		return tb_Razao;
	}
	public String getVl_premio() {
		return vl_premio;
	}
	public String getNco_comis() {
		return nco_comis;
	}
	public String getNet_comis() {
		return net_comis;
	}
	public BigDecimal getNco_comis_b() {
		return nco_comis_b;
	}
	public String getNco_fat_comis() {
		return nco_fat_comis;
	}
	public String getNco_apol() {
		return nco_apol;
	}
	public String getNco_amd_cobranca() {
		return nco_amd_cobranca;
	}
	public String getNco_date_str() {
		return nco_date_str;
	}
	public String getNco_ramo() {
		return nco_ramo;
	}
	public String getNco_prest() {
		return nco_prest;
	}
	public String getNco_perc() {
		return nco_perc;
	}
	public String getNco_nr_proposta() {
		return nco_nr_proposta;
	}
	public String getTb_pf_nome() {
		return tb_pf_nome;
	}
	public String getTb_surcursal() {
		return tb_surcursal;
	}
	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}
	public void setNco_nm_segurado(String nco_nm_segurado) {
		this.nco_nm_segurado = nco_nm_segurado;
	}
	public void setTb_Cnpj(String tb_Cnpj) {
		this.tb_Cnpj = tb_Cnpj;
	}
	public void setTb_Razao(String tb_Razao) {
		this.tb_Razao = tb_Razao;
	}
	public void setVl_premio(String vl_premio) {
		this.vl_premio = vl_premio;
	}
	public void setNco_comis(String nco_comis) {
		this.nco_comis = nco_comis;
	}
	public void setNet_comis(String net_comis) {
		this.net_comis = net_comis;
	}
	public void setNco_comis_b(BigDecimal nco_comis_b) {
		this.nco_comis_b = nco_comis_b;
	}
	public void setNco_fat_comis(String nco_fat_comis) {
		this.nco_fat_comis = nco_fat_comis;
	}
	public void setNco_apol(String nco_apol) {
		this.nco_apol = nco_apol;
	}
	public void setNco_amd_cobranca(String nco_amd_cobranca) {
		this.nco_amd_cobranca = nco_amd_cobranca;
	}
	public void setNco_date_str(String nco_date_str) {
		this.nco_date_str = nco_date_str;
	}
	public void setNco_ramo(String nco_ramo) {
		this.nco_ramo = nco_ramo;
	}
	public void setNco_prest(String nco_prest) {
		this.nco_prest = nco_prest;
	}
	public void setNco_perc(String nco_perc) {
		this.nco_perc = nco_perc;
	}
	public void setNco_nr_proposta(String nco_nr_proposta) {
		this.nco_nr_proposta = nco_nr_proposta;
	}
	public void setTb_pf_nome(String tb_pf_nome) {
		this.tb_pf_nome = tb_pf_nome;
	}
	public void setTb_surcursal(String tb_surcursal) {
		this.tb_surcursal = tb_surcursal;
	}
	public String getTb_ano_mes_prod() {
		return tb_ano_mes_prod;
	}
	public void setTb_ano_mes_prod(String tb_ano_mes_prod) {
		this.tb_ano_mes_prod = tb_ano_mes_prod;
	}
	@Override
	public String toString() {
		return "PExtratoComissao [ID_EXT=" + ID_EXT + ", segmento=" + segmento
				+ ", nco_nm_segurado=" + nco_nm_segurado + ", tb_Cnpj="
				+ tb_Cnpj + ", tb_Razao=" + tb_Razao + ", vl_premio="
				+ vl_premio + ", nco_comis=" + nco_comis + ", net_comis="
				+ net_comis + ", nco_comis_b=" + nco_comis_b
				+ ", nco_fat_comis=" + nco_fat_comis + ", nco_apol=" + nco_apol
				+ ", nco_amd_cobranca=" + nco_amd_cobranca + ", nco_date_str="
				+ nco_date_str + ", nco_long_date=" + nco_long_date
				+ ", nco_ramo=" + nco_ramo + ", nco_prest=" + nco_prest
				+ ", nco_perc=" + nco_perc + ", nco_nr_proposta="
				+ nco_nr_proposta + ", tb_pf_nome=" + tb_pf_nome
				+ ", tb_surcursal=" + tb_surcursal + ", tb_ano_mes_prod="
				+ tb_ano_mes_prod + ", nse_nm_agencia=" + nse_nm_agencia + "]";
	}

	

}
