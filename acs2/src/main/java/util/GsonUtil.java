/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;
import model.device.log.DeviceLogR;
import motive.hdm.synchdeviceops.StringResponseDTO;

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
    
    public static Object convertValues(StringResponseDTO a, Class c) {
        JsonElement jelement = new JsonParser().parse(a.getValue());
        JsonObject jobject = jelement.getAsJsonObject();        
        JsonObject jo = (JsonObject) jobject.get("values");
        return gson.fromJson(jo, c);
    }

    public static String serialize(Object ob) {
        return gson.toJson(ob, ob.getClass());
    }

    public static List<DeviceLogR> deviceLogR(StringResponseDTO a) {
        JsonElement jelement = new JsonParser().parse(a.getValue());
        JsonObject jobject = jelement.getAsJsonObject();
        String[] split = jobject.get("DeviceLog").toString().replace("\"", "").replace("\\n", "\n").split("\n");
        JsonArray list = new JsonArray();
        for (String string : split) {
            if (!string.isEmpty()) {
                //System.out.println(string);                
                String[] lineSplit = string.replace("\"", "").replace("\\t", "\t").split("\t");
//                System.out.println("Index" + lineSplit[0]);
//                System.out.println("Time" + lineSplit[1]);
//                System.out.println("Type" + lineSplit[2]);
//                System.out.println("Servity" + lineSplit[3]);
//                System.out.println("LogInformation" + lineSplit[4]);
//                System.out.println("----------------------------------");
                JsonObject obj = new JsonObject();
                obj.addProperty("Index", lineSplit[0]);
                obj.addProperty("Time", lineSplit[1]);
                obj.addProperty("Type", lineSplit[2]);
                obj.addProperty("Servity", lineSplit[3]);
                obj.addProperty("LogInformation", lineSplit[4]);
                list.add(obj);
            }
        }
        //System.out.println(list);
        //List<DeviceLogR> logs = new ArrayList<>();        
        DeviceLogR[] logs = gson.fromJson(list, DeviceLogR[].class);
        return Arrays.asList(logs);
    }

}
