package br.com.WebBroker.domain;

public class Pagadores {
	
	
	private Integer id; 
	private String account_name; 
	private String t_agenc; 
	private String t_account_number; 
	private String t_account_digit; 
	private Integer id_bank;
	private String bank; 
	private BancoCombo banco_combo = new BancoCombo();	
	
	public Integer getId() {
		return id;
	}
	public String getAccount_name() {
		return account_name;
	}
	public String getT_agenc() {
		return t_agenc;
	}
	public String getT_account_number() {
		return t_account_number;
	}
	public String getT_account_digit() {
		return t_account_digit;
	}
	public Integer getId_bank() {
		return id_bank;
	}
	public String getBank() {
		return bank;
	}
	public BancoCombo getBanco_combo() {
		return banco_combo;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public void setT_agenc(String t_agenc) {
		this.t_agenc = t_agenc;
	}
	public void setT_account_number(String t_account_number) {
		this.t_account_number = t_account_number;
	}
	public void setT_account_digit(String t_account_digit) {
		this.t_account_digit = t_account_digit;
	}
	public void setId_bank(Integer id_bank) {
		this.id_bank = id_bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public void setBanco_combo(BancoCombo banco_combo) {
		this.banco_combo = banco_combo;
	}
	@Override
	public String toString() {
		return "Pagadores [id=" + id + ", account_name=" + account_name
				+ ", t_agenc=" + t_agenc + ", t_account_number="
				+ t_account_number + ", t_account_digit=" + t_account_digit
				+ ", id_bank=" + id_bank + ", bank=" + bank + ", banco_combo="
				+ banco_combo + "]";
	}
}
