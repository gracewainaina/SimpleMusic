package com.example.musicca.models;

import android.app.Application;

import com.example.musicca.fragments.CreateFragment;
import com.parse.Parse;
import com.parse.ParseObject;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Use for monitoring Parse OkHttp traffic
        // Can be Level.BASIC, Level.HEADERS, or Level.BODY
        // See http://square.github.io/okhttp/3.x/logging-interceptor/ to see the options.
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.networkInterceptors().add(httpLoggingInterceptor);

        // Register your parse models
        ParseUser.registerSubclass(Song.class);
        ParseObject.registerSubclass(Playlist.class);
        ParseObject.registerSubclass(Party.class);

        // set applicationId, and server server based on the values in the Heroku settings.
        // clientKey is not needed unless explicitly configured
        // any network interceptors must be added with the Configuration Builder given this syntax
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("grace-musicca") // should correspond to APP_ID env variable
                .clientKey("grace-musiccaMasterKeyParse")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("https://grace-musicca.herokuapp.com/parse").build());
    }
}
