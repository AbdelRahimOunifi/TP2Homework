package com.example.rahimpc.tp2homework;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {

    public ImageView image;
    public TextView name;
    public TextView desc;
    public LinearLayout linearLayout;

    public ViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.imageview_id);
        name = itemView.findViewById(R.id.name_textview);
        desc = itemView.findViewById(R.id.desc_textview);
        linearLayout =itemView.findViewById(R.id.recycleitem_id);


    }
}
