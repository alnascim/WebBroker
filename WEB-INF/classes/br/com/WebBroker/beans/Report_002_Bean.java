package br.com.WebBroker.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.Report_001_DAO;
import br.com.WebBroker.domain.Report_002;
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

@ManagedBean(name = "MBReport002")
@ViewScoped
public class Report_002_Bean {

	private Report_002 Report_002;
	private ArrayList<Report_002> itens;
	private ArrayList<Report_002> itensfiltrados;

	public Report_002 getReport_002() {
		return Report_002;
	}

	public void setReport_002(Report_002 Report_002) {

		this.Report_002 = Report_002;
	}

	public ArrayList<Report_002> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Report_002> itens) {
		this.itens = itens;
	}

	public ArrayList<Report_002> getItensfiltrados() {
		return itensfiltrados;
	}

	public void setItensfiltrados(ArrayList<Report_002> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			Report_001_DAO dao = new Report_001_DAO();
			itens = dao.listar_002();
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
