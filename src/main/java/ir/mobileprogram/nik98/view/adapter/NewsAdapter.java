package ir.mobileprogram.nik98.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;

import ir.mobileprogram.nik98.R;
import ir.mobileprogram.nik98.view.datamodel.Post;

public class NewsAdapter extends RecyclerView.Adapter <NewsAdapter.NewsViewHolder>{
    private Context context;
    private List<Post> posts;

    public NewsAdapter (Context context, List<Post> posts){
        this.context = context;
        this.posts = posts;
    }
    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(context).inflate(R.layout.layout_news,parent,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, final int position) {
        Post post=posts.get(position);
        Picasso.get().load(post.getImage_url().replace("127.0.0.1","192.168.1.4")).into(holder.newsImage);
        holder.title.setText(post.getTitle());
        holder.content.setText(post.getContent());
        holder.date.setText(post.getDate());

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public   class NewsViewHolder extends RecyclerView.ViewHolder{
       private ImageView newsImage;
       private TextView title;
       private TextView content;
       private TextView date;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        newsImage=(ImageView)itemView.findViewById(R.id.item_image);
        title=(TextView)itemView.findViewById(R.id.news_title);
        content=(TextView)itemView.findViewById(R.id.news_content);
        date=(TextView)itemView.findViewById(R.id.news_date);
    }
}

}
