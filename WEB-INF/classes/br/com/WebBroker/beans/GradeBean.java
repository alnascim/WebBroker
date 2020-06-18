package br.com.WebBroker.beans;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.AngariadorcomboDAO;
import br.com.WebBroker.domain.Angariador_combo;

import br.com.WebBroker.dao.SegmentoDAO;
import br.com.WebBroker.domain.Segmento;
 
import br.com.WebBroker.dao.PGradeDAO;
import br.com.WebBroker.domain.PGrade;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBGrade")
@ViewScoped
public class GradeBean {
	
	private PGrade Grade;

	private ArrayList<PGrade> itens;
	private ArrayList<PGrade> itensfiltrados;

	private ArrayList<Angariador_combo> comboAngariador;	
	private ArrayList<Segmento> comboSegmento;	
 	
	public PGrade getGrade() {
		return Grade;
	}
	public void setGrade(PGrade Grade) {
		this.Grade = Grade;
	}
	public PGrade getPGrade() {
		return Grade;
	}
	public void setPGrade(PGrade Grade) {
		this.Grade = Grade;
	}
	public ArrayList<PGrade> getItens() {
		return itens;
	}
	public void setItens(ArrayList<PGrade> itens) {
		this.itens = itens;
	}	
	public ArrayList<PGrade> getItensfiltrados() {
		return itensfiltrados;
	}	
	public void setItensfiltrados(ArrayList<PGrade> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}
		
	public ArrayList<Angariador_combo> getComboAngariador() {
		return comboAngariador;
	}
	public void setComboAngariador(ArrayList<Angariador_combo> comboAngariador) {
		this.comboAngariador = comboAngariador;
	}		
	
	public ArrayList<Segmento> getComboSegmento() {
		return comboSegmento;
	}
	public void setComboSegmento(ArrayList<Segmento> comboSegmento) {
		this.comboSegmento = comboSegmento;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			PGradeDAO dao = new PGradeDAO();
			itens= dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - "
					+ ex.getMessage());
		}
	}

	public void prepararNovo() {
		Grade = new PGrade();

		AngariadorcomboDAO dao = new AngariadorcomboDAO();	
		SegmentoDAO dao1 = new SegmentoDAO();
		
		try {
			comboSegmento= dao1.listar();
			comboAngariador=dao.listar();
		} catch (SQLException ex) {
				ex.printStackTrace();
				JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	public void novo()   {

		try {
			PGradeDAO dao = new PGradeDAO();
			AngariadorcomboDAO dao1 = new AngariadorcomboDAO();	
			SegmentoDAO dao2 = new SegmentoDAO();

			dao.salvar(Grade);
			itens= dao.listar();
	
			comboAngariador=dao1.listar();
			comboSegmento=dao2.listar();

			JSFUtil.adicionarMensagemSucesso("Registro Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  002 - "
					+ ex.getMessage());
		}
	}
	public void excluir() {
		
		try {
			PGradeDAO dao = new PGradeDAO();
			AngariadorcomboDAO adao = new AngariadorcomboDAO();	
			SegmentoDAO dao1 = new SegmentoDAO();

			dao.excluir(Grade); 
			
			JSFUtil.adicionarMensagemSucesso("Registro Removido com Sucesso!");
			itens = dao.listar();
			comboAngariador = adao.listar();
			comboSegmento=dao1.listar();

			
		}catch(SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
		}		
	}			
		public void editar() {			
			try {
				AngariadorcomboDAO edao = new AngariadorcomboDAO();	
				SegmentoDAO dao1 = new SegmentoDAO();

				PGradeDAO dao = new PGradeDAO();
				dao.editar(Grade);
				itens = dao.listar();
				comboAngariador = edao.listar();
				comboSegmento=dao1.listar();
				
				JSFUtil.adicionarMensagemSucesso("Registro Alterado com Sucesso!");
			}catch(SQLException ex) {
				ex.printStackTrace();
				JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
			}
		}
}
