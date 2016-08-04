package com.kbaldauf.playerfinder.network;

import android.content.Context;

import com.kbaldauf.playerfinder.R;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class StattleshipRequestInterceptor implements Interceptor {

    final Headers headers;

    @Inject
    public StattleshipRequestInterceptor(Context context) {
        headers = Headers.of(context.getString(R.string.stattleship_authorization_key),
                String.format(context.getString(R.string.stattleship_token_key), context.getString(R.string.stattleship_api_token)),
                context.getString(R.string.stattleship_content_key), context.getString(R.string.stattleship_content_value),
                context.getString(R.string.stattleship_accept_key), context.getString(R.string.stattleship_accept_value));
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request newRequest = chain.request().newBuilder().headers(headers).build();
        return chain.proceed(newRequest);
    }
}
