package ir.mobileprogram.nik98.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.mobileprogram.nik98.classes.webservice.ApiService;
import ir.mobileprogram.nik98.view.adapter.NewsAdapter;
import ir.mobileprogram.nik98.R;
import ir.mobileprogram.nik98.view.datamodel.Post;

public class LastNewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_news);

        ApiService apiService=new ApiService(this);

        apiService.getPosts(new ApiService.OnPostsRecieved() {
            @Override
            public void onRecieved(List<Post> posts) {
                RecyclerView recyclerView=findViewById(R.id.recycler_view);
                NewsAdapter newsAdapter=new NewsAdapter(LastNewsActivity.this,posts);
                // recyclerView.setLayoutManager((new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)));
                recyclerView.setLayoutManager((new LinearLayoutManager(LastNewsActivity.this,LinearLayoutManager.HORIZONTAL,false)));
                // recyclerView.setLayoutManager((new GridLayoutManager(this,2,LinearLayoutManager.VERTICAL,false)));
                recyclerView.setAdapter(newsAdapter);
            }
        });


    }
}
