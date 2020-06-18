package br.com.WebBroker.domain;

import java.text.DateFormat;
import java.util.Date;


public class ListaFatura {

	private Date pf_DataFim;
	private Date pf_DataIni;
	private Integer ID_EXT;	
	private String segmento;
	private String nco_nm_segurado;
	private String tb_Cnpj;
	private String tb_Suc;
	private String tb_Endo;
	private String tb_Item;
	private String tb_fatura;
	private String tb_Razao;
	private double vl_premio;
	private String nco_comis;
	private double nco_comis_b ;
	private double nco_comis_a ;
	private String nco_fat_comis;
	private String nco_apol;
	private String nco_amd_cobranca;
	private String nco_ramo;
	private String nco_prest;
	private String nco_perc;
	private String nco_nr_proposta;
	private String tb_pf_nome;
	private String nco_prest_next;
	private String nco_amd_cobr_next;
	private String dtinifat;
	private String dtfimfat;
	private String tb_nome_agencia;
	private DateFormat pf_dtinifat;
	private DateFormat pf_dtfimfat;
	private Date pf_DataFim_ext;
	private Date pf_DataIni_ext;

	
	public Date getPf_DataFim_ext() {
		return pf_DataFim_ext;
	}

	public void setPf_DataFim_ext(Date pf_DataFim_ext) {
		this.pf_DataFim_ext = pf_DataFim_ext;
	}

	public Date getPf_DataIni_ext() {
		return pf_DataIni_ext;
	}

	public void setPf_DataIni_ext(Date pf_DataIni_ext) {
		this.pf_DataIni_ext = pf_DataIni_ext;
	}
	public Date getPf_DataFim() {
		return pf_DataFim;
	}

	public void setPf_DataFim(Date pf_DataFim) {
		this.pf_DataFim = pf_DataFim;
	}

	public Date getPf_DataIni() {
		return pf_DataIni;
	}

	public void setPf_DataIni(Date pf_DataIni) {
		this.pf_DataIni = pf_DataIni;
	}
	
	public Integer getID_EXT() {
		return ID_EXT;
	}

	public void setID_EXT(Integer iD_EXT) {
		ID_EXT = iD_EXT;
	}	
	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}
	public String getNco_nm_segurado() {
		return nco_nm_segurado;
	}
	public void setNco_nm_segurado(String nco_nm_segurado) {
		this.nco_nm_segurado = nco_nm_segurado;
	}
	public String getTb_Cnpj() {
		return tb_Cnpj;
	}
	public void setTb_Cnpj(String tb_Cnpj) {
		this.tb_Cnpj = tb_Cnpj;
	}
	public String getTb_Suc() {
		return tb_Suc;
	}
	public void setTb_Suc(String tb_Suc) {
		this.tb_Suc = tb_Suc;
	}
	public String getTb_Endo() {
		return tb_Endo;
	}
	public void setTb_Endo(String tb_Endo) {
		this.tb_Endo = tb_Endo;
	}
	public String getTb_Item() {
		return tb_Item;
	}
	public void setTb_Item(String tb_Item) {
		this.tb_Item = tb_Item;
	}
	public String getTb_Razao() {
		return tb_Razao;
	}
	public void setTb_Razao(String tb_Razao) {
		this.tb_Razao = tb_Razao;
	}
	public double getVl_premio() {
		return vl_premio;
	}
	public void setVl_premio(double vl_premio) {
		this.vl_premio = vl_premio;
	}
	public String getNco_comis() {
		return nco_comis;
	}
	public void setNco_comis(String nco_comis) {
		this.nco_comis = nco_comis;
	}
	public double getNco_comis_b() {
		return nco_comis_b;
	}
	public void setNco_comis_b(double nco_comis_b) {
		this.nco_comis_b = nco_comis_b;
	}
	public String getNco_fat_comis() {
		return nco_fat_comis;
	}
	public void setNco_fat_comis(String nco_fat_comis) {
		this.nco_fat_comis = nco_fat_comis;
	}
	public String getNco_apol() {
		return nco_apol;
	}
	public void setNco_apol(String nco_apol) {
		this.nco_apol = nco_apol;
	}
	public String getNco_amd_cobranca() {
		return nco_amd_cobranca;
	}
	public void setNco_amd_cobranca(String nco_amd_cobranca) {
		this.nco_amd_cobranca = nco_amd_cobranca;
	}
	public String getNco_ramo() {
		return nco_ramo;
	}
	public void setNco_ramo(String nco_ramo) {
		this.nco_ramo = nco_ramo;
	}
	public String getNco_prest() {
		return nco_prest;
	}
	public void setNco_prest(String nco_prest) {
		this.nco_prest = nco_prest;
	}
	public String getNco_perc() {
		return nco_perc;
	}
	public void setNco_perc(String nco_perc) {
		this.nco_perc = nco_perc;
	}
	public String getNco_nr_proposta() {
		return nco_nr_proposta;
	}
	public void setNco_nr_proposta(String nco_nr_proposta) {
		this.nco_nr_proposta = nco_nr_proposta;
	}
	public String getTb_pf_nome() {
		return tb_pf_nome;
	}
	public void setTb_pf_nome(String tb_pf_nome) {
		this.tb_pf_nome = tb_pf_nome;
	}
	public String getNco_prest_next() {
		return nco_prest_next;
	}
	public void setNco_prest_next(String nco_prest_next) {
		this.nco_prest_next = nco_prest_next;
	}
	public String getNco_amd_cobranca_int_next() {
		return nco_amd_cobr_next;
	}
	public void setNco_amd_cobranca_int_next(String nco_amd_cobr_next) {
		this.nco_amd_cobr_next = nco_amd_cobr_next;
	}

	public String getNco_amd_cobr_next() {
		return nco_amd_cobr_next;
	}

	public void setNco_amd_cobr_next(String nco_amd_cobr_next) {
		this.nco_amd_cobr_next = nco_amd_cobr_next;
	}

	public DateFormat getPf_dtinifat() {
		return pf_dtinifat;
	}

	public void setPf_dtinifat(DateFormat pf_dtinifat) {
		this.pf_dtinifat = pf_dtinifat;
	}

	public DateFormat getPf_dtfimfat() {
		return pf_dtfimfat;
	}

	public void setPf_dtfimfat(DateFormat pf_dtfimfat) {
		this.pf_dtfimfat = pf_dtfimfat;
	}

	public void setDtinifat(String dtinifat) {
		this.dtinifat = dtinifat;
	}

	public void setDtfimfat(String dtfimfat) {
		this.dtfimfat = dtfimfat;
	}

	public String getTb_nome_agencia() {
		return tb_nome_agencia;
	}

	public void setTb_nome_agencia(String tb_nome_agencia) {
		this.tb_nome_agencia = tb_nome_agencia;
	}

	public String getDtinifat() {
		return dtinifat;
	}

	public String getDtfimfat() {
		return dtfimfat;
	}

	public String getTb_fatura() {
		return tb_fatura;
	}

	public void setTb_fatura(String tb_fatura) {
		this.tb_fatura = tb_fatura;
	}

	public double getNco_comis_a() {
		return nco_comis_a;
	}

	public void setNco_comis_a(double nco_comis_a) {
		this.nco_comis_a = nco_comis_a;
	}
	@Override
	public String toString() {
		return "ListaFatura [pf_DataFim=" + pf_DataFim + ", pf_DataIni="
				+ pf_DataIni + ", ID_EXT=" + ID_EXT + ", segmento=" + segmento
				+ ", nco_nm_segurado=" + nco_nm_segurado + ", tb_Cnpj="
				+ tb_Cnpj + ", tb_Suc=" + tb_Suc + ", tb_Endo=" + tb_Endo
				+ ", tb_Item=" + tb_Item + ", tb_fatura=" + tb_fatura
				+ ", tb_Razao=" + tb_Razao + ", vl_premio=" + vl_premio
				+ ", nco_comis=" + nco_comis + ", nco_comis_b=" + nco_comis_b
				+ ", nco_comis_a=" + nco_comis_a + ", nco_fat_comis="
				+ nco_fat_comis + ", nco_apol=" + nco_apol
				+ ", nco_amd_cobranca=" + nco_amd_cobranca + ", nco_ramo="
				+ nco_ramo + ", nco_prest=" + nco_prest + ", nco_perc="
				+ nco_perc + ", nco_nr_proposta=" + nco_nr_proposta
				+ ", tb_pf_nome=" + tb_pf_nome + ", nco_prest_next="
				+ nco_prest_next + ", nco_amd_cobr_next=" + nco_amd_cobr_next
				+ ", dtinifat=" + dtinifat + ", dtfimfat=" + dtfimfat
				+ ", tb_nome_agencia=" + tb_nome_agencia + ", pf_dtinifat="
				+ pf_dtinifat + ", pf_dtfimfat=" + pf_dtfimfat
				+ ", pf_DataFim_ext=" + pf_DataFim_ext + ", pf_DataIni_ext="
				+ pf_DataIni_ext + "]";
	}
	
	 
}
