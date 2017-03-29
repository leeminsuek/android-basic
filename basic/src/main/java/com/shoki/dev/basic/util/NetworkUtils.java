package com.shoki.dev.basic.util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import retrofit2.Response;

/**
 * Created by shoki on 2017. 3. 29..
 */

public class NetworkUtils {
    //레트로핏 공통에러
    public static <T> T parseError(Response response, T type) {
        if(response.errorBody() != null && response.errorBody().byteStream() != null) {
            try {
                type = (T) new Gson().fromJson(StringUtils.toString(response.errorBody().byteStream()), type.getClass());
            } catch (JsonSyntaxException e) {
                return null;
//                error.setMessage(e.getMessage());
            } catch (NullPointerException e) {
                return null;
            }
        } else {
            return null;
        }
        return type;
    }
}
