package br.com.WebBroker.domain;

import java.util.Date;

public class ExtratoBancario {
	
	private Integer id;
	private String c_data;
	private Date d_data;
	private String c_lancto;
	private String c_docto;
	private String c_debito;
	private String c_credito;
	private Date pf_DataFim;
	private Date pf_DataIni;
	
	public Date getD_data() {
		return d_data;
	}
	public void setD_data(Date d_data) {
		this.d_data = d_data;
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
	public Integer getId() {
		return id;
	}
	public String getC_data() {
		return c_data;
	}
	public String getC_lancto() {
		return c_lancto;
	}
	public String getC_docto() {
		return c_docto;
	}
	public String getC_debito() {
		return c_debito;
	}
	public String getC_credito() {
		return c_credito;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setC_data(String c_data) {
		this.c_data = c_data;
	}
	public void setC_lancto(String c_lancto) {
		this.c_lancto = c_lancto;
	}
	public void setC_docto(String c_docto) {
		this.c_docto = c_docto;
	}
	public void setC_debito(String c_debito) {
		this.c_debito = c_debito;
	}
	public void setC_credito(String c_credito) {
		this.c_credito = c_credito;
	}
	 
	@Override
	public String toString() {
		return "ExtratoBancario [id=" + id + ", c_data=" + c_data + ", d_data="
				+ d_data + ", c_lancto=" + c_lancto + ", c_docto=" + c_docto
				+ ", c_debito=" + c_debito + ", c_credito=" + c_credito
				+ ", pf_DataFim=" + pf_DataFim + ", pf_DataIni=" + pf_DataIni
				+ "]";
	}
	
}
