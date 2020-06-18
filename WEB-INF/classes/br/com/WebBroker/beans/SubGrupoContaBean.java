package br.com.WebBroker.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.GrupoContaDAO;
import br.com.WebBroker.dao.SubGrupoContaDAO;
import br.com.WebBroker.dao.SubSegmentoDAO;
import br.com.WebBroker.domain.GrupoConta;
import br.com.WebBroker.domain.Produto;
import br.com.WebBroker.domain.SubGrupoConta;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBSubSubGrupoConta")
@ViewScoped
public class SubGrupoContaBean {

	private SubGrupoConta SubGrupoConta;
	private ArrayList<SubGrupoConta> itens;
	private ArrayList<SubGrupoConta> itensfiltrados;
	private ArrayList<GrupoConta> comboGrupo;
	private ArrayList<Produto> comboSubsegmento ;
	
	public ArrayList<Produto> getComboSubsegmento() {
		return comboSubsegmento;
	}
	public void setComboSubsegmento(ArrayList<Produto> comboSubsegmento) {
		this.comboSubsegmento = comboSubsegmento;
	}
	public ArrayList<GrupoConta> getComboGrupo() {
		return comboGrupo;
	}

	public void setComboGrupo(ArrayList<GrupoConta> comboGrupo) {
		this.comboGrupo = comboGrupo;
	}

	public SubGrupoConta getSubGrupoConta() {
		return SubGrupoConta;
	}

	public void setSubGrupoConta(SubGrupoConta subGrupoConta) {
		SubGrupoConta = subGrupoConta;
	}

	public ArrayList<SubGrupoConta> getItens() {
		return itens;
	}

	public void setItens(ArrayList<SubGrupoConta> itens) {
		this.itens = itens;
	}

	public ArrayList<SubGrupoConta> getItensfiltrados() {
		return itensfiltrados;
	}

	public void setItensfiltrados(ArrayList<SubGrupoConta> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			SubGrupoContaDAO dao = new SubGrupoContaDAO();
		
			
			itens = dao.listar();
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - " + ex.getMessage());
		}
	}

	public void prepararNovo() {
		SubGrupoConta = new SubGrupoConta();
		
		GrupoContaDAO dao = new GrupoContaDAO();
		SubSegmentoDAO daos = new SubSegmentoDAO();
		try {
			comboGrupo=dao.listar();
			comboSubsegmento=daos.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}		
	}

	public void novo() {

		try {
			SubGrupoContaDAO dao = new SubGrupoContaDAO();

			dao.salvar(SubGrupoConta);
			itens = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Registro Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  002 - " + ex.getMessage());
		}
	}

	public void excluir() {

		try {
			SubGrupoContaDAO dao = new SubGrupoContaDAO();
			dao.excluir(SubGrupoConta);

			JSFUtil.adicionarMensagemSucesso("Registro Removido com Sucesso!");
			itens = dao.listar();

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
		}
	}

}
