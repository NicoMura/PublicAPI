package net.hypixel.example;

import net.hypixel.api.HypixelAPI;
import net.hypixel.api.reply.KeyReply;
import net.hypixel.api.request.Request;
import net.hypixel.api.request.RequestBuilder;
import net.hypixel.api.request.RequestType;
import net.hypixel.api.util.Callback;

public class KeyInfoExample {
    public static void main(String[] args) {
        HypixelAPI.getInstance().setApiKey(ExampleUtil.API_KEY);

        Request request = RequestBuilder.newBuilder(RequestType.KEY).createRequest();
        HypixelAPI.getInstance().getAsync(request, (Callback<KeyReply>) (failCause, result) -> {
            if (failCause != null) {
                failCause.printStackTrace();
            } else {
                System.out.println(result);
            }
            HypixelAPI.getInstance().finish();
            System.exit(0);
        });
        ExampleUtil.await(); // This is required because the API is asynchronous, so without this the program will exit.
    }
}
