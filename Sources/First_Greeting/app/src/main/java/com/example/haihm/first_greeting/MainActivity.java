package com.example.haihm.first_greeting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
<<<<<<< HEAD
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.squareup.picasso.Picasso;

=======
import android.widget.ImageView;


import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;
>>>>>>> 6cebd0f48573dd45991704f76ca8723606196419
import org.w3c.dom.Text;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    ImageButton btnLoginGmail;

    LoginButton btnLoginFacebook;
    CallbackManager callbackManager;
    AccessToken accessToken;
    String fbId, fbEmail, fbName, fbImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        AnhXa();
        checkFacebookLogin();

        btnLoginGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FirstGreetingMain.class);
                startActivity(intent);
            }
        });

<<<<<<< HEAD
        btnLoginGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
                Intent intent = new Intent(MainActivity.this, FirstGreetingMain.class);
                startActivity(intent);
            }
        });
=======
    }
>>>>>>> 6cebd0f48573dd45991704f76ca8723606196419

    void AnhXa() {
        btnLoginGmail = (ImageButton) findViewById(R.id.btnLoginWithGmail);
    }

    //Check login already or not
    void checkFacebookLogin() {
        btnLoginFacebook = (LoginButton) findViewById(R.id.btnLoginFacebook);
        callbackManager = CallbackManager.Factory.create();
        if (com.facebook.AccessToken.getCurrentAccessToken() != null) {
            Intent intent = new Intent(MainActivity.this, LoginWithFacebook.class);
            startActivity(intent);
        } else {
            processLogin();
        }
    }

    // Proccessing login by facebook account
    public void processLogin() {
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        //Login successed. Move to LoginWithFacebook.class
                        checkFacebookLogin();
                        Intent intent = new Intent(MainActivity.this, LoginWithFacebook.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException exception) {

                    }
                });
    }

<<<<<<< HEAD
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

=======
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

>>>>>>> 6cebd0f48573dd45991704f76ca8723606196419
}
