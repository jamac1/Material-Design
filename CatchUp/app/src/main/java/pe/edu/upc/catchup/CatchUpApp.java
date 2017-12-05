package pe.edu.upc.catchup;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

/**
 * Created by alumnos on 9/18/17.
 */

public class CatchUpApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
