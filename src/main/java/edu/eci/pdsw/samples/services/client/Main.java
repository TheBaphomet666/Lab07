/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services.client;

import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquilerFactory;

/**
 *
 * @author hcadavid
 */
public class Main {

    public static void main(String a[]) throws ExcepcionServiciosAlquiler{
        System.out.println("Consultar cliente\n");
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarCliente(2106340));
        System.out.println("Consultar Item\n");
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarItem(11));
        System.out.println("Consultar Items Cliente\n");
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarItemsCliente(21048352));
        System.out.println("Consultar Clientes\n");
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarClientes());
        System.out.println("Consultar Items Disponibles\n");
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarItemsDisponibles());
        System.exit(0);
    }
    
}
