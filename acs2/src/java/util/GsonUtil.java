/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.StringReader;

/**
 *
 * @author G0034481
 */
public class GsonUtil {

    private static Gson gson = new Gson();

    public static Object convert(String str, Class c) {
        JsonReader reader = new JsonReader(new StringReader(str));
        reader.setLenient(true);
        return gson.fromJson(reader, c);
    }

    public static String serialize(Object ob) {
        return gson.toJson(ob, ob.getClass());
    }

}
