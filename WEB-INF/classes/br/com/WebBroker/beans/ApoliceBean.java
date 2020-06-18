package br.com.WebBroker.beans;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.IndexedColors;

import br.com.WebBroker.dao.AngariadorcomboDAO;
import br.com.WebBroker.dao.CongenerecomboDAO;
import br.com.WebBroker.dao.EmpresacomboDAO;
import br.com.WebBroker.dao.EstadocivilDAO;
import br.com.WebBroker.dao.PBeneficioDAO;
import br.com.WebBroker.dao.PagenciaDAO;
import br.com.WebBroker.dao.PapoliceDAO;
import br.com.WebBroker.dao.ProfissaoDAO;
import br.com.WebBroker.dao.SegmentoDAO;
import br.com.WebBroker.dao.SucursalcomboDAO;
import br.com.WebBroker.domain.Angariador_combo;
import br.com.WebBroker.domain.Congenere_combo;
import br.com.WebBroker.domain.ContasPagar;
import br.com.WebBroker.domain.Empresa_combo;
import br.com.WebBroker.domain.Estadocivil;
import br.com.WebBroker.domain.Pagencia;
import br.com.WebBroker.domain.Papolice;
import br.com.WebBroker.domain.Pdepend;
import br.com.WebBroker.domain.Profissao;
import br.com.WebBroker.domain.Segmento;
import br.com.WebBroker.domain.Sucursal_combo;
import br.com.WebBroker.domain.Tipopessoafisica;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBApolice")
@ViewScoped
public class ApoliceBean {

	private ArrayList<Papolice> itens;
	private ArrayList<Papolice> itensfiltrados;

	private Papolice Apolice;

	private ArrayList<Pdepend> itensdepend;
	private ArrayList<Papolice> itenspordata;
	private Tipopessoafisica tipopessoafisica;
	private ArrayList<Tipopessoafisica> combotipos;
	private ArrayList<Angariador_combo> comboAngariador;
	private ArrayList<Segmento> comboSegmento;
	private ArrayList<Profissao> comboProfissao;
	private ArrayList<Estadocivil> comboEstadocivils;
	private ArrayList<Empresa_combo> comboEmpresa;
	private ArrayList<Pagencia> comboAgencia;
	private ArrayList<Sucursal_combo> comboSucursal;
	private ArrayList<Congenere_combo> comboCongenere;

	public String sBeginDate;
	public String sEndDate;
	private Double valor;

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public ArrayList<Pagencia> getComboAgencia() {
		return comboAgencia;
	}

	public void setComboAgencia(ArrayList<Pagencia> comboAgencia) {
		this.comboAgencia = comboAgencia;
	}

	public ArrayList<Sucursal_combo> getComboSucursal() {
		return comboSucursal;
	}

	public void setComboSucursal(ArrayList<Sucursal_combo> comboSucursal) {
		this.comboSucursal = comboSucursal;
	}

	public ArrayList<Angariador_combo> getComboAngariador() {
		return comboAngariador;
	}

	public void setComboAngariador(ArrayList<Angariador_combo> comboAngariador) {
		this.comboAngariador = comboAngariador;
	}

	public ArrayList<Papolice> getItenspordata() {
		return itenspordata;
	}

	public void setItenspordata(ArrayList<Papolice> itenspordata) {
		this.itenspordata = itenspordata;
	}

	public String getsBeginDate() {
		return sBeginDate;
	}

	public void setsBeginDate(String sBeginDate) {
		this.sBeginDate = sBeginDate;
	}

	public String getsEndDate() {
		return sEndDate;
	}

	public void setsEndDate(String sEndDate) {
		this.sEndDate = sEndDate;
	}

	public Papolice getApolice() {
		return Apolice;
	}

	public void setApolice(Papolice Apolice) {
		this.Apolice = Apolice;
	}

	public Papolice getPapolice() {
		return Apolice;
	}

	public void setPapolice(Papolice Apolice) {

		this.Apolice = Apolice;
	}

	public ArrayList<Papolice> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Papolice> itens) {
		this.itens = itens;
	}

	public ArrayList<Papolice> getItensfiltrados() {
		return itensfiltrados;
	}

	public void setItensfiltrados(ArrayList<Papolice> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}

	public ArrayList<Congenere_combo> getComboCongenere() {
		return comboCongenere;
	}

	public void setComboCongenere(ArrayList<Congenere_combo> comboCongenere) {
		this.comboCongenere = comboCongenere;
	}

	public ArrayList<Empresa_combo> getComboEmpresa() {
		return comboEmpresa;
	}

	public void setComboEmpresa(ArrayList<Empresa_combo> comboEmpresa) {
		this.comboEmpresa = comboEmpresa;
	}

	public ArrayList<Segmento> getComboSegmento() {
		return comboSegmento;
	}

	public void setComboSegmento(ArrayList<Segmento> comboSegmento) {
		this.comboSegmento = comboSegmento;
	}

	public ArrayList<Profissao> getComboProfissao() {
		return comboProfissao;
	}

	public void setComboProfissao(ArrayList<Profissao> comboProfissao) {
		this.comboProfissao = comboProfissao;
	}

	public ArrayList<Estadocivil> getComboEstadocivils() {
		return comboEstadocivils;
	}

	public void setComboEstadocivil(ArrayList<Estadocivil> comboEstadocivils) {
		this.comboEstadocivils = comboEstadocivils;
	}

	public Tipopessoafisica getTipopessoafisica() {
		return tipopessoafisica;
	}

	public void setTipopessoafisica(Tipopessoafisica tipopessoafisica) {
		this.tipopessoafisica = tipopessoafisica;
	}

	public ArrayList<Tipopessoafisica> getCombotipos() {
		return combotipos;
	}

	public void setCombotipos(ArrayList<Tipopessoafisica> combotipos) {
		this.combotipos = combotipos;
	}

	public ArrayList<Pdepend> getItensdepend() {
		return itensdepend;
	}

	public void setItensdepend(ArrayList<Pdepend> itensdepend) {
		this.itensdepend = itensdepend;
	}

	@PostConstruct
	public void prepararPesquisa() {
		Apolice = new Papolice();

		try {
			PapoliceDAO dao = new PapoliceDAO();
			itens = dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - " + ex.getMessage());
		}
	}

	public String getData() {

		return new SimpleDateFormat("MM-yyyy").format(new Date());
	}

	public void localizar() {

		PapoliceDAO dao = new PapoliceDAO();

		try {
			dao.localizar(Apolice);
		} catch (SQLException e) {

			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void prepararNovo() {
		Apolice = new Papolice();

		EmpresacomboDAO dao = new EmpresacomboDAO();
		ProfissaoDAO dao2 = new ProfissaoDAO();
		EstadocivilDAO dao3 = new EstadocivilDAO();
		AngariadorcomboDAO dao4 = new AngariadorcomboDAO();
		PagenciaDAO age = new PagenciaDAO();
		SucursalcomboDAO dao6 = new SucursalcomboDAO();
		CongenerecomboDAO dao7 = new CongenerecomboDAO();
		SegmentoDAO dao1 = new SegmentoDAO();
		try {
			comboAngariador = dao4.listar();
			comboEmpresa = dao.listar();
			comboProfissao = dao2.listar();
			comboEstadocivils = dao3.listar();
			comboAgencia = age.listar();
			comboSucursal = dao6.listar();
			comboCongenere = dao7.listar();
			comboSegmento=dao1.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}

	public void getprodfromcia() {

		PapoliceDAO dao = new PapoliceDAO();

		try {
			comboSegmento = dao.getprodfromcia(Apolice);
		} catch (SQLException e) {

			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void prepararEditar() {
		Apolice = new Papolice();
		EmpresacomboDAO dao = new EmpresacomboDAO();
//		PapoliceDAO dao1 = new PapoliceDAO();
		ProfissaoDAO dao2 = new ProfissaoDAO();
		EstadocivilDAO dao3 = new EstadocivilDAO();
		AngariadorcomboDAO dao4 = new AngariadorcomboDAO();
		SegmentoDAO dao5 = new SegmentoDAO();
		PagenciaDAO age = new PagenciaDAO();
		SucursalcomboDAO dao6 = new SucursalcomboDAO();
		CongenerecomboDAO dao7 = new CongenerecomboDAO();
		
		try {
			comboAngariador = dao4.listar();
			comboEmpresa = dao.listar();
			comboProfissao = dao2.listar();
			comboEstadocivils = dao3.listar();
			comboAgencia = age.listar();
			comboSucursal = dao6.listar();
			comboCongenere = dao7.listar();
//			comboSegmento = dao1.getprodfromciaEdit(Apolice);			
			comboSegmento = dao5.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}

	public void novo() {

		try {
			PapoliceDAO dao = new PapoliceDAO();
			EmpresacomboDAO edao = new EmpresacomboDAO();
			SegmentoDAO dao1 = new SegmentoDAO();
			ProfissaoDAO dao2 = new ProfissaoDAO();
			EstadocivilDAO dao3 = new EstadocivilDAO();
			AngariadorcomboDAO dao4 = new AngariadorcomboDAO();
			PagenciaDAO age = new PagenciaDAO();
			SucursalcomboDAO dao6 = new SucursalcomboDAO();
			CongenerecomboDAO dao7 = new CongenerecomboDAO();
			dao.salvar(Apolice);
			itens = dao.listar();
			comboEmpresa = edao.listar();
			comboSegmento = dao1.listar();
			comboProfissao = dao2.listar();
			comboEstadocivils = dao3.listar();
			comboAngariador = dao4.listar();
			comboAgencia = age.listar();
			comboSucursal = dao6.listar();
			comboCongenere = dao7.listar();
			JSFUtil.adicionarMensagemSucesso("Registro Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  002 - " + ex.getMessage());
		}

	}

	public void excluir() {

		try {
			PapoliceDAO dao = new PapoliceDAO();
			EmpresacomboDAO edao = new EmpresacomboDAO();
			PagenciaDAO age = new PagenciaDAO();
			SegmentoDAO dao1 = new SegmentoDAO();
			ProfissaoDAO dao2 = new ProfissaoDAO();
			EstadocivilDAO dao3 = new EstadocivilDAO();
			AngariadorcomboDAO dao4 = new AngariadorcomboDAO();
			SucursalcomboDAO dao6 = new SucursalcomboDAO();
			CongenerecomboDAO dao7 = new CongenerecomboDAO();

			dao.excluir(Apolice);
			itens = dao.listar();
			comboEmpresa = edao.listar();
			comboSegmento = dao1.listar();
			comboProfissao = dao2.listar();
			comboEstadocivils = dao3.listar();
			comboAngariador = dao4.listar();
			comboAgencia = age.listar();
			comboSucursal = dao6.listar();
			comboCongenere = dao7.listar();
			JSFUtil.adicionarMensagemSucesso("Registro Removido com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
		}

	}

	public void editar() {

		try {
			EmpresacomboDAO edao = new EmpresacomboDAO();
			SegmentoDAO dao1 = new SegmentoDAO();
			ProfissaoDAO dao2 = new ProfissaoDAO();
			EstadocivilDAO dao3 = new EstadocivilDAO();
			AngariadorcomboDAO dao4 = new AngariadorcomboDAO();
			PagenciaDAO age = new PagenciaDAO();
			PapoliceDAO dao = new PapoliceDAO();
			SucursalcomboDAO dao6 = new SucursalcomboDAO();
			CongenerecomboDAO dao7 = new CongenerecomboDAO();
			dao.editar(Apolice);
			itens = dao.listar();
			comboEmpresa = edao.listar();
			comboSegmento = dao1.listar();
			comboProfissao = dao2.listar();
			comboEstadocivils = dao3.listar();
			comboAngariador = dao4.listar();
			comboAgencia = age.listar();
			comboSucursal = dao6.listar();
			comboCongenere = dao7.listar();
			JSFUtil.adicionarMensagemSucesso("Registro Alterado com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
		}
	}

	public void prepararListar() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		sBeginDate = request.getParameter("txtBeginDate");
		sEndDate = request.getParameter("txtEndDate");
		sBeginDate = sBeginDate.replace("/", "");
		String sAno = sBeginDate.substring(4, 8);
		String sMes = sBeginDate.substring(2, 4);
		String sDia = sBeginDate.substring(0, 2);
		sBeginDate = sAno + sMes + sDia;

		sEndDate = sEndDate.replace("/", "");
		sAno = sEndDate.substring(4, 8);
		sMes = sEndDate.substring(2, 4);
		sDia = sEndDate.substring(0, 2);
		sEndDate = sAno + sMes + sDia;

		PapoliceDAO dao4 = new PapoliceDAO();

		try {

			itenspordata = dao4.listarData(sBeginDate, sEndDate);
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}

	public void postProcessXLS(Object document) {

		HSSFWorkbook wb = (HSSFWorkbook) document;
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow header = sheet.getRow(0);

		HSSFCellStyle cellStyle = wb.createCellStyle();
		HSSFDataFormat hssfDataFormat = wb.createDataFormat();
		cellStyle.setDataFormat(hssfDataFormat.getFormat("#,##0,00"));

		HSSFFont fonteCabecalho = wb.createFont();

		fonteCabecalho.setColor(IndexedColors.WHITE.getIndex());
		fonteCabecalho.setFontHeightInPoints((short) 16);

		cellStyle.setFont(fonteCabecalho);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);

		cellStyle.setBorderBottom((short) 1);
		cellStyle.setBorderLeft((short) 1);
		cellStyle.setBorderRight((short) 1);
		cellStyle.setBorderTop((short) 1);

		System.out.println(header.getPhysicalNumberOfCells());

		for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
			HSSFCell cell = header.getCell(i);

			cell.setCellStyle(cellStyle);
		}

	}

}
