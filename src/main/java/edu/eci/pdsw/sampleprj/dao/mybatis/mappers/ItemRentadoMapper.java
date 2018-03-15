package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;


import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import java.sql.Date;
/**
 *
 * @author 2106913
 */
public interface ItemRentadoMapper {
    
    
    public List<ItemRentado> consultarItemsRentados();        
    
    public ItemRentado consultarItemRentado(@Param("idi")int id);
    
    public void registrarAlquilerCliente(@Param("ini")Date ini,@Param("idc") long idc,@Param("idi") int idi,@Param("fin")Date fin);

      
}
