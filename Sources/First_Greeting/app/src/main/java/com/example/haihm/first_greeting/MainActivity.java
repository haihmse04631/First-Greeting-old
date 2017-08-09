package com.example.haihm.first_greeting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ImageButton btnLoginFacebook, btnLoginGmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        btnLoginFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FirstGreetingMain.class);
                startActivity(intent);
            }
        });

        btnLoginGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FirstGreetingMain.class);
                startActivity(intent);
            }
        });

    }

    void AnhXa(){
        btnLoginFacebook = (ImageButton) findViewById(R.id.btnLoginWithFacebook);
        btnLoginGmail = (ImageButton) findViewById(R.id.btnLoginWithGmail);
    }


}
