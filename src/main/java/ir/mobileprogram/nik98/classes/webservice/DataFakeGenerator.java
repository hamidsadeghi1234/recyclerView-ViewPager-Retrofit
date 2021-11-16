package ir.mobileprogram.nik98.classes.webservice;
import android.content.Context;
import androidx.core.content.res.ResourcesCompat;
import java.util.ArrayList;
import java.util.List;

import ir.mobileprogram.nik98.R;
import ir.mobileprogram.nik98.view.datamodel.Cloth;
import ir.mobileprogram.nik98.view.datamodel.Post;

public class DataFakeGenerator {

    public static  List<Post>  getData(Context context) {
     /*
        List<Post> posts = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            Post post = new Post();
            post.setId(i);
            post.setTitle("لورم ایپسوم چیست");
            post.setContent("لورم ایپسوم یا طرح\u200Cنما (به انگلیسی: Lorem ipsum) به متنی آزمایشی و بی\u200Cمعنی در صنعت چاپ، صفحه\u200Cآرایی و طراحی گرافیک گفته می\u200Cشود. طراح گرافیک از این متن به عنوان عنصری از ترکیب بندی برای پر کردن صفحه و ارایه اولیه شکل ظاهری و کلی طرح سفارش گرفته شده استفاده می نماید، تا از نظر گرافیکی نشانگر چگونگی نوع و اندازه فونت و ظاهر متن باشد. معمولا طراحان گرافیک برای صفحه\u200Cآرایی، نخست از متن\u200Cهای آزمایشی و بی\u200Cمعنی استفاده می\u200Cکنند تا صرفا به مشتری یا صاحب کار خود نشان دهند که صفحه طراحی یا صفحه بندی شده بعد از اینکه متن در آن قرار گیرد چگونه به نظر می\u200Cرسد و قلم\u200Cها و اندازه\u200Cبندی\u200Cها چگونه در نظر گرفته شده\u200Cاست. از آنجایی که طراحان عموما نویسنده متن نیستند و وظیفه رعایت حق تکثیر متون را ندارند و در همان حال کار آنها به نوعی وابسته به متن می\u200Cباشد آنها با استفاده از محتویات ساختگی، صفحه گرافیکی خود را صفحه\u200Cآرایی می\u200Cکنند تا مرحله طراحی و صفحه\u200Cبندی را به پایان برند.");
            post.setDate(" 2 ساعت پیش");

        switch (i){
          case 1: post.setPostImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.a1,null));break;
          case 2: post.setPostImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.a2,null));break;
          case 3: post.setPostImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.a3,null));break;
          case 4: post.setPostImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.a4,null));break;
          case 5: post.setPostImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.a5,null));break;
          case 6: post.setPostImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.a6,null));break; }
          posts.add(post);
        }

        */
        return null;
    }

    public static    List<Cloth>  getClothes (Context context){

        List<Cloth> cloths=new ArrayList<>();
        for (int i=1;i<=6;i++){
         Cloth cloth=new Cloth();
         cloth.setId(i);
         cloth.setTitle("لورم ایپسوم چیست");
         cloth.setViewCount(700);
            switch (i){
                case 1: cloth.setImage(ResourcesCompat.getDrawable(context.getResources(), R.drawable.a1,null));break;
                case 2: cloth.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.a2,null));break;
                case 3: cloth.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.a3,null));break;
                case 4: cloth.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.a4,null));break;
                case 5: cloth.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.a5,null));break;
                case 6: cloth.setImage(ResourcesCompat.getDrawable(context.getResources(),R.drawable.a6,null));break; }
        cloths.add(cloth);
        }
        return cloths;


    }
}
