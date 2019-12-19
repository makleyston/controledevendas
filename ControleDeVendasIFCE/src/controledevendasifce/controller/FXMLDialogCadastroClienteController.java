/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledevendasifce.controller;

import controledevendasifce.model.DAO.ClienteDAO;
import controledevendasifce.model.domain.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author makleyston
 */
public class FXMLDialogCadastroClienteController implements Initializable {

    @FXML
    private AnchorPane anchorPaneDialogCadastroCliente;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnConfirmar;

    @FXML
    private TextField textFieldCPF;

    @FXML
    private TextField textFieldNome;

    @FXML
    private TextField textFieldTelefone;
    
    Cliente cliente;
    Stage stage;
    boolean flagConfirmarcao = false;

    public boolean isFlagConfirmarcao() {
        return flagConfirmarcao;
    }

    public void setFlagConfirmarcao(boolean flagConfirmarcao) {
        this.flagConfirmarcao = flagConfirmarcao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        loadData();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private void loadData(){
        if(getCliente() != null){
            if(!getCliente().getCpf().equals("")){
                textFieldNome.setText(getCliente().getNome());
                textFieldCPF.setText(getCliente().getCpf());
                textFieldTelefone.setText(getCliente().getTelefone());
            }   
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }  
    
    @FXML
    public void handlerConfirmar(){
        //Fazer os tratamentos necessários
        boolean flag = (getCliente() == null ? true : false);
        
        cliente = new Cliente(this.textFieldNome.getText().toString(), textFieldCPF.getText().toString());
        cliente.setTelefone(textFieldTelefone.getText().toString());
        
        ClienteDAO clienteDAO = ClienteDAO.singleton();
        
        if(flag)
            clienteDAO.insertCliente(cliente);
        else
            clienteDAO.updateCliente(cliente);
        
        setFlagConfirmarcao(true);
        getStage().close();
    }
    
    @FXML
    public void handlerCancelar(){
        setFlagConfirmarcao(false);
        getStage().close();
    }
    
}
