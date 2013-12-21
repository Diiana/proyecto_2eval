/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.ClienteBean;
import net.daw.helper.Contexto;

/**
 *
 * @author Alvaro
 */
public class SetValue implements Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json;
        String mensaje = "";
        if (br != null) {
            json = br.readLine();
            Gson oGson = new Gson();
            
            switch (oContexto.getClase()) {
                case "cliente":
                    ClienteBean oClienteBean;
                    oClienteBean = oGson.fromJson(json, ClienteBean.class);
                    System.out.println(oClienteBean.getId());
                    System.out.println(oClienteBean.getApe1());
                    System.out.println(oClienteBean.getApe2());
                    System.out.println(oClienteBean.getEmail());
                    System.out.println(oClienteBean.getNombre());
                    oContexto.setVista("jsp/mensaje.jsp");
                    mensaje = "Se a añadido el cliente";
                    break;
                case "usuario":
            }

        }

        return mensaje;
    }

}
