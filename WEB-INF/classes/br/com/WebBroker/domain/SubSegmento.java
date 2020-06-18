package br.com.WebBroker.domain;


public class SubSegmento {
	private Long idsub;
	private String tb_subsegmento;
	private Segmento segmento;
	
	
	public Long getIdsub() {
		return idsub;
	}
	public void setIdsub(Long idsub) {
		this.idsub = idsub;
	}
	public String getTb_subsegmento() {
		return tb_subsegmento;
	}
	public void setTb_subsegmento(String tb_subsegmento) {
		this.tb_subsegmento = tb_subsegmento;
	}
	public Segmento getSegmento() {
		return segmento;
	}
	public void setSegmento(Segmento segmento) {
		this.segmento = segmento;
	}
	@Override
	public String toString() {
		return "SubSegmento [idsub=" + idsub + ", tb_subsegmento="
				+ tb_subsegmento + ", segmento=" + segmento + "]";
	}	

	
}
