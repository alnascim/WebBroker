package br.com.WebBroker.domain;


public class SubGrupoConta_combo {
	
	private Integer id_;
	private Integer idfk_;
	private String name_;
	private Integer idsegmento_;
	
	public Integer getId_() {
		return id_;
	}
	public void setId_(Integer id_) {
		this.id_ = id_;
	}
	public Integer getIdfk_() {
		return idfk_;
	}
	public void setIdfk_(Integer idfk_) {
		this.idfk_ = idfk_;
	}
	public String getName_() {
		return name_;
	}
	public void setName_(String name_) {
		this.name_ = name_;
	}
	public Integer getIdsegmento_() {
		return idsegmento_;
	}
	public void setIdsegmento_(Integer idsegmento_) {
		this.idsegmento_ = idsegmento_;
	}
	@Override
	public String toString() {
		return "SubGrupoConta_combo [id_=" + id_ + ", idfk_=" + idfk_
				+ ", name_=" + name_ + ", idsegmento_=" + idsegmento_ + "]";
	}

	
}
