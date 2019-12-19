/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledevendasifce.controller;

import controledevendasifce.model.DAO.ClienteDAO;
import controledevendasifce.model.domain.Cliente;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author makleyston
 */
public class FXMLCadastroClienteController implements Initializable {

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnRemover;

    @FXML
    private TableView<Cliente> tabelaCliente;

    @FXML
    private TableColumn<Cliente, String> tblColCPF;

    @FXML
    private TableColumn<Cliente, String> tblColNome;

    @FXML
    private TableColumn<Cliente, String> tblColTelefone;
    
    List<Cliente> listCliente;
    ObservableList<Cliente> observableList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadClientes();
        this.tabelaCliente.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                if(event.getClickCount() == 2){
                    
                }
            }
    });
    }    
    
    public void loadClientes(){
        tblColNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tblColCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tblColTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        ClienteDAO clienteDAO = ClienteDAO.singleton();
        observableList = FXCollections.observableArrayList(clienteDAO.loadClientes());
        tabelaCliente.refresh();
        tabelaCliente.setItems(observableList);
    }
    
    public void showDialog(Cliente c) throws IOException{
        FXMLLoader fxmll = new FXMLLoader();
        fxmll.setLocation(FXMLDialogCadastroClienteController.class.getResource("/controledevendasifce/view/FXMLDialogCadastroCliente.fxml"));
        AnchorPane anchorPane = (AnchorPane) fxmll.load();
        
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        
        FXMLDialogCadastroClienteController controller = fxmll.getController();
        controller.setCliente(c);
        controller.setStage(stage);
        
        stage.showAndWait();
        
        if(controller.isFlagConfirmarcao()){
            loadClientes();
        }
    }
    
    @FXML
    public void handlerCadastrarCliente() throws IOException{
        showDialog(null);
    }
    
    @FXML
    public void handlerAlterarCliente() throws IOException{
        Cliente cliente = tabelaCliente.getSelectionModel().getSelectedItem();
        if(cliente != null){
            showDialog(cliente);
        }
    }
    
    @FXML
    public void handlerRemoverCliente() {
        Cliente c = tabelaCliente.getSelectionModel().getSelectedItem();
        ClienteDAO clienteDAO = ClienteDAO.singleton();
        if(c != null){
            if(clienteDAO.removeCliente(c)){
                System.out.println("Cliente removido com sucesso!");
                loadClientes();
            }
        }
    }
    
}
