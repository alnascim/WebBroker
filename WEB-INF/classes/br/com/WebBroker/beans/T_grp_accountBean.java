package br.com.WebBroker.beans;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.WebBroker.dao.AutomaticFlagcomboDAO;
import br.com.WebBroker.dao.FrequenciacomboDAO;
import br.com.WebBroker.dao.GrupoContacomboDAO;
import br.com.WebBroker.dao.PayercomboDAO;
import br.com.WebBroker.dao.PjuridicasDAO;
import br.com.WebBroker.dao.SubGrupoContacomboDAO;
import br.com.WebBroker.dao.T_grp_accountDAO;
import br.com.WebBroker.domain.AutomaticFlag_combo;
import br.com.WebBroker.domain.EmpresasLemara_combo;
import br.com.WebBroker.domain.Frequencia_combo;
import br.com.WebBroker.domain.GrupoConta_combo;
import br.com.WebBroker.domain.Payer_combo;
import br.com.WebBroker.domain.SubGrupoConta_combo;
import br.com.WebBroker.domain.T_grp_account;
import br.com.WebBroker.util.JSFUtil;

@ManagedBean(name = "MBaccount")
@ViewScoped
public class T_grp_accountBean {
	private T_grp_account T_grp_account;
	private ArrayList<T_grp_account> itens;
	private ArrayList<T_grp_account> itensfiltrados;
	private ArrayList<Frequencia_combo> comboFrequencia;
	private ArrayList<AutomaticFlag_combo> comboAutomatic;
	private ArrayList<Payer_combo> combopayer;
	private ArrayList<GrupoConta_combo> comboGrupoConta;
	private ArrayList<SubGrupoConta_combo> comboSubGrupoConta;
	private ArrayList<EmpresasLemara_combo> comboEmpresaGrupo;

	public ArrayList<EmpresasLemara_combo> getComboEmpresaGrupo() {
		return comboEmpresaGrupo;
	}

	public void setComboEmpresaGrupo(
			ArrayList<EmpresasLemara_combo> comboEmpresaGrupo) {
		this.comboEmpresaGrupo = comboEmpresaGrupo;
	}

	public ArrayList<SubGrupoConta_combo> getComboSubGrupoConta() {
		return comboSubGrupoConta;
	}

	public void setComboSubGrupoConta(
			ArrayList<SubGrupoConta_combo> comboSubGrupoConta) {
		this.comboSubGrupoConta = comboSubGrupoConta;
	}

	public ArrayList<GrupoConta_combo> getComboGrupoConta() {
		return comboGrupoConta;
	}

	public void setComboGrupoConta(ArrayList<GrupoConta_combo> comboGrupoConta) {
		this.comboGrupoConta = comboGrupoConta;
	}

	public ArrayList<Payer_combo> getCombopayer() {
		return combopayer;
	}

	public void setCombopayer(ArrayList<Payer_combo> combopayer) {
		this.combopayer = combopayer;
	}

	public ArrayList<AutomaticFlag_combo> getComboAutomatic() {
		return comboAutomatic;
	}

	public void setComboAutomatic(ArrayList<AutomaticFlag_combo> comboAutomatic) {
		this.comboAutomatic = comboAutomatic;
	}

	public ArrayList<Frequencia_combo> getComboFrequencia() {
		return comboFrequencia;
	}

	public void setComboFrequencia(ArrayList<Frequencia_combo> comboFrequencia) {
		this.comboFrequencia = comboFrequencia;
	}

	public ArrayList<T_grp_account> getItensfiltrados() {
		return itensfiltrados;
	}

	public void setItensfiltrados(ArrayList<T_grp_account> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}

	public T_grp_account getT_grp_account() {
		return T_grp_account;
	}

	public void setT_grp_account(T_grp_account t_grp_account) {
		T_grp_account = t_grp_account;
	}

	public ArrayList<T_grp_account> getItens() {
		return itens;
	}

	public void setItens(ArrayList<T_grp_account> itens) {
		this.itens = itens;
	}

	@PostConstruct
	public void prepararPesquisa() {
		T_grp_accountDAO dao = new T_grp_accountDAO();
		try {

			itens = dao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  001 - " + ex.getMessage());
		}
	}

	public String getData() {

		return new SimpleDateFormat("MM-yyyy").format(new Date());
	}

	public void prepararNovo() {
		T_grp_account = new T_grp_account();
		PayercomboDAO pay = new PayercomboDAO();
		GrupoContacomboDAO gr = new GrupoContacomboDAO();
		SubGrupoContacomboDAO sgr = new SubGrupoContacomboDAO();
		FrequenciacomboDAO frq = new FrequenciacomboDAO();
		AutomaticFlagcomboDAO af = new AutomaticFlagcomboDAO();
		PjuridicasDAO pj = new PjuridicasDAO();

		try {
			combopayer = pay.listar();
			comboFrequencia = frq.listar();
			comboGrupoConta = gr.listar();
			comboAutomatic = af.listar();
			comboSubGrupoConta = sgr.listar();
			comboEmpresaGrupo=pj.EmpresasGrupo();
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}

	public void vFeeType() {

		T_grp_accountDAO dao = new T_grp_accountDAO();

		try {
			dao.vFeeType(T_grp_account);

		} catch (SQLException e) {

			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	// public void vGetIdSegmento() {
	//
	// T_grp_accountDAO dao = new T_grp_accountDAO();
	//
	// try {
	// dao.vGetIdSegmento(T_grp_account);
	//
	// } catch (SQLException e) {
	//
	// e.printStackTrace();
	// JSFUtil.adicionarMensagemErro(e.getMessage());
	// }
	// }

	public void getsubgrupo() {
		T_grp_accountDAO d = new T_grp_accountDAO();
		try {
			comboSubGrupoConta = d.getsubgrupo(T_grp_account);
		} catch (SQLException e) {

			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public String novo() throws SQLException {
		T_grp_accountDAO dao = new T_grp_accountDAO();
		try {
			dao.salvar(T_grp_account);

			JSFUtil.adicionarMensagemSucesso("Registro Salvo com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  002 - " + ex.getMessage());

		}
		return "Principal";

	}

	public void excluir() {
		T_grp_accountDAO dao = new T_grp_accountDAO();

		if (dao.f_checpayment(T_grp_account) == true) {
			JSFUtil.adicionarMensagemSucesso("Existem Pagamentos Baixados! ");
		} else {
			try {

				dao.excluir(T_grp_account);
				itens = dao.listar();

				JSFUtil.adicionarMensagemSucesso("Registro Removido com Sucesso!");
			} catch (SQLException ex) {
				ex.printStackTrace();
				JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
			}
		}

	}

	public void editar() {

		try {
			T_grp_accountDAO dao = new T_grp_accountDAO();
			// dao.editar(Fisica);
			itens = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Registro Alterado com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro  003 - " + ex.getMessage());
		}
	}

}
