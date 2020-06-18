package br.com.WebBroker.domain;


public class Frequencia_combo {
	private Integer id;
	private String freq_name;
	private Integer freq_count;
	
	public Integer getId() {
		return id;
	}
	public String getFreq_name() {
		return freq_name;
	}
	public Integer getFreq_count() {
		return freq_count;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setFreq_name(String freq_name) {
		this.freq_name = freq_name;
	}
	public void setFreq_count(Integer freq_count) {
		this.freq_count = freq_count;
	}
	
	@Override
	public String toString() {
		return "Frequencia_combo [id=" + id + ", freq_name=" + freq_name
				+ ", freq_count=" + freq_count + "]";
	}
	
 
	
	
}
