package com.shoki.dev.basic.network;

/**
 * Created by shoki on 2017. 3. 31..
 */

public class Api {
    private Api() {

    }

    public static String BASE_URL = "";

    public static void init(String baseUrl) {
        BASE_URL = baseUrl;
        NetworkClient.clear();
    }

    public static<SERVICE> SERVICE getApiService(SERVICE service) {
        return (SERVICE) NetworkClient.getClient(BASE_URL).create(service.getClass());
    }
}
