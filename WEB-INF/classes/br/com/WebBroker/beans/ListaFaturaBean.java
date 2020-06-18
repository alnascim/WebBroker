package br.com.WebBroker.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.sf.jasperreports.components.map.Item;

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
import br.com.WebBroker.dao.ListaFaturaDAO;
import br.com.WebBroker.domain.ContasPagar;
import br.com.WebBroker.domain.ExtratoBancario;
import br.com.WebBroker.domain.ListaFatura;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBListaFatura")
@ViewScoped
public class ListaFaturaBean {

	private Item itemSelected;
	private double itemSelecionado;
	private ListaFatura jlistaFatura;
	private ExtratoBancario Extrato;
	private ArrayList<ExtratoBancario> itensextrato;
	private ArrayList<ListaFatura> itens;
	private ArrayList<ListaFatura> itensfiltrados;
	private ArrayList<ListaFatura> itensfatura;

	
	public ListaFatura getJlistaFatura() {
		return jlistaFatura;
	}

	public void setJlistaFatura(ListaFatura jlistaFatura) {
		this.jlistaFatura = jlistaFatura;
	}

	
	public Item getItemSelected() {
		return itemSelected;
	}

	public void setItemSelected(Item itemSelected) {
		this.itemSelected = itemSelected;
	}

	public double getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(double itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public ExtratoBancario getExtrato() {
		return Extrato;
	}

	public void setExtrato(ExtratoBancario extrato) {
		Extrato = extrato;
	}

	public ArrayList<ExtratoBancario> getItensextrato() {
		return itensextrato;
	}

	public void setItensextrato(ArrayList<ExtratoBancario> itensextrato) {
		this.itensextrato = itensextrato;
	}

	public ArrayList<ListaFatura> getItensfatura() {
		return itensfatura;
	}

	public void setItensfatura(ArrayList<ListaFatura> itensfatura) {
		this.itensfatura = itensfatura;
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

	public void prepararPesquisa_filtro() {

		try {
			ListaFaturaDAO dao = new ListaFaturaDAO();
			itens = dao.listar_faturamento_data(jlistaFatura);
			// dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - " + ex.getMessage());
		}
	}

	@PostConstruct
	public void prepararPesquisa() {
		jlistaFatura = new ListaFatura();
		try {

			ListaFaturaDAO dao = new ListaFaturaDAO();
			itens = dao.listar_faturamento();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - " + ex.getMessage());
		}

		ExtratoBancarioDAO dao = new ExtratoBancarioDAO();
		try {
			itensextrato = dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}

	public void onRowSum() {
		Iterator<ListaFatura> it = itensfatura.iterator();
		while (it.hasNext()) {
			ListaFatura f = it.next();

			try {
				ListaFaturaDAO edao = new ListaFaturaDAO();
				edao.editar(f.getID_EXT());

				itemSelecionado = edao.retorna_com();

			} catch (SQLException ex) {
				ex.printStackTrace();
				JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
			}
		}
	}

	public void cancelar() {
		try {
			ListaFaturaDAO edao = new ListaFaturaDAO();
			edao.cancelar();
			itemSelecionado = edao.retorna_com();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
		}
	}
	
	public void conciliar() {
		try {
			ListaFaturaDAO edao = new ListaFaturaDAO();
			edao.conciliar();
			itens = edao.listar_faturamento();
			itemSelecionado = edao.retorna_com();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
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
