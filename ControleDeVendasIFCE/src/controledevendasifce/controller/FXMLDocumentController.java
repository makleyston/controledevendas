/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledevendasifce.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author makleyston
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private MenuItem menuItemCadastrosClientes;
    @FXML
    private MenuItem menuItemCadastrosProdutos;
    @FXML
    private MenuItem menuItemVendasRealizarVendas;
    @FXML
    private MenuItem menuItemVendasRelatoriosVendasPorMes;
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    public void hanlerCadastroCliente() throws IOException{
        //AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/controledevendasifce/view/FXMLCadastroCliente.fxml"));
        //anchorPane.getChildren().setAll(a);
        
        Parent root = FXMLLoader.load(getClass().getResource("/controledevendasifce/view/FXMLCadastroCliente.fxml"));
        
        Scene scene = new Scene(root);
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setIconified(false);
        stage.setTitle("Cadastro de Cliente");
        //stage.setMaximized(true);
        stage.show();
        
    }
    
    @FXML
    public void hanlerCadastroProduto(){
        
    }
    
    @FXML
    public void hanlerVendasRealizarVendas(){
        
    }
    
    @FXML
    public void hanlerRelatoriosVendasPorMes(){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
