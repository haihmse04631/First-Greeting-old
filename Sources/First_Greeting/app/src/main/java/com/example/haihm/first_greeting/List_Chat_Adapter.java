package com.example.haihm.first_greeting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by haihm on 8/11/2017.
 */

public class List_Chat_Adapter extends BaseAdapter {

    Chat context;
    int layout;
    List<List_Chat> list_chatList;

    public List_Chat_Adapter(Chat context, int layout, List<List_Chat> list_chatList) {
        this.context = context;
        this.layout = layout;
        this.list_chatList = list_chatList;
    }

    @Override
    public int getCount() {
        return list_chatList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getLayoutInflater(context.getArguments());

        convertView = inflater.inflate(layout, null);

        //ánh xạ convertView

        TextView txtName = (TextView) convertView.findViewById(R.id.tvName);
        ImageView imgAvatar = (ImageView) convertView.findViewById(R.id.imageAvatar);

        List_Chat listChat = list_chatList.get(position);

        txtName.setText(listChat.getName());
        imgAvatar.setImageResource(listChat.getAvatar());

        return convertView;
    }
}
