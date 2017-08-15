package com.example.haihm.first_greeting;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private ImageButton btnLoginFacebook, btnLoginGmail;

    private GoogleApiClient mGoogleApiClient;
    int RC_SIGN_IN = 001;

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
                signIn();
//                Intent intent = new Intent(MainActivity.this, FirstGreetingMain.class);
//                startActivity(intent);
            }
        });

        // Yêu cầu người dùng cung cấp các thông tin cơ bản của người dùng như
        // Email, tên, hình ảnh
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Kết nối với google api clinet
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
//        SignInButton signInButton = (SignInButton) findViewById(R.id.btnLoginWithGmail);
//        signInButton.setSize(SignInButton.SIZE_STANDARD);


    }

    void AnhXa(){
        btnLoginFacebook = (ImageButton) findViewById(R.id.btnLoginWithFacebook);
        btnLoginGmail = (ImageButton) findViewById(R.id.btnLoginWithGmail);
    }


    // khi kết nời fail thì sẽ in ra cái này thông báo cho người dùng biết
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d("Failed ", connectionResult +"");
    }

    // function sign-in khi đăng nhập thành công
    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
        Log.d("Success", mGoogleApiClient.isConnected()+"");
//        Intent intent = new Intent(MainActivity.this, FirstGreetingMain.class);
//        startActivity(intent);
    }
}
