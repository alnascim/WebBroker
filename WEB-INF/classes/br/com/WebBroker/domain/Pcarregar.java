package br.com.WebBroker.domain;

import java.util.Date;

public class Pcarregar {

	private Long id;
	private long nco_cia;
	private String nomearq;
	private String databas;
	private String dataimport;
	private Date d_databas;
	private Date d_dataimport;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomearq() {
		return nomearq;
	}
	public void setNomearq(String nomearq) {
		this.nomearq = nomearq;
	}
	public String getDatabas() {
		return databas;
	}
	public void setDatabas(String databas) {
		this.databas = databas;
	}
	public String getDataimport() {
		return dataimport;
	}
	public void setDataimport(String dataimport) {
		this.dataimport = dataimport;
	}
	public Date getD_databas() {
		return d_databas;
	}
	public void setD_databas(Date d_databas) {
		this.d_databas = d_databas;
	}
	public Date getD_dataimport() {
		return d_dataimport;
	}
	public void setD_dataimport(Date d_dataimport) {
		this.d_dataimport = d_dataimport;
	}
	public long getNco_cia() {
		return nco_cia;
	}
	public void setNco_cia(long nco_cia) {
		this.nco_cia = nco_cia;
	}
	@Override
	public String toString() {
		return "Pcarregar [id=" + id + ", nco_cia=" + nco_cia + ", nomearq="
				+ nomearq + ", databas=" + databas + ", dataimport="
				+ dataimport + ", d_databas=" + d_databas + ", d_dataimport="
				+ d_dataimport + "]";
	}
	
	


}
