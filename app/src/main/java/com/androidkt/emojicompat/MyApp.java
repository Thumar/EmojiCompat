package com.androidkt.emojicompat;

import android.app.Application;
import android.support.annotation.Nullable;
import android.support.text.emoji.EmojiCompat;
import android.support.text.emoji.FontRequestEmojiCompatConfig;
import android.support.v4.provider.FontRequest;
import android.util.Log;

/**
 * Created by brijesh on 6/9/17.
 */

public class MyApp extends Application {

    private final static String TAG = "MyApp";

    @Override
    public void onCreate() {
        super.onCreate();
        final EmojiCompat.Config config;

        FontRequest fontRequest = new FontRequest(
                "com.google.android.gms.fonts",
                "com.google.android.gms",
                "Noto Color Emoji Compat",
                R.array.com_google_android_gms_fonts_certs);

        config = new FontRequestEmojiCompatConfig(getApplicationContext(), fontRequest)
                .setReplaceAll(true)
                .registerInitCallback(new EmojiCompat.InitCallback() {
                    @Override
                    public void onInitialized() {
                        super.onInitialized();
                        Log.i(TAG, "Emojicompact Initialize");
                    }

                    @Override
                    public void onFailed(@Nullable Throwable throwable) {
                        super.onFailed(throwable);
                        Log.e(TAG, "Emojicompact Initialize failed " + throwable);
                    }
                });

        EmojiCompat.init(config);
    }
}
