package com.example.instagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    public static final String REST_APPLICATION_KEY = BuildConfig.APPLICATION_KEY;
    public static final String REST_CLIENT_KEY = BuildConfig.CLIENT_KEY;
    public static final String SERVER = "https://parseapi.back4app.com";

    // Initializes Parse SDK as soon as App starts up
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(REST_APPLICATION_KEY)
                .clientKey(REST_CLIENT_KEY)
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
