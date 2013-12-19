/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.daw.bean.ClienteBean;
import net.daw.data.Mysql;
import net.daw.helper.FilterBean;

/**
 *
 * @author al037877
 */
public class ClienteDao {
    private final Mysql oMysql;
    private final net.daw.helper.Enum.Connection enumTipoConexion;

    public ClienteDao(net.daw.helper.Enum.Connection tipoConexion) throws Exception {
        oMysql = new Mysql();
        enumTipoConexion = tipoConexion;
    }
    
    public ArrayList<ClienteBean> getPage(int intRegsPerPag, int intPage, ArrayList<FilterBean>  hmFilter, HashMap<String, String> hmOrder) throws Exception {
        ArrayList<Integer> arrId;
        ArrayList<ClienteBean> arrCliente = new ArrayList<>();
        try {
            oMysql.conexion(enumTipoConexion);
            arrId = oMysql.getPage("cliente", intRegsPerPag, intPage, hmFilter, hmOrder);
            Iterator<Integer> iterador = arrId.listIterator();
            while (iterador.hasNext()) {
                ClienteBean oClienteBean = new ClienteBean(iterador.next());
                arrCliente.add(this.get(oClienteBean));
            }
            oMysql.desconexion();
            return arrCliente;
        } catch (Exception e) {
            throw new Exception("ClienteDao.getPage: Error: " + e.getMessage());
        }
    }
}
