package com.example.rahimpc.tp2homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class  MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    AutoCompleteTextView autoCompleteTextView;
    RecyclerView recyclerView;
    String [] name={
            "user1",
            "user2",
            "user3",
            "user4",
            "user5",
            "user6",
            "user7",
            "user8",
            "user9",
            "user10",
    };
    String [] desc={
            "desc1",
            "desc2",
            "desc3",
            "desc4",
            "desc5",
            "desc6",
            "desc7",
            "desc8",
            "desc9",
            "desc10",
    };
    int [] img={
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image1,
            R.drawable.image2,
    };
    String [] sexe={
            "HOMME",
            "FEMME",
            "HOMME",
            "HOMME",
            "FEMME",
            "HOMME",
            "FEMME",
            "FEMME",
            "HOMME",
            "FEMME",
    };
    String [] num={
            "29553025",
            "97709800",
            "97278915",
            "51819614",
            "52178587",
            "29553025",
            "97709800",
            "97278915",
            "51819614",
            "52178587",
    };
    String [] Email={
            "AbdelRahim.ounifi@gmail.com",
            "AbdelRahim.ounifi@gmail.com",
            "AbdelRahim.ounifi@gmail.com",
            "AbdelRahim.ounifi@gmail.com",
            "AbdelRahim.ounifi@gmail.com",
            "AbdelRahim.ounifi@gmail.com",
            "AbdelRahim.ounifi@gmail.com",
            "AbdelRahim.ounifi@gmail.com",
            "AbdelRahim.ounifi@gmail.com",
            "AbdelRahim.ounifi@gmail.com",
    };
    String [] loc={
            "Tunis",
            "Souse",
            "Tabarka",
            "Ras el Jbal",
            "Tunis",
            "Souse",
            "Tabarka",
            "Ras el Jbal",
            "Tabarka",
            "Ras el Jbal",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        autoCompleteTextView= findViewById(R.id.autocompletetext);
        recyclerView = findViewById(R.id.recycleview);
        ArrayAdapter<String> thename = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_dropdown_item_1line,name);
        autoCompleteTextView.setAdapter(thename);

        final List<User> sampleusers = new ArrayList<>();
        for ( int i=0; i<name.length;i++){
            User user=new User();
            user.username=name[i];
            user.userdesc=desc[i];
            user.email=Email[i];
            user.num=num[i];
            user.sexe=sexe[i];
            user.location=loc[i];
            if(user.sexe=="HOMME"){
                user.userimg=R.drawable.image1;
            }
            else{
                user.userimg=R.drawable.image2;
            }

            sampleusers.add(user);
        }
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new RecyclerAdapter(getBaseContext(),sampleusers));
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<User> sampleusers0= new ArrayList<>();
                if(position==0){
                    sampleusers0.add(sampleusers.get(0));
                }
                else if(position==1){
                    sampleusers0.add(sampleusers.get(1));
                }
                else if(position==2){
                    sampleusers0.add(sampleusers.get(2));
                }
                else if(position==3){
                    sampleusers0.add(sampleusers.get(3));
                }
                else if(position==4){
                    sampleusers0.add(sampleusers.get(4));
                }
                else if(position==5){
                    sampleusers0.add(sampleusers.get(5));
                }
                else if(position==6){
                    sampleusers0.add(sampleusers.get(6));
                }
                else if(position==7){
                    sampleusers0.add(sampleusers.get(7));
                }
                else if(position==8){
                    sampleusers0.add(sampleusers.get(8));
                }
                else if(position==9){
                    sampleusers0.add(sampleusers.get(9));
                }
                else {
                    sampleusers0=sampleusers;
                }
                recyclerView.setAdapter(new RecyclerAdapter(getBaseContext(),sampleusers0));
            }
        });
    }
}
