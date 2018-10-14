package com.example.joshua.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Home home;
    private  Chatroom chatroom;
    private  Individual individual;

    @Override
    //右上角菜单
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    //右上角菜单响应事件
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting_item:
                Intent intent1 = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private FragmentTransaction transaction;
    private FragmentManager fragmentManager;

    // 设置默认进来是tab 显示的页面
    private void setDefaultFragment(){
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content1,new Home());
        transaction.commit();
    }
    //隐藏Fragments
    private void hideFragments(FragmentTransaction transaction)
    {
        if (home != null){
            transaction.hide(home);
        }
        if (chatroom != null){
            transaction.hide(chatroom);
        }
        if (individual != null){
            transaction.hide(individual);
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            hideFragments(transaction);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if (home == null) {
                        home = new Home();
                        transaction.add(R.id.content1, home);
                    }
                    else {
                        transaction.show(home);
                    }
                    transaction.commit();
                    return true;
                case R.id.navigation_chatroom:
                    if (chatroom == null) {
                        chatroom = new Chatroom();
                        transaction.add(R.id.content1, chatroom);
                    }
                    else {
                        transaction.show(chatroom);
                    }
                    transaction.commit();
                    return true;
                case R.id.navigation_individual:
                    if (individual == null) {
                        individual = new Individual();
                        transaction.add(R.id.content1, individual);
                    }
                    else {
                        transaction.show(individual);
                    }
                    transaction.commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
