package br.com.WebBroker.domain;

public class Pagencia {
	private Long id_agencia;
	private Long tb_cod_agencia;
	private String tb_nome_agencia;
	
	
	public Long getId_agencia() {
		return id_agencia;
	}
	public void setId_agencia(Long id_agencia) {
		this.id_agencia = id_agencia;
	}
	public Long getTb_cod_agencia() {
		return tb_cod_agencia;
	}
	public void setTb_cod_agencia(Long tb_cod_agencia) {
		this.tb_cod_agencia = tb_cod_agencia;
	}
	public String getTb_nome_agencia() {
		return tb_nome_agencia;
	}
	public void setTb_nome_agencia(String tb_nome_agencia) {
		this.tb_nome_agencia = tb_nome_agencia;
	}
	@Override
	public String toString() {
		return "Pagencia [id_agencia=" + id_agencia + ", tb_cod_agencia="
				+ tb_cod_agencia + ", tb_nome_agencia=" + tb_nome_agencia + "]";
	}

	
	
 
}
