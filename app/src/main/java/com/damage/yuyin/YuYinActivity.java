package com.damage.yuyin;


import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;

public class YuYinActivity extends AppCompatActivity {

    private Button mAnJianG;
    private Button mAnJianK;
    private Button mAnJianH;
    private Button mAnJianJ;
    private Button mAnJianQ;
    private Button mAnJianX;
    private Button mAnJianB;
    private Button mAnJianP;
    private Button mAnJianF;
    private Button mAnJianD;
    private Button mAnJianT;
    private Button mAnJianL;
    private Button mAnJianZh;
    private Button mAnJianCh;
    private Button mAnJianSh;
    private Button mAnJianZ;
    private Button mAnJianC;
    private Button mAnJianS;
    private Button mAnJianR;
    private Button mAnJianM;
    private Button mAnJianN;
    private Button mAnJianY;
    private Button mAnJianW;
    private Button mAnJianA;
    private Button mAnJianO;
    private Button mAnJianE;
    private Button mAnJianI;
    private Button mAnJianU;
    private Button mAnJianV;
    private Button mAnJianN2;
    private Button mAnJianNg;
    private Button mAnJian1;
    private Button mAnJian2;
    private Button mAnJian3;
    private Button mAnJian4;
    private Button mAnJian5;
    private Button mBtnStart;
    private EditText mEtInput;

    private Button mBtnBack;

    MediaPlayer mMediaPlayer;
    private int current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yu_yin);
        findViews();
        setListeners();
    }

    private void findViews(){
        mAnJianG = (Button) findViewById(R.id.anjian_g);
        mAnJianK = (Button) findViewById(R.id.anjian_k);
        mAnJianH = (Button) findViewById(R.id.anjian_h);
        mAnJianJ = (Button) findViewById(R.id.anjian_j);
        mAnJianQ = (Button) findViewById(R.id.anjian_q);
        mAnJianX = (Button) findViewById(R.id.anjian_x);
        mAnJianB = (Button) findViewById(R.id.anjian_b);
        mAnJianP = (Button) findViewById(R.id.anjian_p);
        mAnJianF = (Button) findViewById(R.id.anjian_f);
        mAnJianD = (Button) findViewById(R.id.anjian_d);
        mAnJianT = (Button) findViewById(R.id.anjian_t);
        mAnJianZh = (Button) findViewById(R.id.anjian_zh);
        mAnJianCh = (Button) findViewById(R.id.anjian_ch);
        mAnJianSh = (Button) findViewById(R.id.anjian_sh);
        mAnJianZ = (Button) findViewById(R.id.anjian_z);
        mAnJianC = (Button) findViewById(R.id.anjian_c);
        mAnJianS = (Button) findViewById(R.id.anjian_s);
        mAnJianR = (Button) findViewById(R.id.anjian_r);
        mAnJianM = (Button) findViewById(R.id.anjian_m);
        mAnJianN = (Button) findViewById(R.id.anjian_n);
        mAnJianY = (Button) findViewById(R.id.anjian_y);
        mAnJianW = (Button) findViewById(R.id.anjian_w);
        mAnJianL = (Button) findViewById(R.id.anjian_l);
        mAnJianA = (Button) findViewById(R.id.anjian_a);
        mAnJianO = (Button) findViewById(R.id.anjian_o);
        mAnJianE = (Button) findViewById(R.id.anjian_e);
        mAnJianI = (Button) findViewById(R.id.anjian_i);
        mAnJianU = (Button) findViewById(R.id.anjian_u);
        mAnJianV = (Button) findViewById(R.id.anjian_v);
        mAnJianN2 = (Button) findViewById(R.id.anjian_n2);
        mAnJianNg = (Button) findViewById(R.id.anjian_ng);
        mAnJian1 = (Button) findViewById(R.id.anjian_1);
        mAnJian2 = (Button) findViewById(R.id.anjian_2);
        mAnJian3 = (Button) findViewById(R.id.anjian_3);
        mAnJian4 = (Button) findViewById(R.id.anjian_4);
        mAnJian5 = (Button) findViewById(R.id.anjian_5);
        mEtInput = (EditText) findViewById(R.id.yuyin_et_input);
        mBtnStart = (Button) findViewById(R.id.yuyin_btn_start);
        mBtnBack = (Button) findViewById(R.id.yuyin_btn_back);
    }

    private void setListeners() {
        OnClick onClick = new OnClick();
        mAnJianG.setOnClickListener(onClick);
        mAnJianK.setOnClickListener(onClick);
        mAnJianH.setOnClickListener(onClick);
        mAnJianJ.setOnClickListener(onClick);
        mAnJianQ.setOnClickListener(onClick);
        mAnJianX.setOnClickListener(onClick);
        mAnJianB.setOnClickListener(onClick);
        mAnJianP.setOnClickListener(onClick);
        mAnJianF.setOnClickListener(onClick);
        mAnJianD.setOnClickListener(onClick);
        mAnJianT.setOnClickListener(onClick);
        mAnJianZh.setOnClickListener(onClick);
        mAnJianCh.setOnClickListener(onClick);
        mAnJianSh.setOnClickListener(onClick);
        mAnJianZ.setOnClickListener(onClick);
        mAnJianC.setOnClickListener(onClick);
        mAnJianS.setOnClickListener(onClick);
        mAnJianR.setOnClickListener(onClick);
        mAnJianM.setOnClickListener(onClick);
        mAnJianN.setOnClickListener(onClick);
        mAnJianY.setOnClickListener(onClick);
        mAnJianW.setOnClickListener(onClick);
        mAnJianL.setOnClickListener(onClick);
        mAnJianA.setOnClickListener(onClick);
        mAnJianO.setOnClickListener(onClick);
        mAnJianE.setOnClickListener(onClick);
        mAnJianI.setOnClickListener(onClick);
        mAnJianU.setOnClickListener(onClick);
        mAnJianV.setOnClickListener(onClick);
        mAnJianN2.setOnClickListener(onClick);
        mAnJianNg.setOnClickListener(onClick);
        mAnJian1.setOnClickListener(onClick);
        mAnJian2.setOnClickListener(onClick);
        mAnJian3.setOnClickListener(onClick);
        mAnJian4.setOnClickListener(onClick);
        mAnJian5.setOnClickListener(onClick);
        mBtnStart.setOnClickListener(onClick);
        mBtnBack.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{
        public void onClick(View v){
            switch (v.getId()){
                case R.id.anjian_g:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianG.getText());
                    break;
                case R.id.anjian_k:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianK.getText());
                    break;
                case R.id.anjian_h:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianH.getText());
                    break;
                case R.id.anjian_j:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianJ.getText());
                    break;
                case R.id.anjian_q:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianQ.getText());
                    break;
                case R.id.anjian_x:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianX.getText());
                    break;
                case R.id.anjian_b:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianB.getText());
                    break;
                case R.id.anjian_p:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianP.getText());
                    break;
                case R.id.anjian_f:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianF.getText());
                    break;
                case R.id.anjian_d:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianD.getText());
                    break;
                case R.id.anjian_t:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianT.getText());
                    break;
                case R.id.anjian_zh:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianZh.getText());
                    break;
                case R.id.anjian_ch:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianCh.getText());
                    break;
                case R.id.anjian_sh:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianSh.getText());
                    break;
                case R.id.anjian_z:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianZ.getText());
                    break;
                case R.id.anjian_c:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianC.getText());
                    break;
                case R.id.anjian_s:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianS.getText());
                    break;
                case R.id.anjian_r:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianR.getText());
                    break;
                case R.id.anjian_m:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianM.getText());
                    break;
                case R.id.anjian_n:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianN.getText());
                    break;
                case R.id.anjian_y:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianY.getText());
                    break;
                case R.id.anjian_w:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianW.getText());
                    break;
                case R.id.anjian_a:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianA.getText());
                    break;
                case R.id.anjian_o:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianO.getText());
                    break;
                case R.id.anjian_e:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianE.getText());
                    break;
                case R.id.anjian_i:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianI.getText());
                    break;
                case R.id.anjian_u:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianU.getText());
                    break;
                case R.id.anjian_v:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianV.getText());
                    break;
                case R.id.anjian_n2:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianN2.getText());
                    break;
                case R.id.anjian_ng:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJianNg.getText());
                    break;
                case R.id.anjian_1:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJian1.getText());
                    break;
                case R.id.anjian_2:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJian2.getText());
                    break;
                case R.id.anjian_3:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJian3.getText());
                    break;
                case R.id.anjian_4:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJian4.getText());
                    break;
                case R.id.anjian_5:
                    mEtInput.setText(mEtInput.getText()+(String)mAnJian5.getText());
                    break;
                case R.id.yuyin_btn_start:
                    yuyin();
                    break;
                case R.id.yuyin_btn_back:
                    Intent intent = new Intent(YuYinActivity.this,MainActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }

    private void yuyin() {
        System.out.println("播放功能");
        current = 0;
        String[] testString = getStringArray();
        if(testString == null){
            Toast ts = Toast.makeText(getBaseContext(),"没有输入",Toast.LENGTH_LONG);
            ts.show();
        }else {
            mBtnStart.setEnabled(false);
            Context context = getApplicationContext();
            mMediaPlayer = MediaPlayer.create(context, getResId(testString[0], R.raw.class));
            mMediaPlayer.start();
            if (testString.length == 1) {
                talkOver();
            } else {
                talkNext();
            }
        }
    }

    private void talkNext() {
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                nextArr();
            }
        });
    }

    private void talkOver() {
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mBtnStart.setEnabled(true);
            }
        });
    }

    private void nextArr(){
        String[] testString2 = getStringArray();
        current=current+1;
        Context context = getApplicationContext();
        mMediaPlayer = MediaPlayer.create(context, getResId(testString2[current], R.raw.class));
        mMediaPlayer.start();
        if(current < testString2.length-1){
            talkNext();
        }else{
            talkOver();
        }
    };

    private String[] getStringArray(){
        String[] stringArray = null;
        if(getTestString() != null){
            stringArray = getTestString().split(getTestReg());
            String restString = getTestString();
            for(int i = 0; i < stringArray.length-1; i++){
                stringArray[i] = restString.substring(0,stringArray[i].length()+1);
                restString = restString.substring(stringArray[i].length());
            }
            stringArray[stringArray.length-1] = restString;
        }
        return stringArray;
    }

    private String getTestString(){
        String testString = null;
        if(!TextUtils.isEmpty(mEtInput.getText())){
            testString = mEtInput.getText().toString();
        }
        return testString;
    }

    private String getTestReg() {
        return "[1-5]";
    }

    public static int getResId(String variableName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(variableName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
