package com.example.rifafauzi6.aplikasinews.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rifafauzi6.aplikasinews.DetailActivity;
import com.example.rifafauzi6.aplikasinews.Entity.News;
import com.example.rifafauzi6.aplikasinews.R;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context context;
    private List<News> list;

    public NewsAdapter(Context context, List<News> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_news, null, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final News news = list.get(position);
        Glide.with(context).load(news.getImgNews()).into(holder.gmb);
        holder.judul.setText(news.getTitleNews());
        holder.tgl.setText(news.getDateNews().substring(0, 10) + " " + news.getDateNews().substring(11, 16));
        if (news.getAuthorNews() == null) {
            holder.penulis.setText("Penulis Tidak Diketahui");
        } else {
            holder.penulis.setText(news.getAuthorNews());
        }

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailActivity.class);
                i.putExtra("imgNews", news.getImgNews());
                i.putExtra("titleNews", news.getTitleNews());
                if (news.getContentNews() == null) {
                    i.putExtra("contentNews", "No Description");
                } else {
                    i.putExtra("contentNews", news.getContentNews());
                }
                i.putExtra("dateNews", news.getDateNews().substring(0, 10) + " " + news.getDateNews().substring(11, 16));
                if (news.getAuthorNews() == null) {
                    i.putExtra("authorNews", "Unknown Author");
                } else {
                    i.putExtra("authorNews", news.getAuthorNews());
                }
                i.putExtra("sourceNews", news.getSourceNews());
                context.startActivity(i);
                ((Activity) context).overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
        private ImageView gmb;
        private TextView judul, tgl, penulis;

        public ViewHolder(View itemView) {
            super(itemView);

            cv = itemView.findViewById(R.id.cv);
            gmb = itemView.findViewById(R.id.gambar);
            judul = itemView.findViewById(R.id.judul);
            tgl = itemView.findViewById(R.id.tgl);
            penulis = itemView.findViewById(R.id.penulis);
        }
    }

}
