/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledevendasifce.model.DAO;

import controledevendasifce.model.domain.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author makleyston
 */
public class ClienteDAO {
    
    private List<Cliente> listClientes = new ArrayList<>();

    private static ClienteDAO clienteDAO = null;
    
    private ClienteDAO() {
       
    }
    
    public static ClienteDAO singleton(){
        if(clienteDAO == null){
            clienteDAO = new ClienteDAO();
        }
        return clienteDAO;
    }
    
    public List<Cliente> loadClientes(){
//        for (int i = 0; i < 10; i++) {
//            Cliente c = new Cliente("Nome: "+i, "CPF: "+i);
//            c.setTelefone("Telefone: "+i);
//            listClientes.add(c);
//        }
        
        return listClientes;
    }
    
    public void insertCliente(Cliente c){
        this.listClientes.add(c);
    }
    
    public void updateCliente(Cliente cliente){
        for (int i = 0; i < this.listClientes.size(); i++) {
            if(this.listClientes.get(i).getCpf().equals(cliente.getCpf())){
                this.listClientes.get(i).setEndenreco(cliente.getEndenreco());
                this.listClientes.get(i).setTelefone(cliente.getTelefone());
                this.listClientes.get(i).setNome(cliente.getNome());
            }
        }
    }
    
    public boolean removeCliente(Cliente cliente){
        for (Cliente c : listClientes) {
            if(c.getCpf().equals(cliente.getCpf())){
                listClientes.remove(c);
                return true;
            }
        }
        return false;
    }
    
}
