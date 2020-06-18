package br.com.WebBroker.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.ListaFaturaDAO;
import br.com.WebBroker.domain.ListaFatura;
import br.com.WebBroker.util.JSFUtil;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.IndexedColors;

@ManagedBean(name = "MBListaInadimBean")
@ViewScoped
public class ListaInadimBean {

	private ListaFatura listaFatura;
	private ArrayList<ListaFatura> itens;
	private ArrayList<ListaFatura> itensfiltrados;

	public ListaFatura getListaFatura() {
		return listaFatura;
	}

	public void setListaFatura(ListaFatura listaFatura) {

		this.listaFatura = listaFatura;
	}

	public ArrayList<ListaFatura> getItens() {
		return itens;
	}

	public void setItens(ArrayList<ListaFatura> itens) {
		this.itens = itens;
	}

	public ArrayList<ListaFatura> getItensfiltrados() {
		return itensfiltrados;
	}

	public void setItensfiltrados(ArrayList<ListaFatura> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			ListaFaturaDAO dao = new ListaFaturaDAO();
			itens = dao.listar_inadimp();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - " + ex.getMessage());
		}
	}

	public void postProcessXLS(Object document) {

		HSSFWorkbook wb = (HSSFWorkbook) document;
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow header = sheet.getRow(0);

		HSSFCellStyle styleDateFormat = wb.createCellStyle();
		styleDateFormat
				.setDataFormat(HSSFDataFormat.getBuiltinFormat("dd/mm/yyyy"));

		HSSFCellStyle styleCurrencyFormat = wb.createCellStyle();
		styleCurrencyFormat.setDataFormat(HSSFDataFormat
				.getBuiltinFormat("R$#.##0,00"));

		HSSFCellStyle cellStyle = wb.createCellStyle();
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
