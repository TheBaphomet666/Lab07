/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.ItemRentado;
import java.util.List;

/**
 *
 * @author hcadavid
 */
public interface ClienteDAO {
    
    public void saveIt(ItemRentado it ) throws PersistenceException;
    
    public void save(Cliente c) throws PersistenceException;
    
    public Cliente load(long id) throws PersistenceException;
    public List<Cliente> load()throws PersistenceException;

    public void Vetar(long docu, boolean estado)throws PersistenceException;
    
}
