package com.example.shareddprefeencefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,paassword;
    Button savedata,next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.edtusername);
        paassword=findViewById(R.id.edtpaassword);
        savedata=findViewById(R.id.btnsavedata);
        next=findViewById(R.id.btnnextt);
        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences pref = getSharedPreferences("MyPref", MODE_PRIVATE); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("name",username.getText().toString());
                editor.putString("password",paassword.getText().toString());
                editor.commit();
                Toast.makeText(getApplicationContext(),"inserted",Toast.LENGTH_SHORT).show();



            }
        });
    }

    public void gotoNextAct(View view) {
        Intent intent= new Intent(MainActivity.this,LoadDataActivity.class);
        startActivity(intent);
    }
}
