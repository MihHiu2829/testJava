package com.example.testprojectexample;

import android.app.Application;

public class App extends Application {
    private Storage storage;
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        storage = new Storage();

    }

    public static App getInstance() {
        return instance;
    }

    public Storage getStorage() {
        return storage;
    }
}
