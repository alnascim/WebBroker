package br.com.WebBroker.domain;

public class Parentesco {
	private Long tb_id_parent;
	private String tb_parent;
	public Long getTb_id_parent() {
		return tb_id_parent;
	}
	public void setTb_id_parent(Long tb_id_parent) {
		this.tb_id_parent = tb_id_parent;
	}
	public String getTb_parent() {
		return tb_parent;
	}
	public void setTb_parent(String tb_parent) {
		this.tb_parent = tb_parent;
	}
	@Override
	public String toString() {
		return "Parentesco [tb_id_parent=" + tb_id_parent + ", tb_parent="
				+ tb_parent + "]";
	}
	
	
 
}
