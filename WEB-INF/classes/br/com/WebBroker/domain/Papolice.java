package br.com.WebBroker.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Papolice {
	
	private Long RECORD_ID;
	private Long id;
	private String id_apolice;
	private Long id_segmento;
	private Long id_congenere;
	private Long id_sucursal;
	private Long tb_IDPJ;
	private Long idtb_pessoafisica;
	private Long tb_NumApolice;
	private Long id_agencia;
	private String STATE;
	private String STREET_ZIPCODE;
	private String CITY;
	private String DISTRICT;
	private String STREET_TYPE;
	private String STREET_NAME;
	private String STREET_COMP;
	private String tb_cep;
	private String tb_DataIniVig;
	private String tb_DataFimVig;
	private String tb_DataCCB;
	private String tb_DataCorretora;
	private String tb_DataSeguradora;
	private String tb_DataC1;
	private String tb_DataC2;
	private String tb_DataC3;
	private String tb_StatusApo;
	private String estipulante;
	private String tb_ano_mes_prod;
	private String segmento;
	private String nome_produtor;
	private String tb_nome_agencia;
	private String tb_sucursal;
	private String sValorPremio;
	private Date pf_DataC1;
	private Date pf_DataC2;
	private Date pf_DataC3;
	private Date pf_DataIniVig;
	private Date pf_DataFimVig;
	private Date pf_DataCCB;
	private Date pf_DataCorretora;
	private Date pf_DataSeguradora;
	private long tb_vidas;
	private BigDecimal tb_vl_premio = BigDecimal.ZERO;
	private Empresa_combo empresa_combo = new Empresa_combo();
	private Angariador_combo angariador_combo = new Angariador_combo();
	private Segmento segmento_combo = new Segmento();
	private Pagencia pagencia_combo = new Pagencia();
	private Sucursal_combo combo_sucursal = new Sucursal_combo();
	private Congenere_combo congenere_combo = new Congenere_combo();
	
	public Long getId_congenere() {
		return id_congenere;
	}

	public void setId_congenere(Long id_congenere) {
		this.id_congenere = id_congenere;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getId_apolice() {
		return id_apolice;
	}

	public void setId_apolice(String id_apolice) {
		this.id_apolice = id_apolice;
	}

	public Long getId_segmento() {
		return id_segmento;
	}

	public void setId_segmento(Long id_segmento) {
		this.id_segmento = id_segmento;
	}

	public Long getTb_IDPJ() {
		return tb_IDPJ;
	}

	public void setTb_IDPJ(Long tb_IDPJ) {
		this.tb_IDPJ = tb_IDPJ;
	}

	public Long getTb_NumApolice() {
		return tb_NumApolice;
	}

	public void setTb_NumApolice(Long tb_NumApolice) {
		this.tb_NumApolice = tb_NumApolice;
	}

	public String getTb_StatusApo() {
		return tb_StatusApo;
	}

	public void setTb_StatusApo(String tb_StatusApo) {
		this.tb_StatusApo = tb_StatusApo;
	}

	public String getTb_DataIniVig() {
		return tb_DataIniVig;
	}

	public void setTb_DataIniVig(String tb_DataIniVig) {
		this.tb_DataIniVig = tb_DataIniVig;
	}

	public String getTb_DataFimVig() {
		return tb_DataFimVig;
	}

	public void setTb_DataFimVig(String tb_DataFimVig) {
		this.tb_DataFimVig = tb_DataFimVig;
	}

	public long getTb_vidas() {
		return tb_vidas;
	}

	public void setTb_vidas(long tb_vidas) {
		this.tb_vidas = tb_vidas;
	}

	public String getTb_DataCCB() {
		return tb_DataCCB;
	}

	public void setTb_DataCCB(String tb_DataCCB) {
		this.tb_DataCCB = tb_DataCCB;
	}

	public String getTb_DataCorretora() {
		return tb_DataCorretora;
	}

	public void setTb_DataCorretora(String tb_DataCorretora) {
		this.tb_DataCorretora = tb_DataCorretora;
	}

	public String getTb_DataSeguradora() {
		return tb_DataSeguradora;
	}

	public void setTb_DataSeguradora(String tb_DataSeguradora) {
		this.tb_DataSeguradora = tb_DataSeguradora;
	}

	public BigDecimal getTb_vl_premio() {
		return tb_vl_premio;
	}

	public void setTb_vl_premio(BigDecimal tb_vl_premio) {
		this.tb_vl_premio = tb_vl_premio;
	}

	public Empresa_combo getEmpresa_combo() {
		return empresa_combo;
	}

	public void setEmpresa_combo(Empresa_combo empresa_combo) {
		this.empresa_combo = empresa_combo;
	}

	public Angariador_combo getAngariador_combo() {
		return angariador_combo;
	}

	public void setAngariador_combo(Angariador_combo angariador_combo) {
		this.angariador_combo = angariador_combo;
	}

	public Segmento getSegmento_combo() {
		return segmento_combo;
	}

	public void setSegmento_combo(Segmento segmento_combo) {
		this.segmento_combo = segmento_combo;
	}

	public Date getPf_DataIniVig() {
		return pf_DataIniVig;
	}

	public void setPf_DataIniVig(Date pf_DataIniVig) {
		this.pf_DataIniVig = pf_DataIniVig;
	}

	public Date getPf_DataFimVig() {
		return pf_DataFimVig;
	}

	public void setPf_DataFimVig(Date pf_DataFimVig) {
		this.pf_DataFimVig = pf_DataFimVig;
	}

	public Date getPf_DataCCB() {
		return pf_DataCCB;
	}

	public void setPf_DataCCB(Date pf_DataCCB) {
		this.pf_DataCCB = pf_DataCCB;
	}

	public Date getPf_DataCorretora() {
		return pf_DataCorretora;
	}

	public void setPf_DataCorretora(Date pf_DataCorretora) {
		this.pf_DataCorretora = pf_DataCorretora;
	}

	public Date getPf_DataSeguradora() {
		return pf_DataSeguradora;
	}

	public void setPf_DataSeguradora(Date pf_DataSeguradora) {
		this.pf_DataSeguradora = pf_DataSeguradora;
	}

	public String getTb_cep() {
		return tb_cep;
	}

	public void setTb_cep(String tb_cep) {
		this.tb_cep = tb_cep;
	}

	public Long getRECORD_ID() {
		return RECORD_ID;
	}

	public void setRECORD_ID(Long rECORD_ID) {
		RECORD_ID = rECORD_ID;
	}

	public String getSTATE() {
		return STATE;
	}

	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}

	public String getSTREET_ZIPCODE() {
		return STREET_ZIPCODE;
	}

	public void setSTREET_ZIPCODE(String sTREET_ZIPCODE) {
		STREET_ZIPCODE = sTREET_ZIPCODE;
	}

	public String getCITY() {
		return CITY;
	}

	public void setCITY(String cITY) {
		CITY = cITY;
	}

	public String getDISTRICT() {
		return DISTRICT;
	}

	public void setDISTRICT(String dISTRICT) {
		DISTRICT = dISTRICT;
	}

	public String getSTREET_TYPE() {
		return STREET_TYPE;
	}

	public void setSTREET_TYPE(String sTREET_TYPE) {
		STREET_TYPE = sTREET_TYPE;
	}

	public String getSTREET_NAME() {
		return STREET_NAME;
	}

	public void setSTREET_NAME(String sTREET_NAME) {
		STREET_NAME = sTREET_NAME;
	}

	public String getSTREET_COMP() {
		return STREET_COMP;
	}

	public void setSTREET_COMP(String sTREET_COMP) {
		STREET_COMP = sTREET_COMP;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getTb_ano_mes_prod() {
		return tb_ano_mes_prod;
	}

	public void setTb_ano_mes_prod(String tb_ano_mes_prod) {
		this.tb_ano_mes_prod = tb_ano_mes_prod;
	}

	public String getTb_nome_agencia() {
		return tb_nome_agencia;
	}

	public void setTb_nome_agencia(String tb_nome_agencia) {
		this.tb_nome_agencia = tb_nome_agencia;
	}

	public String getNome_produtor() {
		return nome_produtor;
	}

	public void setNome_produtor(String nome_produtor) {
		this.nome_produtor = nome_produtor;
	}

	public String getEstipulante() {
		return estipulante;
	}

	public void setEstipulante(String estipulante) {
		this.estipulante = estipulante;
	}

	public Date getPf_DataC1() {
		return pf_DataC1;
	}

	public void setPf_DataC1(Date pf_DataC1) {
		this.pf_DataC1 = pf_DataC1;
	}

	public Date getPf_DataC2() {
		return pf_DataC2;
	}

	public void setPf_DataC2(Date pf_DataC2) {
		this.pf_DataC2 = pf_DataC2;
	}

	public Date getPf_DataC3() {
		return pf_DataC3;
	}

	public void setPf_DataC3(Date pf_DataC3) {
		this.pf_DataC3 = pf_DataC3;
	}

	public String getTb_DataC1() {
		return tb_DataC1;
	}

	public void setTb_DataC1(String tb_DataC1) {
		this.tb_DataC1 = tb_DataC1;
	}

	public String getTb_DataC2() {
		return tb_DataC2;
	}

	public void setTb_DataC2(String tb_DataC2) {
		this.tb_DataC2 = tb_DataC2;
	}

	public String getTb_DataC3() {
		return tb_DataC3;
	}

	public void setTb_DataC3(String tb_DataC3) {
		this.tb_DataC3 = tb_DataC3;
	}

	public Pagencia getPagencia_combo() {
		return pagencia_combo;
	}

	public void setPagencia_combo(Pagencia pagencia_combo) {
		this.pagencia_combo = pagencia_combo;
	}

	public String getTb_sucursal() {
		return tb_sucursal;
	}

	public void setTb_sucursal(String tb_sucursal) {
		this.tb_sucursal = tb_sucursal;
	}

	public Sucursal_combo getCombo_sucursal() {
		return combo_sucursal;
	}

	public void setCombo_sucursal(Sucursal_combo combo_sucursal) {
		this.combo_sucursal = combo_sucursal;
	}

	public Long getIdtb_pessoafisica() {
		return idtb_pessoafisica;
	}

	public void setIdtb_pessoafisica(Long idtb_pessoafisica) {
		this.idtb_pessoafisica = idtb_pessoafisica;
	}

	public Long getId_sucursal() {
		return id_sucursal;
	}

	public void setId_sucursal(Long id_sucursal) {
		this.id_sucursal = id_sucursal;
	}

	public Long getId_agencia() {
		return id_agencia;
	}

	public void setId_agencia(Long id_agencia) {
		this.id_agencia = id_agencia;
	}

	public String getsValorPremio() {
		return sValorPremio;
	}

	public void setsValorPremio(String sValorPremio) {
		this.sValorPremio = sValorPremio;
	}

	public Congenere_combo getCongenere_combo() {
		return congenere_combo;
	}

	public void setCongenere_combo(Congenere_combo congenere_combo) {
		this.congenere_combo = congenere_combo;
	}

	@Override
	public String toString() {
		return "Papolice [RECORD_ID=" + RECORD_ID + ", id=" + id
				+ ", id_apolice=" + id_apolice + ", id_segmento=" + id_segmento
				+ ", id_congenere=" + id_congenere + ", id_sucursal="
				+ id_sucursal + ", tb_IDPJ=" + tb_IDPJ + ", idtb_pessoafisica="
				+ idtb_pessoafisica + ", tb_NumApolice=" + tb_NumApolice
				+ ", id_agencia=" + id_agencia + ", STATE=" + STATE
				+ ", STREET_ZIPCODE=" + STREET_ZIPCODE + ", CITY=" + CITY
				+ ", DISTRICT=" + DISTRICT + ", STREET_TYPE=" + STREET_TYPE
				+ ", STREET_NAME=" + STREET_NAME + ", STREET_COMP="
				+ STREET_COMP + ", tb_cep=" + tb_cep + ", tb_DataIniVig="
				+ tb_DataIniVig + ", tb_DataFimVig=" + tb_DataFimVig
				+ ", tb_DataCCB=" + tb_DataCCB + ", tb_DataCorretora="
				+ tb_DataCorretora + ", tb_DataSeguradora=" + tb_DataSeguradora
				+ ", tb_DataC1=" + tb_DataC1 + ", tb_DataC2=" + tb_DataC2
				+ ", tb_DataC3=" + tb_DataC3 + ", tb_StatusApo=" + tb_StatusApo
				+ ", estipulante=" + estipulante + ", tb_ano_mes_prod="
				+ tb_ano_mes_prod + ", segmento=" + segmento
				+ ", nome_produtor=" + nome_produtor + ", tb_nome_agencia="
				+ tb_nome_agencia + ", tb_sucursal=" + tb_sucursal
				+ ", sValorPremio=" + sValorPremio + ", pf_DataC1=" + pf_DataC1
				+ ", pf_DataC2=" + pf_DataC2 + ", pf_DataC3=" + pf_DataC3
				+ ", pf_DataIniVig=" + pf_DataIniVig + ", pf_DataFimVig="
				+ pf_DataFimVig + ", pf_DataCCB=" + pf_DataCCB
				+ ", pf_DataCorretora=" + pf_DataCorretora
				+ ", pf_DataSeguradora=" + pf_DataSeguradora + ", tb_vidas="
				+ tb_vidas + ", tb_vl_premio=" + tb_vl_premio
				+ ", empresa_combo=" + empresa_combo + ", angariador_combo="
				+ angariador_combo + ", segmento_combo=" + segmento_combo
				+ ", pagencia_combo=" + pagencia_combo + ", combo_sucursal="
				+ combo_sucursal + ", congenere_combo=" + congenere_combo + "]";
	}
}
