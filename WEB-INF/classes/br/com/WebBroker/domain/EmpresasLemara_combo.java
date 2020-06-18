package br.com.WebBroker.domain;


public class EmpresasLemara_combo {
	private Long idtb_pessoafisica;
	private String tb_pf_nome;
	
	public Long getIdtb_pessoafisica() {
		return idtb_pessoafisica;	
	}
	public void setIdtb_pessoafisica(Long idtb_pessoafisica) {
		this.idtb_pessoafisica = idtb_pessoafisica;
	}
	public String getTb_pf_nome() {
		return tb_pf_nome;
	}
	public void setTb_pf_nome(String tb_pf_nome) {
		this.tb_pf_nome = tb_pf_nome;
	}
	@Override
	public String toString() {
		return "EmpresasLemara_combo [idtb_pessoafisica=" + idtb_pessoafisica
				+ ", tb_pf_nome=" + tb_pf_nome + "]";
	}

	
	
}
