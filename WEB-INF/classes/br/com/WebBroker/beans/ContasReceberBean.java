package br.com.WebBroker.beans;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.IndexedColors;

import br.com.WebBroker.dao.ContasReceberDAO;
import br.com.WebBroker.dao.ExtratoBancarioDAO;
import br.com.WebBroker.domain.ContasPagar;
import br.com.WebBroker.domain.ExtratoBancario;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBContasReceber")
@ViewScoped
public class ContasReceberBean {
	
	private ContasPagar jcontaspagar;
	private ArrayList<ExtratoBancario> itensextrato;
	private ArrayList<ContasPagar> itens;
	private ArrayList<ContasPagar> itensfiltrados;
	private ArrayList<ContasPagar> itenspordata;
	public String sBeginDate;
	public String sEndDate;
	private Date currentDate = new Date(0);
	
	public ContasPagar getJcontaspagar() {
		return jcontaspagar;
	}

	public void setJcontaspagar(ContasPagar jcontaspagar) {
		this.jcontaspagar = jcontaspagar;
	}

	public ArrayList<ExtratoBancario> getItensextrato() {
		return itensextrato;
	}

	public void setItensextrato(ArrayList<ExtratoBancario> itensextrato) {
		this.itensextrato = itensextrato;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	public Date getCurrentDate() {
		return currentDate;
	}

	public ArrayList<ContasPagar> getItenspordata() {
		return itenspordata;
	}

	public void setItenspordata(ArrayList<ContasPagar> itenspordata) {
		this.itenspordata = itenspordata;
	}

	public ContasPagar getContaspagar() {
		return jcontaspagar;
	}

	public ArrayList<ContasPagar> getItens() {
		return itens;
	}

	public ArrayList<ContasPagar> getItensfiltrados() {
		return itensfiltrados;
	}

	public String getsBeginDate() {
		return sBeginDate;
	}

	public String getsEndDate() {
		return sEndDate;
	}

	public void setContaspagar(ContasPagar contaspagar) {
		this.jcontaspagar = contaspagar;
	}

	public void setItens(ArrayList<ContasPagar> itens) {
		this.itens = itens;
	}

	public void setItensfiltrados(ArrayList<ContasPagar> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}

	public void setsBeginDate(String sBeginDate) {
		this.sBeginDate = sBeginDate;
	}

	public void setsEndDate(String sEndDate) {
		this.sEndDate = sEndDate;
	}
 
	public void prepararPesquisa() {

		try {
			ContasReceberDAO dao = new ContasReceberDAO();
			itens = dao.listar(jcontaspagar);
			// dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - " + ex.getMessage());
		}
	}

	@PostConstruct
	public void prepararListar() {
		jcontaspagar = new ContasPagar();
		try {
			ContasReceberDAO dao = new ContasReceberDAO();
			itens = dao.listarData();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - " + ex.getMessage());
		}

	}
	
	public void prepararListarFiltro() {
		ExtratoBancarioDAO dao = new ExtratoBancarioDAO();
		try {
			itensextrato = dao.encontrar_conta(jcontaspagar);
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	public void prepararNovo() {
		jcontaspagar = new ContasPagar();
	}
	public void baixarpagto() {

		ContasReceberDAO dao = new ContasReceberDAO();

		try {
			dao.baixarpagamento(jcontaspagar);
		} catch (SQLException e) {

			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
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
