package ir.mobileprogram.nik98.classes.webservice;

import java.util.ArrayList;
import java.util.List;

import ir.mobileprogram.nik98.view.datamodel.UploadResponse;
import ir.mobileprogram.nik98.view.datamodel.User;
import ir.mobileprogram.nik98.view.datamodel.UserResponse;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface APIInterface {

@GET("users")
Call<List<User>> getUsers();

@GET("users/{id}")
Call<User> getUserinfo(@Path("id") int id );

@DELETE("users/{id}")
Call<User> deleteUser(@Path("id") int id );

@POST("users")
@FormUrlEncoded

Call<User> registerUser(@Field("name") String name,
     @Field("email") String email);

@Multipart
    @POST("upload")
    Call<UploadResponse>  upload(@Part MultipartBody.Part body);


}
