package com.stanjg.ptero4j.controllers;

import com.stanjg.ptero4j.PteroAdminAPI;
import com.stanjg.ptero4j.entities.objects.misc.Logger;
import com.stanjg.ptero4j.util.HTTPMethod;
import okhttp3.Response;

import java.io.IOException;

public class TestController extends Controller {
    private final Logger logger;

    public TestController(PteroAdminAPI api, String baseURL, String key, Logger logger) {
        super(api, baseURL, key);
        this.logger = logger;
    }

    public void testConnection() throws IOException {
        Response response = makeApiCall("/users", HTTPMethod.GET);

        switch (response.code()) {

            case 200:
                getLogger().info("Ptero4J loaded! Successfully made contact with the panel.");
                return;
            case 401:
                getLogger().error("Ptero4J failed to load! Unable to authenticate. Your key might be invalid.");
                break;
            case 403:
                getLogger().warning("Mixed: not authorized to access /users, no permission.");
                return;
            case 404:
                getLogger().error("Ptero4J failed to load! An invalid URL was provided.");
                break;
            case 500:
                getLogger().error("An error occurred on the panel side, please check panel logs/");
                break;
        }

        System.exit(1);
    }

    public void testUserConnection() throws IOException {
        Response response = makeApiCall("/", HTTPMethod.GET);

        switch (response.code()) {

            case 200:
                getLogger().info("Ptero4J loaded! Successfully made contact with the panel.");
                return;
            case 401:
                getLogger().error("Ptero4J failed to load! Unable to authenticate. Your key might be invalid.");
                break;
            case 403:
                getLogger().error("Not authorized.");
                return;
            case 404:
                getLogger().error("Ptero4J failed to load! An invalid URL was provided.");
                break;
            case 500:
                getLogger().error("An error occurred on the panel side, please check panel logs/");
                break;
        }

        System.exit(1);
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }
}
