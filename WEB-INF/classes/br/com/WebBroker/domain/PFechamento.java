package br.com.WebBroker.domain;

import java.util.Date;

public class PFechamento {


	private Integer id;
	private Integer lote;
	private String flag_fechado;
	private String s_ini_fecha;
	private String s_fim_fecha;
	private Date d_ini_fecha;
	private Date d_fim_fecha;
	private Boolean bflag;

	public Boolean getBflag() {
		return bflag;
	}
	public void setBflag(Boolean bflag) {
		this.bflag = bflag;
	}	
	
	public Integer getId() {
		return id;
	}
	public Integer getLote() {
		return lote;
	}
	public String getFlag_fechado() {
		return flag_fechado;
	}
	public String getS_ini_fecha() {
		return s_ini_fecha;
	}
	public String getS_fim_fecha() {
		return s_fim_fecha;
	}
	public Date getD_ini_fecha() {
		return d_ini_fecha;
	}
	public Date getD_fim_fecha() {
		return d_fim_fecha;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setLote(Integer lote) {
		this.lote = lote;
	}
	public void setFlag_fechado(String flag_fechado) {
		this.flag_fechado = flag_fechado;
	}
	public void setS_ini_fecha(String s_ini_fecha) {
		this.s_ini_fecha = s_ini_fecha;
	}
	public void setS_fim_fecha(String s_fim_fecha) {
		this.s_fim_fecha = s_fim_fecha;
	}
	public void setD_ini_fecha(Date d_ini_fecha) {
		this.d_ini_fecha = d_ini_fecha;
	}
	public void setD_fim_fecha(Date d_fim_fecha) {
		this.d_fim_fecha = d_fim_fecha;
	}
	@Override
	public String toString() {
		return "PFechamento [id=" + id + ", lote=" + lote + ", flag_fechado="
				+ flag_fechado + ", s_ini_fecha=" + s_ini_fecha
				+ ", s_fim_fecha=" + s_fim_fecha + ", d_ini_fecha="
				+ d_ini_fecha + ", d_fim_fecha=" + d_fim_fecha + ", bflag="
				+ bflag + "]";
	}

	

}
