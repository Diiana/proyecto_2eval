/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.helper;

import com.google.gson.Gson;

/**
 *
 * @author al037877
 */
public class ParseJson {
    public String objectList(Object list){
        Gson oGson = new Gson();
        String strJson = oGson.toJson(list);
        return "{\"list\":"+strJson+"}";
    }
}
