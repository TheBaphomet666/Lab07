/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.Adaptators;

import edu.eci.pdsw.samples.entities.Cliente;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author root
 */
public class Adaptador {
    
    public static Map<Long,Cliente> Ctomap(List<Cliente> c){
        HashMap map = new HashMap<>();
        for (Cliente ce : c) map.put(ce.getDocumento(),ce);
        return map;
    }
}
