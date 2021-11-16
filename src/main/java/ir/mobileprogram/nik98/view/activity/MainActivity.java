package ir.mobileprogram.nik98.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import ir.mobileprogram.nik98.R;
import ir.mobileprogram.nik98.view.fragment.ClothesFragment;

public class MainActivity extends AppCompatActivity {
    private  static  final  String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: ");
        Button btnViewPager=(Button)findViewById(R.id.btn_view_pager);
        Button btnRecyclerView=(Button)findViewById(R.id.btn_recycler_view);
        Button btnJsonWeather=(Button)findViewById(R.id.btn_JSON_weather) ;
        Button btnGetUsersList=(Button)findViewById(R.id.btn_get_users_list) ;
        Button btnStore=(Button)findViewById(R.id.btn_srore) ;

        btnViewPager.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(MainActivity.this,BotickActivity.class);
                 startActivity(intent);
             }});
        btnRecyclerView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(MainActivity.this, ClothesFragment.class);
            startActivity(intent);
             }});
        btnJsonWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,WeatherSampleActivity.class);
                startActivity(intent);
            }});

        btnGetUsersList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RetrofitActivity.class);
                startActivity(intent);
        }});
        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, RegisterAndDeletActivity.class);
                startActivity(intent);
            }});

    }
/*
    @Override protected void onStart()   { super.onStart();  Log.i(TAG, "onStart: "  );}
    @Override protected void onResume()  { super.onResume(); Log.i(TAG, "onResume: " );}
    @Override protected void onPause()   { super.onPause();  Log.i(TAG, "onPause: "  );}
    @Override protected void onStop()    { super.onStop();   Log.i(TAG, "onStop: "   );}
    @Override protected void onRestart() { super.onRestart();Log.i(TAG, "onRestart: ");}
    @Override protected void onDestroy() { super.onDestroy();Log.i(TAG, "onDestroy: ");}
   */
}
