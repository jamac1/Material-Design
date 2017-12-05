package pe.edu.upc.catchup.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;

import pe.edu.upc.catchup.R;
import pe.edu.upc.catchup.models.Source;

public class AboutSourceActivity extends AppCompatActivity {
    ANImageView logoANImageView;
    TextView nameTextView;
    TextView descriptionTextView;
    Source source;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_source);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        source = Source.from(getIntent().getExtras());
        logoANImageView = (ANImageView) findViewById(R.id.logoANImageView);
        nameTextView = (TextView) findViewById(R.id.nameTextView);
        descriptionTextView = (TextView) findViewById(R.id.descriptionTextView);

        logoANImageView.setDefaultImageResId(R.mipmap.ic_launcher);
        logoANImageView.setErrorImageResId(R.mipmap.ic_launcher);
        logoANImageView.setImageUrl(source.getUrlToLogo());
        nameTextView.setText(source.getName());
        descriptionTextView.setText(source.getDescription());


    }

}
