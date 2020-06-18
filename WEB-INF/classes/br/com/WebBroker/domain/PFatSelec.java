package br.com.WebBroker.domain;

import java.util.Date;

public class PFatSelec {
	private String dtinifat;
	private String dtfimfat;
	private Date pf_dtinifat;
	private Date pf_dtfimfat;
	
	public String getDtinifat() {
		return dtinifat;
	}
	public void setDtinifat(String dtinifat) {
		this.dtinifat = dtinifat;
	}
	public String getDtfimfat() {
		return dtfimfat;
	}
	public void setDtfimfat(String dtfimfat) {
		this.dtfimfat = dtfimfat;
	}
	public Date getPf_dtinifat() {
		return pf_dtinifat;
	}
	public void setPf_dtinifat(Date pf_dtinifat) {
		this.pf_dtinifat = pf_dtinifat;
	}
	public Date getPf_dtfimfat() {
		return pf_dtfimfat;
	}
	public void setPf_dtfimfat(Date pf_dtfimfat) {
		this.pf_dtfimfat = pf_dtfimfat;
	}
	@Override
	public String toString() {
		return "FatSelec [dtinifat=" + dtinifat + ", dtfimfat=" + dtfimfat
				+ ", pf_dtinifat=" + pf_dtinifat + ", pf_dtfimfat="
				+ pf_dtfimfat + "]";
	}
	

	
	
	
}
