package br.com.WebBroker.domain;

import java.math.BigDecimal;
import java.util.Date;

public class T_grp_account {

	
	private Integer id;
	private Integer fee_id ;
	private Integer installments ;
	private String fee_name;
	private String event_code;
	private String nickname;
	private Integer fee_type;
	private Integer automatic_flag;
	private Integer segment_id;
	private String due_date;
	private Date ddue_date;
	private Integer frequence_id;
	private String amount;
	private String sautomatic_flag;
	private String sfrequence;
	private BigDecimal big_amount = BigDecimal.ZERO;
	private Frequencia_combo frequence_combo = new Frequencia_combo();	
	private Integer payer_id;
	private String payer_name;
	private Payer_combo payer_combo = new Payer_combo();
	private GrupoConta_combo grupoconta_combo = new GrupoConta_combo();
	private SubGrupoConta_combo subgrupoconta_combo = new SubGrupoConta_combo();
	private AutomaticFlag_combo automatic_flag_combo = new AutomaticFlag_combo();
	private EmpresasLemara_combo empresasgrupo = new EmpresasLemara_combo();
	
	public EmpresasLemara_combo getEmpresasgrupo() {
		return empresasgrupo;
	}
	public void setEmpresasgrupo(EmpresasLemara_combo empresasgrupo) {
		this.empresasgrupo = empresasgrupo;
	}
	public SubGrupoConta_combo getSubgrupoconta_combo() {
		return subgrupoconta_combo;
	}
	public void setSubgrupoconta_combo(SubGrupoConta_combo subgrupoconta_combo) {
		this.subgrupoconta_combo = subgrupoconta_combo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFee_id() {
		return fee_id;
	}
	public void setFee_id(Integer fee_id) {
		this.fee_id = fee_id;
	}
	public Integer getInstallments() {
		return installments;
	}
	public void setInstallments(Integer installments) {
		this.installments = installments;
	}
	public String getFee_name() {
		return fee_name;
	}
	public void setFee_name(String fee_name) {
		this.fee_name = fee_name;
	}
	public String getEvent_code() {
		return event_code;
	}
	public void setEvent_code(String event_code) {
		this.event_code = event_code;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getFee_type() {
		return fee_type;
	}
	public void setFee_type(Integer fee_type) {
		this.fee_type = fee_type;
	}
	public Integer getAutomatic_flag() {
		return automatic_flag;
	}
	public void setAutomatic_flag(Integer automatic_flag) {
		this.automatic_flag = automatic_flag;
	}
	public Integer getSegment_id() {
		return segment_id;
	}
	public void setSegment_id(Integer segment_id) {
		this.segment_id = segment_id;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public Date getDdue_date() {
		return ddue_date;
	}
	public void setDdue_date(Date ddue_date) {
		this.ddue_date = ddue_date;
	}
	public Integer getFrequence_id() {
		return frequence_id;
	}
	public void setFrequence_id(Integer frequence_id) {
		this.frequence_id = frequence_id;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getSautomatic_flag() {
		return sautomatic_flag;
	}
	public void setSautomatic_flag(String sautomatic_flag) {
		this.sautomatic_flag = sautomatic_flag;
	}
	public String getSfrequence() {
		return sfrequence;
	}
	public void setSfrequence(String sfrequence) {
		this.sfrequence = sfrequence;
	}
	public BigDecimal getBig_amount() {
		return big_amount;
	}
	public void setBig_amount(BigDecimal big_amount) {
		this.big_amount = big_amount;
	}
	public Frequencia_combo getFrequence_combo() {
		return frequence_combo;
	}
	public void setFrequence_combo(Frequencia_combo frequence_combo) {
		this.frequence_combo = frequence_combo;
	}
	public AutomaticFlag_combo getAutomatic_flag_combo() {
		return automatic_flag_combo;
	}
	public void setAutomatic_flag_combo(AutomaticFlag_combo automatic_flag_combo) {
		this.automatic_flag_combo = automatic_flag_combo;
	}
	public Integer getPayer_id() {
		return payer_id;
	}
	public void setPayer_id(Integer payer_id) {
		this.payer_id = payer_id;
	}
	public String getPayer_name() {
		return payer_name;
	}
	public void setPayer_name(String payer_name) {
		this.payer_name = payer_name;
	}
	public Payer_combo getPayer_combo() {
		return payer_combo;
	}
	public void setPayer_combo(Payer_combo payer_combo) {
		this.payer_combo = payer_combo;
	}
	public GrupoConta_combo getGrupoconta_combo() {
		return grupoconta_combo;
	}
	public void setGrupoconta_combo(GrupoConta_combo grupoconta_combo) {
		this.grupoconta_combo = grupoconta_combo;
	}
	@Override
	public String toString() {
		return "T_grp_account [id=" + id + ", fee_id=" + fee_id
				+ ", installments=" + installments + ", fee_name=" + fee_name
				+ ", event_code=" + event_code + ", nickname=" + nickname
				+ ", fee_type=" + fee_type + ", automatic_flag="
				+ automatic_flag + ", segment_id=" + segment_id + ", due_date="
				+ due_date + ", ddue_date=" + ddue_date + ", frequence_id="
				+ frequence_id + ", amount=" + amount + ", sautomatic_flag="
				+ sautomatic_flag + ", sfrequence=" + sfrequence
				+ ", big_amount=" + big_amount + ", frequence_combo="
				+ frequence_combo + ", payer_id=" + payer_id + ", payer_name="
				+ payer_name + ", payer_combo=" + payer_combo
				+ ", grupoconta_combo=" + grupoconta_combo
				+ ", subgrupoconta_combo=" + subgrupoconta_combo
				+ ", automatic_flag_combo=" + automatic_flag_combo
				+ ", empresasgrupo=" + empresasgrupo + "]";
	}
	 


}
