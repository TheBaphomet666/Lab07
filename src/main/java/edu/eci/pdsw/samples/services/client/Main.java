/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services.client;

import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.TipoItem;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquilerFactory;
import java.sql.Date;
import java.time.LocalDate;
import static java.time.LocalDate.now;

/**
 *
 * @author hcadavid
 */
public class Main {

    public static void main(String a[]) throws ExcepcionServiciosAlquiler{
        System.out.println("\nConsultar cliente\n");
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarCliente(2106340));
        System.out.println("\nConsultar Item\n");
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarItem(11));
        System.out.println("\nConsultar Items Cliente\n");
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarItemsCliente(21048352));
        System.out.println("\nConsultar Clientes\n");
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarClientes());
        System.out.println("\nConsultar Items Disponibles\n");
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarItemsDisponibles());
        System.out.println("\nConsultarMultaAlquiler\n");
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarMultaAlquiler(1,Date.valueOf(now())));
        System.out.println("\nConsultarTipoItem\n");
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarTipoItem(1));
        System.out.println("\nConsultarTiposItems\n");
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarTiposItem());
        System.out.println("\nRegistarAlquilerCliente\n");
        System.out.println("\nantes\n");
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarCliente(1026588472));
        ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().registrarAlquilerCliente(Date.valueOf(now()), 1026588472,ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarItem(124124), 15);
        System.out.println("\ndespues\n");
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarCliente(1026588472));
        
        System.exit(0);
    }
    
}
