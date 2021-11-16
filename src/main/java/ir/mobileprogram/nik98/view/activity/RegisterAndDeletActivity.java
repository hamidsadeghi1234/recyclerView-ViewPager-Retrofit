package ir.mobileprogram.nik98.view.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import ir.mobileprogram.nik98.R;
import ir.mobileprogram.nik98.classes.webservice.APIClient;
import ir.mobileprogram.nik98.classes.webservice.APIInterface;
import ir.mobileprogram.nik98.view.datamodel.UploadResponse;
import ir.mobileprogram.nik98.view.datamodel.User;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterAndDeletActivity extends AppCompatActivity {
   private EditText name,email,idet;
   private Button registerBtn,deleteBtn,uploadImageBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name=findViewById(R.id.name_edit_text);
        email=findViewById(R.id.email_edit_text);
        idet=findViewById(R.id.id_edit_text);
        deleteBtn=findViewById(R.id.delete_button);
        registerBtn=findViewById(R.id.register_button);
        uploadImageBtn=findViewById(R.id.upload_image_button);

        uploadImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,100);
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUsers(String.valueOf(name.getText()),
                String.valueOf(email.getText()));
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteUser(Integer.parseInt(String.valueOf(idet.getText())));
            }
        });

    }
        private void registerUsers(String name, String email ) {
            APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
            Call<User> call=apiInterface.registerUser(name, email);
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if(response.isSuccessful()){
                        startActivity(new Intent(RegisterAndDeletActivity.this,MainActivity.class));
                        Toast.makeText(RegisterAndDeletActivity.this,"new user registered successfully",Toast.LENGTH_SHORT).show();
                    }
                    else { Toast.makeText(RegisterAndDeletActivity.this,"Error in Registering",Toast.LENGTH_SHORT).show();}
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(RegisterAndDeletActivity.this,"failure in Registering",Toast.LENGTH_SHORT).show();
                }
            });


        }
        private void deleteUser(int id ) {
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<User> call=apiInterface.deleteUser(id);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    startActivity(new Intent(RegisterAndDeletActivity.this,MainActivity.class));
                    Toast.makeText(RegisterAndDeletActivity.this,"user Deleted successfully",Toast.LENGTH_SHORT).show();
                }
                else { Toast.makeText(RegisterAndDeletActivity.this,"Error in Deleting",Toast.LENGTH_SHORT).show();}
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(RegisterAndDeletActivity.this,"failure in deleting request",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==100){
            if(resultCode==RESULT_OK){
                ContentResolver cr=this.getContentResolver();
                try {
                    InputStream inputStream=cr.openInputStream(data.getData());
                    String type=getFileExtension(data.getData());
                    sendUploadRequest(getBytes(inputStream),type);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }
    public  void sendUploadRequest(byte[] bytes,String type){
        Random random=new Random();
        int randumNum=random.nextInt(80-65+1)+65;
     APIInterface apiInterface=APIClient.getClient().create(APIInterface.class);
        RequestBody requestBody=RequestBody.create(MediaType.parse("image/*"),bytes);
     MultipartBody.Part file=MultipartBody.Part.createFormData("file",randumNum+"myImage."+type,requestBody);
     Call<UploadResponse> call = apiInterface.upload(file);
     call.enqueue(new Callback<UploadResponse>() {
         @Override
         public void onResponse(Call<UploadResponse> call, Response<UploadResponse> response) {
if(response.isSuccessful()){ Toast.makeText(RegisterAndDeletActivity.this,"image uploaded successfully",Toast.LENGTH_SHORT).show(); }
        else{ Toast.makeText(RegisterAndDeletActivity.this,"error in uploading image",Toast.LENGTH_SHORT).show();}

         }

         @Override
         public void onFailure(Call<UploadResponse> call, Throwable t) {
             Toast.makeText(RegisterAndDeletActivity.this,"failure in upload request",Toast.LENGTH_SHORT).show();

         }
     });

    }
    private  byte[] getBytes(InputStream is)throws IOException{
        ByteArrayOutputStream byteBuff=new ByteArrayOutputStream();
        int buffSize=1024;
        byte[] buff=new byte[buffSize];
        int len=0;
        while ((len=is.read(buff)) != -1){
            byteBuff.write(buff,0,len);
        }
       return byteBuff.toByteArray();
    }
    private  String getFileExtension(Uri uri){
        ContentResolver cr=this.getContentResolver();
        MimeTypeMap mime=MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(uri));
    }
}
