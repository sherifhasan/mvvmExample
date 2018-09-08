package example.android.mvvmexample;

import android.app.Application;
import android.content.Context;


public class MVVMExample extends Application {
    private static MVVMExample application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static Context getAppContext() {
        return application.getApplicationContext();
    }
}

