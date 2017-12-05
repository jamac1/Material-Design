package pe.edu.upc.catchup.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;

import java.util.List;

import pe.edu.upc.catchup.R;
import pe.edu.upc.catchup.activities.AboutSourceActivity;
import pe.edu.upc.catchup.activities.SourceArticlesActivity;
import pe.edu.upc.catchup.models.PreferencesRepository;
import pe.edu.upc.catchup.models.Source;

/**
 * Created by alumnos on 9/14/17.
 */

public class SourcesAdapter extends RecyclerView.Adapter<SourcesAdapter.ViewHolder>  {
    private List<Source> sources;

    public SourcesAdapter(List<Source> sources) {
        this.setSources(sources);
    }

    public SourcesAdapter() {
    }

    @Override
    public SourcesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_source, parent, false));
    }

    @Override
    public void onBindViewHolder(SourcesAdapter.ViewHolder holder, int position) {
        final Source source = sources.get(position);
        // TODO: Assign value to ImageView
        holder.logoANImageView.setDefaultImageResId(R.mipmap.ic_launcher);
        holder.logoANImageView.setErrorImageResId(R.mipmap.ic_launcher);
        holder.logoANImageView.setImageUrl(source.getUrlToLogo());
        holder.nameTextView.setText(source.getName());
        holder.aboutTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Start About Source Activity
                Bundle bundle = source.toBundle();
                Context context = view.getContext();
                Intent intent = new Intent(context, AboutSourceActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        holder.newsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Start Source Articles Activity
                Bundle bundle = source.toBundle();
                Context context = view.getContext();
                Intent intent = new Intent(context, SourceArticlesActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sources.size();
    }

    public List<Source> getSources() {
        return sources;
    }

    public SourcesAdapter setSources(List<Source> sources) {
        this.sources = sources;
        return this;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ANImageView logoANImageView;
        TextView nameTextView;
        TextView aboutTextView;
        TextView newsTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            logoANImageView = (ANImageView) itemView.findViewById(R.id.logoANImageView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            aboutTextView = (TextView) itemView.findViewById(R.id.aboutTextView);
            newsTextView = (TextView) itemView.findViewById(R.id.newsTextView);
        }
    }
}
