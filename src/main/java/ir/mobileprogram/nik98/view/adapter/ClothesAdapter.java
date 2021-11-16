package ir.mobileprogram.nik98.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.mobileprogram.nik98.R;
import ir.mobileprogram.nik98.view.datamodel.Cloth;


public class ClothesAdapter extends RecyclerView.Adapter<ClothesAdapter.ClothesViewHolder> {

    private Context context;
    private List<Cloth> clothes;

    public ClothesAdapter(Context context , List<Cloth> clothes){


        this.context = context;
        this.clothes = clothes;
    }
    @NonNull
    @Override
    public ClothesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(context).inflate(R.layout.layout_clothing_item,parent,false);
        return new ClothesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClothesViewHolder holder, int position) {
      Cloth cloth=clothes.get(position);
       holder.clothImage.setImageDrawable(cloth.getImage());
       holder.clothTitle.setText(cloth.getTitle());
       holder.clothViewCount.setText(String.valueOf(cloth.getViewCount()));

    }

    @Override
    public int getItemCount() {
        return clothes.size();
    }

    public class ClothesViewHolder extends RecyclerView.ViewHolder {
    private  ImageView clothImage;
    private  TextView  clothTitle;
    private  TextView  clothViewCount;
    public ClothesViewHolder(@NonNull View itemView) {
        super(itemView);
        clothImage=(ImageView)itemView.findViewById(R.id.clothing_image);
        clothTitle=(TextView)itemView.findViewById(R.id.clothing_title);
        clothViewCount=(TextView)itemView.findViewById(R.id.clothing_viewCount_text);
    }
  }
}
