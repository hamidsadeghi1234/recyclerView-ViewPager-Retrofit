package ir.mobileprogram.nik98.classes.webservice;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ir.mobileprogram.nik98.view.datamodel.Post;
import ir.mobileprogram.nik98.view.datamodel.WeatherInfo;

public class ApiService {
    private static final String TAG = "ApiService";
    private Context context;

    public  ApiService(Context context){
        this.context = context;
    }

    public void getCurrentWeather(final OnWeatherInfoRecieved onWeatherInfoRecieved, String city){
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET,
                "http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=987e07a0853cc59b2f9073dded7f3808"
                , null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i(TAG, "onResponse: "+response.toString());
                onWeatherInfoRecieved.OnRecieved(parseResponseToWeatherInfo(response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: "+error.toString());
                Log.d("hamid", "error shod ");
                onWeatherInfoRecieved.OnRecieved(null);
            }
        }
        );
        request.setRetryPolicy(new DefaultRetryPolicy(200,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(request);
    }
    private WeatherInfo parseResponseToWeatherInfo(JSONObject response){
        WeatherInfo weatherInfo=new WeatherInfo();
        try {
            JSONArray weatherJsonArray=response.getJSONArray("weather");
            JSONObject weatherJsonObject=weatherJsonArray.getJSONObject(0);
            weatherInfo.setWeatherName(weatherJsonObject.getString("main"));
            weatherInfo.setWetherDescription(weatherJsonObject.getString("description"));
            JSONObject mainJsonObject=response.getJSONObject("main");
            weatherInfo.setWeatherTemperature((float)mainJsonObject.getDouble("temp"));
            weatherInfo.setHumidity(mainJsonObject.getInt("humidity"));
            weatherInfo.setPressure(mainJsonObject.getInt("pressure"));
            weatherInfo.setMinTemperature((float)mainJsonObject.getDouble("temp_min"));
            weatherInfo.setMaxTemperature((float)mainJsonObject.getDouble("temp_max"));
            JSONObject windJsonObject=response.getJSONObject("wind");
            weatherInfo.setWindSpeed((float)windJsonObject.getDouble("speed"));
            weatherInfo.setWindDegree((float)windJsonObject.getDouble("deg"));
            return  weatherInfo;
        } catch (JSONException e) {
            e.printStackTrace();
            return  null;
        }
    }

    public void getPosts(final OnPostsRecieved onPostsRecieved){
        final JsonArrayRequest request=new JsonArrayRequest(Request.Method.GET,
                "http://192.168.1.4/api/GetPosts.php",
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
               List<Post> posts=new ArrayList<>();
               for (int i = 0 ; i < response.length();i++){
                   Post post=new Post();
                   try {
                       JSONObject jsonObject=response.getJSONObject(i);
                       post.setTitle(jsonObject.getString("title"));
                       post.setId(jsonObject.getInt("id"));
                       post.setContent(jsonObject.getString("content"));
                       post.setDate(jsonObject.getString("date"));
                       post.setImage_url(jsonObject.getString("image_url"));
                       posts.add(post);
                   } catch (JSONException e) {
                       e.printStackTrace();
                   }
               }
               onPostsRecieved.onRecieved(posts);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: "+error );
            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(18000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(context).add(request );

    }

    public interface OnWeatherInfoRecieved{
        void OnRecieved(WeatherInfo weatherInfo);
    }
    public interface OnPostsRecieved{
        void  onRecieved(List<Post> posts);
    }

}
