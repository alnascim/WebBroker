package br.com.WebBroker.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.PExtratoComissaoDAO;
import br.com.WebBroker.domain.PExtratoComissao;
import br.com.WebBroker.domain.Relatorio;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBExtratoCom")
@ViewScoped
public class ExtratoComissaoBean {
	
 
	private PExtratoComissao PExtratoComissao;
	private ArrayList<PExtratoComissao> itens;
	private ArrayList<PExtratoComissao> itensfiltrados;
	
	private ArrayList<PExtratoComissao> itens_corretor;
	private ArrayList<PExtratoComissao> itensfiltrados_corretor;
	
	public ArrayList<PExtratoComissao> getItens_corretor() {
		return itens_corretor;
	}
	public ArrayList<PExtratoComissao> getItensfiltrados_corretor() {
		return itensfiltrados_corretor;
	}
	public void setItens_corretor(ArrayList<PExtratoComissao> itens_corretor) {
		this.itens_corretor = itens_corretor;
	}
	public void setItensfiltrados_corretor(
			ArrayList<PExtratoComissao> itensfiltrados_corretor) {
		this.itensfiltrados_corretor = itensfiltrados_corretor;
	}
	
	public PExtratoComissao getPExtratoComissao() {
		return PExtratoComissao;
	}
	public ArrayList<PExtratoComissao> getItens() {
		return itens;
	}
	public ArrayList<PExtratoComissao> getItensfiltrados() {
		return itensfiltrados;
	}
	public void setPExtratoComissao(PExtratoComissao pExtratoComissao) {
		PExtratoComissao = pExtratoComissao;
	}
	public void setItens(ArrayList<PExtratoComissao> itens) {
		this.itens = itens;
	}
	public void setItensfiltrados(ArrayList<PExtratoComissao> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}
	@PostConstruct
	public void prepararPesquisa() {
		try {
			PExtratoComissaoDAO dao = new PExtratoComissaoDAO();
			itens = dao.listar();
			itens_corretor=dao.listar_corretor();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro 001 - " + ex.getMessage());
		}
	}
	public void call_rpt_angariador() throws Exception {

		PExtratoComissaoDAO dao = new PExtratoComissaoDAO();
		dao.call_report_angariador(PExtratoComissao);
	}		
	
	public void call_rpt_comiss() throws Exception {
		PExtratoComissaoDAO dao = new PExtratoComissaoDAO();
		dao.call_report_corretor(PExtratoComissao);
//		Relatorio relatorio = new Relatorio();
//		relatorio.getRelatorio(PExtratoComissao);
//		
	}
}
