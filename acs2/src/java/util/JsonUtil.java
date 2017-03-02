/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import model.device.firmware.FirmwareInfo;
import model.device.log.DeviceLog;
import motive.hdm.synchdeviceops.StringResponseDTO;

/**
 *
 * @author G0042204
 */
public class JsonUtil {

    public static FirmwareInfo firmwareInfo(StringResponseDTO a) {
        JsonElement jelement = new JsonParser().parse(a.getValue());
        JsonObject jobject = jelement.getAsJsonObject();
        String firmwareVersion = jobject.get("firmwareVersion").toString().replace("\"", "");
        String preferredVersion = jobject.get("preferredVersion").toString().replace("\"", "");
        return new FirmwareInfo(firmwareVersion, preferredVersion);
    }

    public static List<DeviceLog> deviceLog(StringResponseDTO a) {
        JsonElement jelement = new JsonParser().parse(a.getValue());
        JsonObject jobject = jelement.getAsJsonObject();
        String[] split = jobject.get("DeviceLog").toString().split("\n");

        List<DeviceLog> logs = new ArrayList<>();

        for (String string : split) {
            logs.add(new DeviceLog(string));
        }

        return logs;
    }

}
