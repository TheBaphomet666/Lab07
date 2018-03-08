package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;


import edu.eci.pdsw.samples.entities.Item;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2106913
 */
public interface ItemMapper {
    
    
    public List<Item> consultarItems();        
    
    public Item consultarItem(@Param("id")int id);
    
    public void insertarItem(@Param ("id") int id,
            @Param ("name") String nombre,
            @Param ("desc") String descripcion,
            @Param ("flanz") Date fechadelanzamiento,
                    @Param ("txd") long tarifaxdia,
                    @Param ("frent") String formatorenta,
                    @Param ("genero") String genero,
                    @Param ("tipit") int tipoitm) throws SQLException;
    public List<Item> consultarItemsDisponibles();

      
}
