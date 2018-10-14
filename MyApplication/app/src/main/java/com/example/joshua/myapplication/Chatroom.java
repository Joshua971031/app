package com.example.joshua.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Chatroom extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_chatroom, container, false);
    }
    public void onStart() {
        TextView textView = getView().findViewById(R.id.textchatroom);
        textView.setText("我是第二个视图哦");
        super.onStart();
    }
}
