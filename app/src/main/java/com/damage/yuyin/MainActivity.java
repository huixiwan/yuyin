package com.damage.yuyin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private Button mBtnStart;
    private Button mBtnStart2;
    private Button mBtnSet;
    private Button mBtnTeam;
    private Button mBtnExit;
    private Button mBtnTest;
    private Button mBtnTest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListeners();
    }

    private void findViews(){
        mBtnStart = (Button) findViewById(R.id.btn_start);
        mBtnStart2 = (Button) findViewById(R.id.btn_start2);
        mBtnSet = (Button) findViewById(R.id.btn_set);
        mBtnTeam = (Button) findViewById(R.id.btn_team);
        mBtnExit = (Button) findViewById(R.id.btn_exit);
        mBtnTest = (Button) findViewById(R.id.btn_test);
        mBtnTest2 = (Button) findViewById(R.id.btn_test2);
    }

    private void setListeners() {
        OnClick onClick = new OnClick();
        mBtnStart.setOnClickListener(onClick);
        mBtnStart2.setOnClickListener(onClick);
        mBtnSet.setOnClickListener(onClick);
        mBtnTeam.setOnClickListener(onClick);
        mBtnExit.setOnClickListener(onClick);
        mBtnTest.setOnClickListener(onClick);
        mBtnTest2.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{
        public void onClick(View v){
            Intent intent=null;
            switch (v.getId()){
                case R.id.btn_start:
                    intent = new Intent(MainActivity.this,YuYinActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_start2:
                    intent = new Intent(MainActivity.this,TiDaiFaShengActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_set:
                    intent = new Intent(MainActivity.this,SetActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_team:
                    intent = new Intent(MainActivity.this,TeamActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_test:
                    test();
                    break;
                case R.id.btn_exit:
                    showdialog(v);
                    break;
                case R.id.btn_test2:
                    test();
                    break;
            }
        }
    }

    private void test() {

    }

    private DialogInterface.OnClickListener click1=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface arg0,int arg1){
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    };

    private DialogInterface.OnClickListener click2=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface arg0,int arg1) {
            arg0.cancel();
        }
    };

    public void showdialog(View view) {
        //定义一个新的对话框对象
        AlertDialog.Builder alertdialogbuilder=new AlertDialog.Builder(this);
        //设置对话框提示内容
        alertdialogbuilder.setMessage("确定要退出程序吗？");
        //定义对话框2个按钮标题及接受事件的函数
        alertdialogbuilder.setPositiveButton("确定",click1);
        alertdialogbuilder.setNegativeButton("取消",click2);
        //创建并显示对话框
        AlertDialog alertdialog1=alertdialogbuilder.create();
        alertdialog1.show();
    }
}
