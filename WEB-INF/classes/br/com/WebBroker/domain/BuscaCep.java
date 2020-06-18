package br.com.WebBroker.domain;

public class BuscaCep {

	private Long RECORD_ID;
	private String STATE;
	private String STREET_ZIPCODE;
	private String CITY;
	private String DISTRICT;
	private String STREET_TYPE;
	private String STREET_NAME;
	private String STREET_COMP;
	
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
	public void setSTREET_ZIPCODE(String sTATE_ZIPCODE) {
		STREET_ZIPCODE = sTATE_ZIPCODE;
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
	@Override
	public String toString() {
		return "BuscaCep [RECORD_ID=" + RECORD_ID + ", STATE=" + STATE
				+ ", STREET_ZIPCODE=" + STREET_ZIPCODE + ", CITY=" + CITY
				+ ", DISTRICT=" + DISTRICT + ", STREET_TYPE=" + STREET_TYPE
				+ ", STREET_NAME=" + STREET_NAME + ", STREET_COMP="
				+ STREET_COMP + "]";
	}



}
