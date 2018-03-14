/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services.client;

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
        System.exit(0);
    }
    
}
