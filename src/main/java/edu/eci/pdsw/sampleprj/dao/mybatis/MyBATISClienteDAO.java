/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.ItemDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.entities.TipoItem;
import java.sql.SQLException;
import java.util.List;



/**
 *
 * @author hcadavid
 */
public class MyBATISClienteDAO implements ClienteDAO{

    @Inject
    private ClienteMapper clienteMapper;    
        
    @Override
    public void saveIt(ItemRentado it) throws PersistenceException{
        try{
            clienteMapper.agregarItemRentadoACliente(it.getId(),it.getItem().getId(),it.getFechainiciorenta(),it.getFechafinrenta());
        }
        catch(Exception e){
            throw new PersistenceException("Error al registrar el item rentado "+it.toString(),e);
        }        
        
    }

    @Override
    public void save(Cliente c) throws PersistenceException{
        try{
            int vetado=0;
            if(c.isVetado()){
                vetado=1;  
            }
            clienteMapper.registrarCliente(c.getDocumento(), c.getNombre(), c.getTelefono(), c.getDireccion(), c.getEmail(),vetado);
            for(int i=0;i<c.getRentados().size();i++){
                saveIt(c.getRentados().get(i));
            }
        }
        catch(Exception e){
            throw new PersistenceException("Error al registrar el cliente "+c.toString(),e);
        }
        
    }
    
    
    
    @Override
    public Cliente load(long id) throws PersistenceException {
        try{
            return clienteMapper.consultarCliente(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el cliente "+id,e);
        }
        
        
    }
    @Override
    public List<Cliente> load() throws PersistenceException {
        try{
            return clienteMapper.consultarClientes();
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar los clientes");
        }
        
        
    }
    
    
}
