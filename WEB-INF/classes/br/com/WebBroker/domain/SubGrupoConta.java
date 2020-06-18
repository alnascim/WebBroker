package br.com.WebBroker.domain;



public class SubGrupoConta {

	
	private Integer id_sq;
	private Integer id_sq_fk;
	private String name;	
	private String namesub;	
	private Integer ib_subsegmento;
	private String subsegmento;
	private GrupoConta grupoconta_combo = new GrupoConta ();
	private Produto subsegmento_combo = new Produto();
	
	public Produto getSubsegmento_combo() {
		return subsegmento_combo;
	}
	public void setSubsegmento_combo(Produto subsegmento_combo) {
		this.subsegmento_combo = subsegmento_combo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubsegmento() {
		return subsegmento;
	}
	public void setSubsegmento(String subsegmento) {
		this.subsegmento = subsegmento;
	}
	public Integer getId_sq() {
		return id_sq;
	}
	public void setId_sq(Integer id_sq) {
		this.id_sq = id_sq;
	}
	public Integer getId_sq_fk() {
		return id_sq_fk;
	}
	public void setId_sq_fk(Integer id_sq_fk) {
		this.id_sq_fk = id_sq_fk;
	}
	public String getNamesub() {
		return namesub;
	}
	public void setNamesub(String namesub) {
		this.namesub = namesub;
	}
	public Integer getIb_subsegmento() {
		return ib_subsegmento;
	}
	public void setIb_subsegmento(Integer ib_subsegmento) {
		this.ib_subsegmento = ib_subsegmento;
	}
	public GrupoConta getGrupoconta_combo() {
		return grupoconta_combo;
	}
	public void setGrupoconta_combo(GrupoConta grupoconta_combo) {
		this.grupoconta_combo = grupoconta_combo;
	}
	@Override
	public String toString() {
		return "SubGrupoConta [id_sq=" + id_sq + ", id_sq_fk=" + id_sq_fk
				+ ", name=" + name + ", namesub=" + namesub
				+ ", ib_subsegmento=" + ib_subsegmento + ", subsegmento="
				+ subsegmento + ", grupoconta_combo=" + grupoconta_combo
				+ ", subsegmento_combo=" + subsegmento_combo + "]";
	}
}
