package com.stanjg.ptero4j.entities.panel.admin.node;

import com.stanjg.ptero4j.PteroAdminAPI;
import org.json.JSONObject;

// ------------------------------
// Copyright (c) PiggyPiglet 2019
// https://www.piggypiglet.me
// ------------------------------
public class Allocation {
    private final int id;
    private final String ip;
    private final String alias;
    private final int port;
    private final boolean assigned;

    public Allocation(PteroAdminAPI api, JSONObject json) {
        this(
                json.getInt("id"),
                json.getString("ip"),
                Allocation.tryToGet(json, "alias"),
                json.getInt("port"),
                json.getBoolean("assigned")
        );
    }
    public static String tryToGet(JSONObject jsonObj, String key) {
        if (jsonObj.has(key))
            return jsonObj.optString(key);
        return null;
    }
    private Allocation(int id, String ip, String alias, int port, boolean assigned) {
        this.id = id;
        this.ip = ip;
        this.alias = alias;
        this.port = port;
        this.assigned = assigned;
    }

    public int getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public String getAlias() {
        return alias;
    }

    public int getPort() {
        return port;
    }

    public boolean isAssigned() {
        return assigned;
    }
}
