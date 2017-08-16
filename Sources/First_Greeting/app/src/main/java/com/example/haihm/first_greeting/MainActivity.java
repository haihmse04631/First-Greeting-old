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
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.squareup.picasso.Picasso;

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
                Intent intent = new Intent(MainActivity.this, FirstGreetingMain.class);
                startActivity(intent);
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
    }


    // include basic information
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    // lấy thông tin in ra màn hình
    private void handleSignInResult(GoogleSignInResult result) {

        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
//            tvUserName.setText(acct.getEmail().toString());
           // tvUserName.setText(acct.getDisplayName().toString());
            //Picasso.with(this).load(acct.getPhotoUrl()).into(imgAvatar);
            Intent data = new Intent(MainActivity.this, Profile.class);
            data.putExtra("Name",acct.getDisplayName().toString());
            data.putExtra("URLIMAGE",acct.getPhotoUrl());
        } else {

        }
    }

}
