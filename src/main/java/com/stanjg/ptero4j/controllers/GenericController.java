package com.stanjg.ptero4j.controllers;

import com.stanjg.ptero4j.PteroAdminAPI;
import com.stanjg.ptero4j.PteroUserAPI;
import com.stanjg.ptero4j.actions.PteroVoidAction;
import com.stanjg.ptero4j.entities.objects.misc.Logger;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;

public class GenericController extends Controller {

    public GenericController(PteroAdminAPI api, String baseURL, String key, Logger logger) {
        super(api, baseURL, key, logger);
    }

    public GenericController(PteroUserAPI api, String baseURL, String key, Logger logger) {
        super(api, baseURL, key, logger);
    }

    public int executeAction(PteroVoidAction action) {
        JSONObject data = action.getAsJSON();

        try {

            Response response = makeApiCall(action.getEndpoint(), action.getMethod(), data);
            if (response.code() >= 400) {
                logError(response);
            }

            return response.code();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
