package ir.mobileprogram.nik98.view.activity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import ir.mobileprogram.nik98.R;
import ir.mobileprogram.nik98.classes.webservice.APIClient;
import ir.mobileprogram.nik98.classes.webservice.APIInterface;
import ir.mobileprogram.nik98.view.datamodel.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        Bundle bundle=getIntent().getExtras();
        userInfoRequest(bundle.getInt("id"));
    }
    private void userInfoRequest(final int id){
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<User> call=apiInterface.getUserinfo(id);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    User user=response.body();
                    TextView userNametv=(TextView)findViewById(R.id.user_name_info);
                    TextView userEmailtv=(TextView)findViewById(R.id.user_email_info);
                    userNametv.setText(user.getName());
                    userEmailtv.setText(user.getEmail());
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {}
        });
    }
}
