package ir.mobileprogram.nik98.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ir.mobileprogram.nik98.classes.webservice.ApiService;
import ir.mobileprogram.nik98.R;
import ir.mobileprogram.nik98.view.datamodel.WeatherInfo;

public class WeatherSampleActivity extends AppCompatActivity implements ApiService.OnWeatherInfoRecieved {
    private static final String TAG = "WeatherSampleActivity";
    private ApiService apiService;
    private ProgressBar progressBar;
    private TextView txtweatherName;
    private TextView txtWeatherDescription;
    private TextView txtTemp;
    private TextView txtHumidity;
    private TextView txtPressure;
    private TextView txtMinTemp;
    private TextView txtMaxTemp;
    private TextView txtWindSpeed;
    private TextView txtWindDegree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_sample);
        apiService=new ApiService(this);
        initViews();


        Button btnSendRequest=(Button)findViewById(R.id.btn_send_request);
        btnSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               apiService.getCurrentWeather(WeatherSampleActivity.this,"Tehran");
               progressBar.setVisibility(View.VISIBLE);

            }
        });
    }


    private  void initViews(){

          progressBar=(ProgressBar)findViewById(R.id.progress_bar);
          txtweatherName=(TextView)findViewById(R.id.txt_weather_name);
          txtWeatherDescription=(TextView)findViewById(R.id.txt_description);
          txtTemp=(TextView)findViewById(R.id.txt_temprature);
          txtHumidity=(TextView)findViewById(R.id.txt_humidity);
          txtPressure=(TextView)findViewById(R.id.txt_pressure) ;
          txtMinTemp=(TextView)findViewById(R.id.txt_min_temp);
          txtMaxTemp=(TextView)findViewById(R.id.txt_max_temp);
          txtWindSpeed=(TextView)findViewById(R.id.txt_wind_speed);
          txtWindDegree=(TextView)findViewById(R.id.txt_wind_degree);
    }

    @Override
    public void OnRecieved(WeatherInfo weatherInfo) {
  if (weatherInfo!=null) {
      //show information to user
      txtweatherName.setText("آب و هوای فعلی :" + weatherInfo.getWeatherName());
      txtWeatherDescription .setText("توضیحات:" + weatherInfo.getWeatherName());
      txtTemp.setText("دمای هوا :" +String.valueOf( weatherInfo.getWeatherTemperature()));
      txtHumidity .setText("رطوبت :" + String.valueOf(weatherInfo.getHumidity()));
      txtPressure.setText( "فشار هوا" +String.valueOf(weatherInfo.getPressure()));
      txtMinTemp.setText("حداقل دما :" +String.valueOf( weatherInfo.getMinTemperature()));
      txtMaxTemp .setText("حداکثر دما :" +String.valueOf (weatherInfo.getMaxTemperature()));
      txtWindSpeed.setText("سرعت باد :" + String.valueOf(weatherInfo.getWindSpeed()));
      txtWindDegree.setText("جهت باد :" + String.valueOf(weatherInfo.getWindDegree()));

  }
      else{
      Toast.makeText(this,"خطا در دریافت اطلاعات"  ,Toast.LENGTH_SHORT).show();
      }
    progressBar.setVisibility(View.INVISIBLE);

    }
}
