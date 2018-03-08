package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Cliente;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2106913
 */
public interface ClienteMapper {
    
    public Cliente consultarCliente(@Param("idcli") long id); 
    
    /**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param idcli
     * @param idit
     * @param fechainicio
     * @param fechafin 
     */
    public void agregarItemRentadoACliente(@Param ("idcli")int id, 
            @Param ("idit") int idit, 
            @Param ("fi") Date fechainicio,
            @Param ("ff") Date fechafin)throws SQLException;

    /**
     * Consultar todos los clientes
     * @return 
     */
    public  List<Cliente> consultarClientes();
    
    public void registrarCliente(@Param("doc") long documento,
                                 @Param("nom") String nombre,
                                 @Param("telf") String telefono,
                                 @Param("dir") String direccion,
                                 @Param("email")String email,
                                 @Param("vetado") int vetado);
    
    
    

    
}
