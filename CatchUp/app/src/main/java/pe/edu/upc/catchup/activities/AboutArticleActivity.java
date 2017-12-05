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
import pe.edu.upc.catchup.models.Article;

public class AboutArticleActivity extends AppCompatActivity {
    ANImageView pictureANImageView;
    TextView titleTextView;
    TextView descriptionTextView;
    Article article;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_article);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        article = Article.from(getIntent().getExtras());
        pictureANImageView = (ANImageView) findViewById(R.id.pictureANImageView);
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        descriptionTextView = (TextView) findViewById(R.id.descriptionTextView);
        pictureANImageView.setDefaultImageResId(R.mipmap.ic_launcher);
        pictureANImageView.setErrorImageResId(R.mipmap.ic_launcher);
        pictureANImageView.setImageUrl(article.getUrlToImage());
        titleTextView.setText(article.getTitle());
        descriptionTextView.setText(article.getDescription());


    }

}
