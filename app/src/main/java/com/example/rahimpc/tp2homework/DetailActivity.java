package com.example.rahimpc.tp2homework;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    de.hdodenhof.circleimageview.CircleImageView img;
    TextView name;
    TextView desc;
    TextView loc;
    String user_num;
    String user_email;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String user_name = getIntent().getStringExtra("name");
        String user_desc = getIntent().getStringExtra("desc");
        user_num = getIntent().getStringExtra("num");
        user_email = getIntent().getStringExtra("email");
        String user_location = getIntent().getStringExtra("loc");
        int user_img = getIntent().getIntExtra("img",0);

        img= findViewById(R.id.profile);
        name=findViewById(R.id.name);
        desc=findViewById(R.id.location);
        loc = findViewById(R.id.loc);

        img.setImageResource(user_img);
        name.setText(user_name);
        desc.setText(user_desc);
        loc.setText(user_location);
    }
    public void retour(View view) {
        finish();
    }
    public void call(View view){
        Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", user_num, null));
        startActivity(intentCall);
    }
    public void email(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Email to the Support");
        intent.putExtra(Intent.EXTRA_TEXT, "Write your problem");
        intent.setData(Uri.parse("mailto:"+user_email));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); startActivity(intent);
    }
}
