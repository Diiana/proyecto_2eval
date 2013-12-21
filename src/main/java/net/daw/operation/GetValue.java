/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.daw.operation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alvaro
 */
public class GetValue implements Operation{

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       
        System.out.println("Paso por aquiiii!!!");
        
        return null;
    }
    
}
