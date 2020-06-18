package br.com.WebBroker.domain;

import java.util.Date;


public class ContasPagar {
 
	private Integer P_ID;
	private Date pf_due_date;
	private Date pf_DataFim;
	private Date pf_DataIni;
	private String fee_name;
	private String due_date;
	private String d_due_date;
	private String amount;
	private String installments;
	private Integer payer_id;
	private String payer_name;
	private Payer_combo payer_combo = new Payer_combo();

	public Date getPf_due_date() {
		return pf_due_date;
	}
	public void setPf_due_date(Date pf_due_date) {
		this.pf_due_date = pf_due_date;
	}
	
	public Integer getP_ID() {
		return P_ID;
	}
	public void setP_ID(Integer p_ID) {
		P_ID = p_ID;
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
	public String getD_due_date() {
		return d_due_date;
	}
	public void setD_due_date(String string) {
		this.d_due_date = string;
	}
	public String getPayer_name() {
		return payer_name;
	}

	public void setPayer_name(String payer_name) {
		this.payer_name = payer_name;
	}
	public Integer getPayer_id() {
		return payer_id;
	}

	public Payer_combo getPayer_combo() {
		return payer_combo;
	}

	public void setPayer_id(Integer payer_id) {
		this.payer_id = payer_id;
	}

	public void setPayer_combo(Payer_combo payer_combo) {
		this.payer_combo = payer_combo;
	}	
	
	public String getFee_name() {
		return fee_name;
	}

	public String getDue_date() {
		return due_date;
	}

	public String getAmount() {
		return amount;
	}

	public String getInstallments() {
		return installments;
	}

	public void setFee_name(String fee_name) {
		this.fee_name = fee_name;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public void setInstallments(String installments) {
		this.installments = installments;
	}
		@Override
	public String toString() {
		return "ContasPagar [P_ID=" + P_ID + ", pf_due_date=" + pf_due_date
				+ ", pf_DataFim=" + pf_DataFim + ", pf_DataIni=" + pf_DataIni
				+ ", fee_name=" + fee_name + ", due_date=" + due_date
				+ ", d_due_date=" + d_due_date + ", amount=" + amount
				+ ", installments=" + installments + ", payer_id=" + payer_id
				+ ", payer_name=" + payer_name + ", payer_combo=" + payer_combo
				+ "]";
	}
	 
}
