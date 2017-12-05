package pe.edu.upc.catchup.models;

import android.content.Context;
import android.content.SharedPreferences;

import pe.edu.upc.catchup.R;

/**
 * Created by alumnos on 9/28/17.
 */

public class PreferencesRepository {
    private Context context;

    public PreferencesRepository(Context context) {
        this.context = context;
    }

    public PreferencesRepository() {
    }

    public int getMaxResults() {
        SharedPreferences preferences = context
                .getSharedPreferences(
                        context.getString(R.string.app_name),
                        Context.MODE_PRIVATE);
        return preferences.getInt("max_results", 20);
    }

    public String getMaxResultsAsString() {
        return String.valueOf(getMaxResults());
    }

    public PreferencesRepository setMaxResults(int maxResults) {
        context
            .getSharedPreferences(
                    context.getString(R.string.app_name),
                    Context.MODE_PRIVATE)
            .edit()
            .putInt("max_results", maxResults)
            .commit();
        return this;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
