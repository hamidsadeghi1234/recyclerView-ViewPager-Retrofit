package ir.mobileprogram.nik98.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import ir.mobileprogram.nik98.R;
import ir.mobileprogram.nik98.classes.webservice.APIClient;
import ir.mobileprogram.nik98.classes.webservice.APIInterface;
import ir.mobileprogram.nik98.view.adapter.UsersAdapter;
import ir.mobileprogram.nik98.view.datamodel.User;
import ir.mobileprogram.nik98.view.datamodel.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        //connect APIInterface to default retrofit and make 'full Retrofit' Object
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        //make call request with 'full retrofit' //and use method(getUsers()) of APIInterface
        Call<List<User>> call=apiInterface.getUsers();
       /* finally use call request
         in this step also the  method (getUsers()) of APIInterface
         is implementing during call request*/
         call.enqueue(new Callback<List<User>>() {
         @Override
          public void onResponse(Call<List<User>> call, Response<List<User>> response) {
           if(response.isSuccessful()){
           List<User> users=response.body();
           setUpRecyclerView(users);
             }
        }
       @Override
        public void onFailure(Call<List<User>> call, Throwable t) { }
     });
    }

    private void setUpRecyclerView(List<User> users){
        RecyclerView  recyclerView=findViewById(R.id.recycler_view2);
        UsersAdapter usersAdapter=new UsersAdapter(RetrofitActivity.this,users);
        //recyclerView.setLayoutManager((new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)));
        // recyclerView.setLayoutManager((new LinearLayoutManager(RetrofitActivity.this,LinearLayoutManager.HORIZONTAL,false)));
        recyclerView.setLayoutManager((new GridLayoutManager(this,1,LinearLayoutManager.VERTICAL,false)));
        recyclerView.setAdapter(usersAdapter);
    }
}
