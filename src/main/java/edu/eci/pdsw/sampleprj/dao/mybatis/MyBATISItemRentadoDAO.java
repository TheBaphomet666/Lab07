/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.pdsw.sampleprj.dao.ItemDAO;
import edu.eci.pdsw.sampleprj.dao.ItemRentadoDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.entities.TipoItem;
import java.sql.SQLException;
import java.util.List;



/**
 *
 * @author hcadavid
 */
public class MyBATISItemRentadoDAO implements ItemRentadoDAO{

    @Inject
    private ItemRentadoMapper itemRentadoMapper;    
       


    @Override
    public ItemRentado load(int id) throws PersistenceException {
        try{
            return null;
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            //throw new PersistenceException("Error al consultar el item "+id,e);
        }
        return null;
        
    }
    @Override
    public List<ItemRentado> load() throws PersistenceException {
        try{
            return null;
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            //throw new PersistenceException("Error al consultar el item "+id,e);
        }
        return null;
    } 
        
    

    
}
