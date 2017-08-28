package com.example.haihm.first_greeting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    LoginButton btnLoginFacebook;
    CallbackManager callbackManager;
    String fbId, fbName, fbImage, fbCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        btnLoginFacebook = (LoginButton) findViewById(R.id.btnLoginFacebook);
        callbackManager = CallbackManager.Factory.create();

        checkFacebookLogin();

    }

    public void transfer() {
        Intent intent = new Intent(MainActivity.this, FirstGreetingMain.class);
        Bundle bund = new Bundle();
        bund.putString("fbName", fbName);
        bund.putString("fbImage", fbImage);
        bund.putString("fbCover", fbCover);
        intent.putExtra("MyPackage", bund);
        System.out.println("transfer");
        startActivity(intent);
    }

    // Get facebook data
    public void loadData() {
        Bundle params = new Bundle();
        params.putString("fields", "id,name,email,picture.type(large),cover");
        GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequest(AccessToken.getCurrentAccessToken(), "me", params, HttpMethod.GET,
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {
                        if (response != null) {
                            String userDetail = response.getRawResponse();
                            try {
                                JSONObject jsonObject = new JSONObject(userDetail);
                                System.out.println("jsonObject::" + jsonObject);
                                fbId = jsonObject.getString("id");
                                fbName = jsonObject.getString("name");
                                fbImage = "https://graph.facebook.com/" + fbId + "/picture?type=large";

                                if (jsonObject.has("cover")) {
                                    String getInitialCover = jsonObject.getString("cover");

                                    if (getInitialCover.equals("null")) {
                                        jsonObject = null;
                                    } else {
                                        JSONObject JOCover = jsonObject.optJSONObject("cover");

                                        if (JOCover.has("source")) {
                                            fbCover = JOCover.getString("source");
                                        } else {
                                            fbCover = null;
                                        }
                                    }
                                } else {
                                    fbCover = null;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        transfer();
                    }
                }).executeAsync();
    }


    //Check login already or not
    void checkFacebookLogin() {
        if (com.facebook.AccessToken.getCurrentAccessToken() != null) {
            loadData();
        } else {
//            Intent intent = new Intent(MainActivity.this, FirstGreetingMain.class);
//            startActivity(intent);
            processLogin();
        }
    }

        public void processLogin() {
            LoginManager.getInstance().registerCallback(callbackManager,
                    new FacebookCallback<LoginResult>() {
                        @Override
                        public void onSuccess(LoginResult loginResult) {
                            //Login successed. Move to LoginWithFacebook.class
                            //checkFacebookLogin();
//                            Intent intent = new Intent(MainActivity.this, FirstGreetingMain.class);
//                            startActivity(intent);
                        }

                        @Override
                        public void onCancel() {

                        }

                        @Override
                        public void onError(FacebookException error) {

                        }

                    });

        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        checkFacebookLogin();
    }


}
