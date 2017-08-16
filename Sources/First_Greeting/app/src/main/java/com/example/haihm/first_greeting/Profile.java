package com.example.haihm.first_greeting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

<<<<<<< HEAD
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
=======
import com.facebook.login.LoginManager;
>>>>>>> 6cebd0f48573dd45991704f76ca8723606196419
import com.squareup.picasso.Picasso;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by haihm on 8/8/2017.
 */

public class Profile extends Fragment {

    Button btnLogOut;
    TextView tvUserName;
    ImageView imgCover, imgAvatar;
<<<<<<< HEAD

    private GoogleApiClient mGoogleApiClient;
    int RC_SIGN_IN = 001;
=======
    Bundle bund;

    public Profile(Bundle bund) {
        this.bund = bund;
    }
>>>>>>> 6cebd0f48573dd45991704f76ca8723606196419

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.profile_tab, container, false);

        btnLogOut = (Button) rootView.findViewById(R.id.btnLogOut);
        tvUserName = (TextView) rootView.findViewById(R.id.tvUserName);
        imgAvatar = (ImageView) rootView.findViewById(R.id.imgAvatar);
        imgCover = (ImageView) rootView.findViewById(R.id.imgCover);

<<<<<<< HEAD

//        String name = getIntent().getStringExtra("Name");
//        tvUserName.setText(name);
//        String url = getIntent().getStringExtra("URLIMAGE");
//        Picasso.with(this).load(url).into(imgAvatar);
=======
        tvUserName.setText(bund.getString("fbName"));
        String fbImage = bund.getString("fbImage");
        Picasso.with(getApplicationContext()).load(fbImage).into(imgAvatar);
        String fbCover = bund.getString("fbCover");
        Picasso.with(getApplicationContext()).load(fbCover).into(imgCover);
>>>>>>> 6cebd0f48573dd45991704f76ca8723606196419

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
                signOut();
=======
                LoginManager.getInstance().logOut();
                // Edit here to move back the login screen
>>>>>>> 6cebd0f48573dd45991704f76ca8723606196419
            }
        });

        return rootView;
    }
<<<<<<< HEAD



    // logout
    private void signOut() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        // ...
                    }
                });
    }
=======
>>>>>>> 6cebd0f48573dd45991704f76ca8723606196419
}

