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

import br.com.WebBroker.dao.ListaFaturaDAO;
import br.com.WebBroker.domain.ListaFatura;
import br.com.WebBroker.domain.PFatSelec;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBFatSelecSint")
@ViewScoped
public class FatSelecBeanSint {

	private PFatSelec FatSelec;
	private ArrayList<ListaFatura> itens;
	private ArrayList<ListaFatura> itensfiltrados;
	private ArrayList<ListaFatura> itenspordata;
	public String sBeginDate;
	public String sEndDate;

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
	public PFatSelec getFatSelec() {
		return FatSelec;
	}
	public void setFatSelec(PFatSelec FatSelec) {
		this.FatSelec = FatSelec;
	}
	public PFatSelec getPFatSelec() {
		return FatSelec;
	}
	public void setPFatSelec(PFatSelec FatSelec) {

		this.FatSelec = FatSelec;
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
	
	public ArrayList<ListaFatura> getItenspordata() {
		return itenspordata;
	}
	public void setItenspordata(ArrayList<ListaFatura> itenspordata) {
		this.itenspordata = itenspordata;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			ListaFaturaDAO dao = new ListaFaturaDAO();
			itens = dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - " + ex.getMessage());
		}
	}
	
	public void prepararListar() {
	    HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        sBeginDate= request.getParameter("txtBeginDate");
        sEndDate= request.getParameter("txtEndDate");
        sBeginDate=sBeginDate.replace("/", "");
        String sAno=sBeginDate.substring(4,8);
        String sMes=sBeginDate.substring(2,4);
        String sDia=sBeginDate.substring(0,2);
        sBeginDate=sAno+sMes+sDia;
        
        sEndDate=sEndDate.replace("/", "");
        sAno=sEndDate.substring(4,8);
        sMes=sEndDate.substring(2,4);
        sDia=sEndDate.substring(0,2);
        sEndDate=sAno+sMes+sDia;
	
        ListaFaturaDAO dao4 = new ListaFaturaDAO();
 
		try {
			
			itenspordata = dao4.listarData(sBeginDate,sEndDate);
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
