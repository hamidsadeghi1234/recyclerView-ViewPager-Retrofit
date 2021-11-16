package ir.mobileprogram.nik98.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import ir.mobileprogram.nik98.R;
import ir.mobileprogram.nik98.view.activity.UserInfoActivity;
import ir.mobileprogram.nik98.view.datamodel.User;
import ir.mobileprogram.nik98.view.datamodel.UserResponse;
import retrofit2.Response;

public class UsersAdapter extends RecyclerView.Adapter <UsersAdapter.UsersViewHolder>{
    private Context context;
    private List<User> users;

    public UsersAdapter (Context context, List<User> users){
        this.context = context;
        this.users = users;
    }
    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_users,parent,false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, final int position) {
        final User user=users.get(position);
        holder.id.setText(String.valueOf(user.getId()));
        holder.name.setText(user.getName());
        holder.email.setText(user.getEmail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
                Intent intent=new Intent(context, UserInfoActivity.class);
                intent.putExtra("id", user.getId());
            //    intent.putExtra("name", user.getName());
              //  intent.putExtra("email", user.getEmail());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public   class UsersViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView email;
        private TextView id;

        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.users_id_tv);
            email=(TextView)itemView.findViewById(R.id.users_name_tv);
            id=(TextView)itemView.findViewById(R.id.users_email_tv);
        }
    }

}

