package com.example.rahimpc.tp2homework;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<User> users;
    private Context context;


    public RecyclerAdapter(Context context,List<User> users){
        this.users=users;
        this.context=context;
    };

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
    final User sampleuser= users.get(position);

    holder.name.setText(sampleuser.username);
    holder.desc.setText((sampleuser.userdesc));
    holder.image.setImageResource(sampleuser.userimg);
    holder.linearLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(context,"item N^ "+position,Toast.LENGTH_SHORT).show();
            Intent detail= new Intent(context,DetailActivity.class);
            detail.putExtra("name",sampleuser.username);
            detail.putExtra("desc",sampleuser.userdesc);
            detail.putExtra("img",sampleuser.userimg);
            detail.putExtra("num",sampleuser.num);
            detail.putExtra("email",sampleuser.email);
            detail.putExtra("loc",sampleuser.location);
            detail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(detail);
        }
    });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
