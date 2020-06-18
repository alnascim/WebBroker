package br.com.WebBroker.domain;


public class Parent {
	private Long id_parent;
	private String tb_parent;
	public Long getId_parent() {
		return id_parent;
	}
	public void setId_parent(Long id_parent) {
		this.id_parent = id_parent;
	}
	public String getTb_parent() {
		return tb_parent;
	}
	public void setTb_parent(String tb_parent) {
		this.tb_parent = tb_parent;
	}
	@Override
	public String toString() {
		return "Parent [id_parent=" + id_parent + ", tb_parent=" + tb_parent
				+ "]";
	}
	
	
}
