package com.live.broadcast.plugin;

import android.content.Intent;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

import org.json.JSONException;

@NativePlugin()
public class LiveBroadcastPlugin extends Plugin {
    static PluginCall response ;
    @PluginMethod()
    public void callLive(PluginCall call) {
        response = call;
        Intent intent = new Intent(getContext(),MainActivity.class);
        getContext().startActivity(intent);
    }

    public static void returnResponse(Object object,boolean isSuccess){
        JSObject jsObject = new JSObject();
        try {
            jsObject.putSafe("data",object);
            if(isSuccess) response.success(jsObject);
            else response.error(object.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
