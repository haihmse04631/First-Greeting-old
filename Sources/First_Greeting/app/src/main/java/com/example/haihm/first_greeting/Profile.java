package com.example.haihm.first_greeting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by haihm on 8/8/2017.
 */

public class Profile extends Fragment {

     Button btnLogOut;
     TextView tvUserName;
     ImageView imgCover, imgAvatar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.profile_tab, container, false);

        btnLogOut = (Button) rootView.findViewById(R.id.btnLogOut);
        tvUserName = (TextView) rootView.findViewById(R.id.tvUserName);
        imgAvatar = (ImageView) rootView.findViewById(R.id.imgAvatar);
        imgCover = (ImageView) rootView.findViewById(R.id.imgCover);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return rootView;
    }
}

