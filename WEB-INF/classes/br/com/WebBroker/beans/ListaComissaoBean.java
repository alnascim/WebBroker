package br.com.WebBroker.beans;

import java.sql.SQLException;
import java.util.ArrayList;

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
import br.com.WebBroker.dao.ListaComissaoDAO;
import br.com.WebBroker.domain.Angariador_combo;
import br.com.WebBroker.domain.ListaComissao;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBListaComissao")
@ViewScoped
public class ListaComissaoBean {

	private ListaComissao listaComissao;
	private ArrayList<ListaComissao> itens;
	private ArrayList<ListaComissao> itensfiltrados;
	private ArrayList<ListaComissao> resumoComissao;
	private ArrayList<ListaComissao> itenspordata;
	private ArrayList<Angariador_combo> comboAngariador;
	public String sBeginDate;
	public String sEndDate;
	public String sAngariador;

	public ArrayList<Angariador_combo> getComboAngariador() {
		return comboAngariador;
	}

	public void setComboAngariador(ArrayList<Angariador_combo> comboAngariador) {
		this.comboAngariador = comboAngariador;
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

	public ListaComissao getListaComissao() {
		return listaComissao;
	}

	public void setListaComissao(ListaComissao listaComissao) {

		this.listaComissao = listaComissao;
	}

	public ArrayList<ListaComissao> getResumoComissao() {
		return resumoComissao;
	}

	public void setResumoComissao(ArrayList<ListaComissao> resumoComissao) {
		this.resumoComissao = resumoComissao;
	}

	public ArrayList<ListaComissao> getItens() {
		return itens;
	}

	public void setItens(ArrayList<ListaComissao> itens) {
		this.itens = itens;
	}

	public ArrayList<ListaComissao> getItensfiltrados() {
		return itensfiltrados;
	}

	public void setItensfiltrados(ArrayList<ListaComissao> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}

	public ArrayList<ListaComissao> getItenspordata() {
		return itenspordata;
	}

	public void setItenspordata(ArrayList<ListaComissao> itenspordata) {
		this.itenspordata = itenspordata;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			ListaComissaoDAO dao = new ListaComissaoDAO();
			AngariadorcomboDAO dao4 = new AngariadorcomboDAO();
			itens = dao.listar();
			comboAngariador = dao4.listar();
			resumoComissao = dao.listarResumo();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - " + ex.getMessage());
		}
	}

	public String getData() {
		
		return listaComissao.getAngariador_combo().getTb_pf_nome();
	}

	public void prepararListar() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		sBeginDate = request.getParameter("txtBeginDate");
		sEndDate = request.getParameter("txtEndDate");
		sAngariador = request.getParameter("angariador");

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

		ListaComissaoDAO dao4 = new ListaComissaoDAO();

		try {

			itenspordata = dao4.listarData(sBeginDate, sEndDate, sAngariador);
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

		for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
			HSSFCell cell = header.getCell(i);

			cell.setCellStyle(cellStyle);
		}

	}

}
