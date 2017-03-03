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
import model.device.ddns.DdnsInfo;
import model.device.firmware.FirmwareInfo;
import model.device.log.DeviceLog;
import model.device.pppoe.PPPoECredentialsInfo;
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

    public static DdnsInfo ddnsInfo(StringResponseDTO a) {

        DdnsInfo d = new DdnsInfo();

        JsonElement jelement = new JsonParser().parse(a.getValue());
        JsonObject jobject = jelement.getAsJsonObject();

        Boolean enable = new Boolean(jobject.get("Enable").toString().replace("\"", ""));
        String hostname = jobject.get("Hostname").toString().replace("\"", "");
        String password = jobject.get("Password").toString().replace("\"", "");
        String provider = jobject.get("Provider").toString().replace("\"", "");
        String providerUrl = jobject.get("ProviderURL").toString().replace("\"", "");
        String user = jobject.get("User").toString().replace("\"", "");

        d.setEnable(enable);
        d.setHostname(hostname);
        d.setPassword(password);
        d.setProvider(provider);
        d.setProviderUrl(providerUrl);
        d.setUser(user);

        return d;
    }

    public static List<DeviceLog> deviceLog(StringResponseDTO a) {
        JsonElement jelement = new JsonParser().parse(a.getValue());
        JsonObject jobject = jelement.getAsJsonObject();
        String[] split = jobject.get("DeviceLog").toString().replace("\"", "").replace("\\n", "\n").split("\n");

        List<DeviceLog> logs = new ArrayList<>();

        for (String string : split) {
            logs.add(new DeviceLog(string));
        }

        return logs;
    }

    public static PPPoECredentialsInfo getPPPoECredentialsInfo(StringResponseDTO a) {
        JsonElement jelement = new JsonParser().parse(a.getValue());
        JsonObject jobject = jelement.getAsJsonObject();
        String username = jobject.get("Username").toString().replace("\"", "");
        String password = jobject.get("Password").toString().replace("\"", "");

        return new PPPoECredentialsInfo(username, password);
    }

}
