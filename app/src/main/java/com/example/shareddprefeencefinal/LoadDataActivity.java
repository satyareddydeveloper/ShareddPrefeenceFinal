package com.example.shareddprefeencefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoadDataActivity extends AppCompatActivity {
    TextView usernametzt,passtext;
    Button loaddata ,previous;
    public static final String Defu = "?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_data);
        usernametzt=findViewById(R.id.txrusername);
        passtext=findViewById(R.id.txtpassword);
        loaddata=findViewById(R.id.button);
        previous= findViewById(R.id.btnprevious);
        loaddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref =
                        getSharedPreferences("MyPref", MODE_PRIVATE);

                // 0 - for private mode
              String username=  pref.getString("name",Defu);
             String pasword=   pref.getString("password",Defu);
                if (username.equals(Defu)||pasword.equals(Defu)){
                    Toast.makeText(getApplicationContext(),"no data inserted",Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(getApplicationContext(),"successfully inserted",Toast.LENGTH_SHORT).show();
                    usernametzt.setText(username);
                    passtext.setText(pasword);
                }


            }
        });
    }

    public void gotoPrevious(View view) {
        Intent intent= new Intent(LoadDataActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
