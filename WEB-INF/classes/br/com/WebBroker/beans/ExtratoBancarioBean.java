package br.com.WebBroker.beans;

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

import br.com.WebBroker.dao.ExtratoBancarioDAO;
import br.com.WebBroker.domain.ExtratoBancario;
import br.com.WebBroker.domain.ListaFatura;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBExtratoBancario")
@ViewScoped
public class ExtratoBancarioBean {

	private ExtratoBancario Extrato;
	private ArrayList<ExtratoBancario> itens;
	private ArrayList<ExtratoBancario> itensfiltrados;
	
	public ExtratoBancario getExtrato() {
		return Extrato;
	}
	public ArrayList<ExtratoBancario> getItens() {
		return itens;
	}
	public ArrayList<ExtratoBancario> getItensfiltrados() {
		return itensfiltrados;
	}
	public void setExtrato(ExtratoBancario extrato) {
		Extrato = extrato;
	}
	public void setItens(ArrayList<ExtratoBancario> itens) {
		this.itens = itens;
	}
	public void setItensfiltrados(ArrayList<ExtratoBancario> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}
	@PostConstruct
	public void prepararPesquisa() {
		Extrato = new ExtratoBancario();
		try {
			ExtratoBancarioDAO dao = new ExtratoBancarioDAO();
			itens = dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - " + ex.getMessage());
		}
	}
	public void prepararPesquisa_extrato() {

		try {
			ExtratoBancarioDAO dao = new ExtratoBancarioDAO();
			itens = dao.listar_extrato(Extrato);
			// dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - " + ex.getMessage());
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
