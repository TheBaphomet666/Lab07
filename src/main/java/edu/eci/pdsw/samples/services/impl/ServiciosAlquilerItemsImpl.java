package edu.eci.pdsw.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.ItemDAO;
import edu.eci.pdsw.sampleprj.dao.ItemRentadoDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.TipoItemDAO;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.entities.TipoItem;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.util.List;
import java.sql.Date;


/**
 * 
 * @author hcadavid
 */
@Singleton
public class ServiciosAlquilerItemsImpl implements ServiciosAlquiler {
    @Inject private ItemDAO daoItem;

    @Inject private ClienteDAO daoCliente;
    @Inject private ItemRentadoDAO daoRentado;
    @Inject private TipoItemDAO daoTipo;
    private static int VALOR_MULTAXDIA=5000;

        
    @Override
    public int valorMultaRetrasoxDia() {
        VALOR_MULTAXDIA=5000;
        return VALOR_MULTAXDIA;
    }

    @Override
    public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
        try{
            return daoCliente.load(docu);
        }
        catch(Exception e){
           throw new ExcepcionServiciosAlquiler(e.getMessage(),e); 
        }
    }
        

    @Override
    public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
        try{
            Cliente c = daoCliente.load(idcliente);
            return  c.getRentados();
        }
        catch(PersistenceException e){
            throw new ExcepcionServiciosAlquiler(e.getMessage(),e); 
        }
    }

    @Override
    public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
        try{
            return daoCliente.load();
        }
        catch(PersistenceException e){
            //System.out.println(e.getMessage());
            throw new ExcepcionServiciosAlquiler(e.getMessage(),e); 
        }    
    }

    @Override
    public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
        try {
            return daoItem.load(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el item "+id,ex);
        }
    }

    @Override
    public List<Item> consultarItemsDisponibles()throws ExcepcionServiciosAlquiler {
        try {
            return daoItem.consultarItemsDisponibles();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar Los items Disponibles ",ex);
        }
    }    

    @Override
    public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
        try {
            ItemRentado i=daoRentado.load(iditem);
            Date fin= i.getFechafinrenta();
            long dias =0;
            if(fechaDevolucion.after(fin)){
                dias=((fechaDevolucion.getTime()-fin.getTime())/86400000);
            }
            //System.out.println("DIAS:"+dias);
            return dias*VALOR_MULTAXDIA;
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar Los items Disponibles ",ex);
        }   
       
    }

    @Override
    public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
        try {
            return daoTipo.load(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar Los items Disponibles ",ex);
        }
    }

    @Override
    public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
        try {
            return daoTipo.load();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar Los items Disponibles ",ex);
        }
    }

    @Override
    public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
        try {
            daoRentado.registrarAlquilerCliente(date,docu,item, numdias);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al RegistrarAlquilerCliente ",ex);
        }
    }

    @Override
    public void registrarCliente(Cliente p) throws ExcepcionServiciosAlquiler {
        try {
            daoCliente.save(p);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al Registrar Cliente ",ex);
        }
    }


    @Override
    public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
        try {
            Item i=daoItem.load(iditem);
            long tarifa= i.getTarifaxDia()*numdias;
            return tarifa;
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al ConsultarcostoAlquiler ",ex);
        }
    }

    @Override
    public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
        try {
            daoItem.actualizarTarifaItem(id,tarifa);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al registrar Item ",ex);
        }
    }

    @Override
    public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
         try {
            daoItem.save(i);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al registrar Item ",ex);
        }
    }

    @Override
    public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
        try {
            daoCliente.Vetar(docu,estado);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al registrar Item ",ex);
        }
    }
    
    
    
}
