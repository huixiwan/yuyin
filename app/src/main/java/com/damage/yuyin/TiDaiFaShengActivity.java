package com.damage.yuyin;


import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TiDaiFaShengActivity extends AppCompatActivity {

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

    private RadioGroup mRg;

    private Button mBtnQianWord;
    private Button mBtnHouWord;
    private Button mBtnDeleteLetter;
    private Button mBtnDeleteWord;
    private Button mBtnBack;

    MediaPlayer mMediaPlayer;
    private int current;
    private int inputStringPosition;
    private long touchTime = 0;
    private int unitCount = 0;
    private StringBuilder paramStringBuilder;
    private int paramStringBuilderPosition;
    private StringBuilder originalStringBuilder;
    private int originalStringBuilderPosition;
    private List<Integer> paramList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ti_dai_fa_sheng);
        findViews();
        inputStringPosition = 0;
        paramStringBuilderPosition = 0;
        originalStringBuilderPosition = 0;
        paramStringBuilder = new StringBuilder();
        originalStringBuilder = new StringBuilder();
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
        mRg = (RadioGroup) findViewById(R.id.emotion_group);
        mBtnQianWord = (Button) findViewById(R.id.yuyin_btn_qian_word);
        mBtnHouWord = (Button) findViewById(R.id.yuyin_btn_hou_word);
        mBtnDeleteLetter = (Button) findViewById(R.id.yuyin_btn_delete_letter);
        mBtnDeleteWord = (Button) findViewById(R.id.yuyin_btn_delete_word);
        mBtnBack = (Button) findViewById(R.id.yuyin_btn_back);
    }

    private void setListeners() {
        OnClick onClick = new OnClick();
        OnTouch onTouch = new OnTouch();
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
        mBtnQianWord.setOnClickListener(onClick);
        mBtnHouWord.setOnClickListener(onClick);
        mBtnDeleteLetter.setOnClickListener(onClick);
        mBtnDeleteWord.setOnClickListener(onClick);
        mBtnBack.setOnClickListener(onClick);

        mBtnQianWord.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                inputStringPosition=0;
                paramStringBuilderPosition=0;
                originalStringBuilderPosition=0;
                mEtInput.setSelection(inputStringPosition);
                return false;
            }
        });
        mBtnHouWord.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                inputStringPosition=mEtInput.length();
                paramStringBuilderPosition=paramStringBuilder.length();
                originalStringBuilderPosition=originalStringBuilder.length();
                mEtInput.setSelection(inputStringPosition);
                return false;
            }
        });

        mAnJian1.setOnTouchListener(onTouch);

        mAnJian2.setOnTouchListener(onTouch);

        mAnJian3.setOnTouchListener(onTouch);

        mAnJian4.setOnTouchListener(onTouch);

        mAnJian5.setOnTouchListener(onTouch);
    }

    private class OnTouch implements View.OnTouchListener{

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int eventaction = event.getAction();
            switch (eventaction){
                case MotionEvent.ACTION_DOWN:
                    long t1 = System.currentTimeMillis();
                    touchTime = t1;
                    break;
                case MotionEvent.ACTION_UP:
                    long t2 = System.currentTimeMillis();
                    touchTime = t2-touchTime;
                    break;
                    /*
                case MotionEvent.ACTION_CANCEL:
                    long t3 = System.currentTimeMillis();
                    touchTime = t3-touchTime;
                    timeList.add(touchTime);
                    break;
                     */
            }
            return false;
        }
    }

    private class OnClick implements View.OnClickListener{
        public void onClick(View v){
            switch (v.getId()){
                case R.id.anjian_g:
                    inputAnJian(mAnJianG);
                    break;
                case R.id.anjian_k:
                    inputAnJian(mAnJianK);
                    break;
                case R.id.anjian_h:
                    inputAnJian(mAnJianH);
                    break;
                case R.id.anjian_j:
                    inputAnJian(mAnJianJ);
                    break;
                case R.id.anjian_q:
                    inputAnJian(mAnJianQ);
                    break;
                case R.id.anjian_x:
                    inputAnJian(mAnJianX);
                    break;
                case R.id.anjian_b:
                    inputAnJian(mAnJianB);
                    break;
                case R.id.anjian_p:
                    inputAnJian(mAnJianP);
                    break;
                case R.id.anjian_f:
                    inputAnJian(mAnJianF);
                    break;
                case R.id.anjian_d:
                    inputAnJian(mAnJianD);
                    break;
                case R.id.anjian_t:
                    inputAnJian(mAnJianT);
                    break;
                case R.id.anjian_zh:
                    inputAnJian(mAnJianZh);
                    break;
                case R.id.anjian_ch:
                    inputAnJian(mAnJianCh);
                    break;
                case R.id.anjian_sh:
                    inputAnJian(mAnJianSh);
                    break;
                case R.id.anjian_z:
                    inputAnJian(mAnJianS);
                    break;
                case R.id.anjian_c:
                    inputAnJian(mAnJianC);
                    break;
                case R.id.anjian_s:
                    inputAnJian(mAnJianS);
                    break;
                case R.id.anjian_r:
                    inputAnJian(mAnJianR);
                    break;
                case R.id.anjian_m:
                    inputAnJian(mAnJianM);
                    break;
                case R.id.anjian_n:
                    inputAnJian(mAnJianN);
                    break;
                case R.id.anjian_y:
                    inputAnJian(mAnJianY);
                    break;
                case R.id.anjian_w:
                    inputAnJian(mAnJianW);
                    break;
                case R.id.anjian_a:
                    inputAnJian(mAnJianA);
                    break;
                case R.id.anjian_o:
                    inputAnJian(mAnJianO);
                    break;
                case R.id.anjian_e:
                    inputAnJian(mAnJianE);
                    break;
                case R.id.anjian_i:
                    inputAnJian(mAnJianI);
                    break;
                case R.id.anjian_u:
                    inputAnJian(mAnJianU);
                    break;
                case R.id.anjian_v:
                    inputAnJian(mAnJianV);
                    break;
                case R.id.anjian_n2:
                    inputAnJian(mAnJianN2);
                    break;
                case R.id.anjian_ng:
                    inputAnJian(mAnJianNg);
                    break;
                case R.id.anjian_1:
                    inputAnJian(mAnJian1);
                    break;
                case R.id.anjian_2:
                    inputAnJian(mAnJian2);
                    break;
                case R.id.anjian_3:
                    inputAnJian(mAnJian3);
                    break;
                case R.id.anjian_4:
                    inputAnJian(mAnJian4);
                    break;
                case R.id.anjian_5:
                    inputAnJian(mAnJian5);
                    break;
                case R.id.yuyin_btn_start:
                    yuyin();
                    //test();
                    break;
                case R.id.yuyin_btn_qian_word:
                    qianWord();
                    break;
                case R.id.yuyin_btn_hou_word:
                    houWord();
                    break;
                case R.id.yuyin_btn_delete_letter:
                    deleteLetter();
                    break;
                case R.id.yuyin_btn_delete_word:
                    deleteWord();
                    break;
                case R.id.yuyin_btn_back:
                    Intent intent = new Intent(TiDaiFaShengActivity.this,MainActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
/*
    private void test(){
        System.out.println("inputString:"+getTestString());
        System.out.println("inputPosition:"+getInputStringPosition());
        System.out.println("paramString:"+getParamString());
        System.out.println("paramPosition:"+getParamStringBuilderPosition());
        System.out.println("originalString:"+getOriginalString());
        System.out.println("originalPosition:"+getOriginalStringBuilderPosition());
    }
 */
    private void inputAnJian(Button buttonAnJian){
        refreshInput(buttonAnJian);
        refreshParam(buttonAnJian);
        refreshOriginal(buttonAnJian);
    }

    private void refreshInput(Button buttonAnJian){
        int position = getInputStringPosition();
        String inputText = (String)buttonAnJian.getText();
        mEtInput.setText(getTestString().substring(0,position)+inputText+getTestString().substring(position));
        position = position + inputText.length();

        if(isTone(inputText)){
            StringBuilder inputStringParam = new StringBuilder();
            inputStringParam.append("(t:");
            inputStringParam.append(getInputStringTime((int)touchTime));
            inputStringParam.append(";v:");
            inputStringParam.append(getInputStringVolume((int)touchTime));
            inputStringParam.append(")");
            mEtInput.setText(getTestString().substring(0,position)+inputStringParam.toString()+getTestString().substring(position));
            position = position + inputStringParam.length();
        }

        mEtInput.setSelection(position);
        setInputStringPosition(position);
    }

    private String getInputStringTime(int touchTime){
        int vaildTime = getVaildTimeTime(touchTime);
        float timeFloat = (float) vaildTime/1000;
        DecimalFormat df = new DecimalFormat("0.0");
        String timeString = df.format(timeFloat);
        return timeString;
    }

    private int getVaildTimeTime(int touchTime){
        int vaildTime = touchTime;
        if(touchTime > 5000){
            vaildTime = 5000;
        }else if(touchTime < 200){
            vaildTime = 200;
        }
        return vaildTime;
    }

    private String getInputStringVolume(int touchTime){
        int vaildTime = getVaildTimeVolume(touchTime);
        float volumeFloat = (float) vaildTime/1500;
        DecimalFormat df = new DecimalFormat("0.0");
        String volumeString = df.format(volumeFloat);
        return volumeString;
    }

    private int getVaildTimeVolume(int touchTime){
        int vaildTime = touchTime;
        if(touchTime > 1500){
            vaildTime = 1500;
        }else if(touchTime < 300){
            vaildTime = 300;
        }
        return vaildTime;
    }

    private void refreshParam(Button buttonAnJian){
        String inputText = (String)buttonAnJian.getText();
        int paramPosition = getParamStringBuilderPosition();
        paramStringBuilder.insert(paramPosition,inputText);
        paramPosition = paramPosition + inputText.length();

        if(isTone(inputText)){
            paramStringBuilder.insert(paramPosition, '{');
            paramStringBuilder.insert(paramPosition+1, touchTime);
            paramPosition = paramPosition + String.valueOf(touchTime).length() + 1;
            paramStringBuilder.insert(paramPosition, '}');
            paramPosition = paramPosition + 1;
        }

        setParamStringBuilderPosition(paramPosition);
    }

    private void refreshOriginal(Button buttonAnJian){
        String inputText = (String)buttonAnJian.getText();
        int originalPosition = getOriginalStringBuilderPosition();
        originalStringBuilder.insert(originalPosition,inputText);
        originalPosition = originalPosition + inputText.length();
        setOriginalStringBuilderPosition(originalPosition);
    }

    private int getInputStringPosition(){
        return inputStringPosition;
    }

    private int getParamStringBuilderPosition(){
        return paramStringBuilderPosition;
    }

    private int getOriginalStringBuilderPosition(){
        return originalStringBuilderPosition;
    }

    private void setInputStringPosition(int position){
        inputStringPosition = position;
    }

    private void setParamStringBuilderPosition(int paramPosition){
        paramStringBuilderPosition = paramPosition;
    }

    private void setOriginalStringBuilderPosition(int origialPosition){
        originalStringBuilderPosition = origialPosition;
    }

    private void qianWord(){
        qianWordRefreshInput();
        qianWordRefreshParam();
        qianWordRefreshOriginal();
    }

    private void qianWordRefreshInput(){
        String testString = getTestString();
        int position = getInputStringPosition();
        if(position != 0){
            position--;
            while(position > 0 && testString.charAt(position-1) != ')'){
                position--;
            }
        }
        mEtInput.setSelection(position);
        setInputStringPosition(position);
    }

    private void qianWordRefreshParam(){
        int paramPosition = getParamStringBuilderPosition();
        if(paramPosition != 0){
            paramPosition--;
            while(paramPosition > 0 && paramStringBuilder.toString().charAt(paramPosition-1) != '}'){
                paramPosition--;
            }
        }
        setParamStringBuilderPosition(paramPosition);
    }

    private void qianWordRefreshOriginal(){
        String originalString = getOriginalString();
        int originalPosition = getOriginalStringBuilderPosition();
        boolean flag = true;
        boolean firstIntFlag = true;
        while(flag){
            if(originalPosition == 0){
                flag = false;
            }else if(firstIntFlag && originalPosition == 1 && isTone(originalString.charAt(originalPosition-1))){
                originalPosition = 0;
                flag = false;
            }else{
                if(firstIntFlag && isTone(originalString.charAt(originalPosition-1))) {
                    originalPosition--;
                }
                if(isTone(originalString.charAt(originalPosition-1))){
                    flag = false;
                }else{
                    originalPosition--;
                }
            }
            firstIntFlag = false;
        }
        setOriginalStringBuilderPosition(originalPosition);
    }
    
    private void houWord(){
        houWordRefreshInput();
        houWordRefreshParam();
        houWordRefreshOriginal();
    }

    private void houWordRefreshInput(){
        String testString = getTestString();
        int position = getInputStringPosition();
        if(position != testString.length()){
            position++;
            while(position != testString.length() && testString.charAt(position-1) != ')'){
                position++;
            }
        }
        mEtInput.setSelection(position);
        setInputStringPosition(position);
    }

    private void houWordRefreshParam(){
        int paramPosition = getParamStringBuilderPosition();
        if(paramPosition != paramStringBuilder.length()){
            paramPosition++;
            while(paramPosition != paramStringBuilder.length() && paramStringBuilder.toString().charAt(paramPosition-1) != '}'){
                paramPosition++;
            }
        }
        setParamStringBuilderPosition(paramPosition);
    }

    private void houWordRefreshOriginal(){
        String originalString = getOriginalString();
        int originalPosition = getOriginalStringBuilderPosition();
        boolean flag = true;
        while(flag){
            if(originalPosition == originalString.length()){
                flag = false;
            }else{
                if(isTone(originalString.charAt(originalPosition))){
                    flag = false;
                    originalPosition++;
                }else{
                    originalPosition++;
                }
            }
        }
        setOriginalStringBuilderPosition(originalPosition);
    }
    
    private void deleteLetter(){
        deleteLetterRefreshInput();
        deleteLetterRefreshParam();
        deleteLetterRefreshOriginal();
    }

    private void deleteLetterRefreshInput(){
        String testString = getTestString();
        int position = getInputStringPosition();
        int oldPosition = position;
        if(position != 0){
            if(!isTone(testString.charAt(position-1))) {
                position--;
                testString = testString.substring(0, position) + testString.substring(oldPosition);
            }else{
                while(testString.charAt(position-1) != '('){
                    position--;
                }
                position--;
                position--;
                testString = testString.substring(0, position) + testString.substring(oldPosition);
            }
        }
        mEtInput.setText(testString);
        mEtInput.setSelection(position);
        setInputStringPosition(position);
    }

    private void deleteLetterRefreshParam(){
        int paramPosition = getParamStringBuilderPosition();
        if(paramPosition != 0){
            if(!isTone(getParamString().charAt(paramPosition-1))){
                paramStringBuilder.deleteCharAt(paramPosition-1);
                paramPosition--;
            }else{
                int oldParamPosition = paramPosition;
                while (getParamString().charAt(paramPosition - 1) != '{') {
                    paramPosition--;
                }
                paramPosition--;
                paramPosition--;
                paramStringBuilder.delete(paramPosition, oldParamPosition);
            }
        }
        setParamStringBuilderPosition(paramPosition);
    }

    private void deleteLetterRefreshOriginal(){
        int originalPosition = getOriginalStringBuilderPosition();
        int oldOriginalPosition = originalPosition;
        if(originalPosition != 0){
            originalPosition--;
        }
        originalStringBuilder.delete(originalPosition,oldOriginalPosition);
        setOriginalStringBuilderPosition(originalPosition);
    }

    private void deleteWord(){
        deleteWordRefreshInput();
        deleteWordRefreshParam();
        deleteWordRefreshOriginal();
    }

    private void deleteWordRefreshInput(){
        String testString = getTestString();
        int position = getInputStringPosition();
        if(position != 0){
            int oldPosition = position;
            position--;
            while(position > 0 && testString.charAt(position-1) != ')'){
                position--;
            }
            testString = testString.substring(0,position)+testString.substring(oldPosition);
        }
        mEtInput.setText(testString);
        mEtInput.setSelection(position);
        setInputStringPosition(position);
    }

    private void deleteWordRefreshParam(){
        int paramPosition = getParamStringBuilderPosition();
        if(paramPosition != 0){
            int oldParamPosition = paramPosition;
            paramPosition--;
            while(paramPosition > 0 && getParamString().charAt(paramPosition-1) != '}'){
                paramPosition--;
            }
            paramStringBuilder.delete(paramPosition,oldParamPosition);
        }
        setParamStringBuilderPosition(paramPosition);
    }

    private void deleteWordRefreshOriginal(){
        int originalPosition = getOriginalStringBuilderPosition();
        int oldOriginalPosition = originalPosition;
        boolean flag = true;
        boolean firstIntFlag = true;
        while(flag){
            if(originalPosition == 0){
                flag = false;
            }else if(firstIntFlag && originalPosition == 1 && isTone(getOriginalString().charAt(originalPosition-1))){
                originalPosition = 0;
                flag = false;
            }else{
                if(firstIntFlag && isTone(getOriginalString().charAt(originalPosition-1))) {
                    originalPosition--;
                }
                if(isTone(getOriginalString().charAt(originalPosition-1))){
                    flag = false;
                }else{
                    originalPosition--;
                }
            }
            firstIntFlag = false;
        }
        originalStringBuilder = originalStringBuilder.delete(originalPosition,oldOriginalPosition);
        setOriginalStringBuilderPosition(originalPosition);
    }

    private void yuyin() {
        current = 0;
        String[] talkStrings = getStringArray();
        /*
        System.out.println("隐式字符串："+paramStringBuilder.toString());
        System.out.println("隐式字符串指针位置："+paramStringBuilderPosition);
        */
        if(talkStrings == null){
            Toast ts = Toast.makeText(getBaseContext(),"没有输入或仅有音调",Toast.LENGTH_LONG);
            ts.show();
        }else {
            if(!checkInput()){
                Toast ts = Toast.makeText(getBaseContext(),"输入有误或是语音源不足",Toast.LENGTH_LONG);
                ts.show();
                return;
            }
            getAllParam();
            setEmotion();
            mBtnStart.setEnabled(false);
            Context context = getApplicationContext();
            mMediaPlayer = MediaPlayer.create(context, getResId(talkStrings[0], R.raw.class));
            float speed = getSpeed(unitCount);
            float volume = getVolume(unitCount);
            unitCount++;
            setPlayerParam(speed, volume);
            mMediaPlayer.start();
            if (talkStrings.length == 1) {
                talkOver();
            } else {
                talkNext();
            }
        }
    }

    private void getAllParam(){
        String paramString = getParamString();
        int i = 0;
        StringBuilder temp = new StringBuilder();
        while(i < paramString.length()){
            temp.setLength(0);
            if(paramString.charAt(i) == '{'){
                i++;
                while(paramString.charAt(i) != '}'){
                    temp.append(paramString.charAt(i));
                    i++;
                }
                paramList.add(Integer.parseInt(temp.toString()));
            }
            i++;
        }
    }
/*
    private void testOut(){
        for(int t:paramList){
            System.out.println(t);
        }
    }
 */
    private void setEmotion(){
        RadioButton emotionButton = (RadioButton) mRg.findViewById(mRg.getCheckedRadioButtonId());
        switch (emotionButton.getText().toString()){
            case "无":
                setOriginalEmotion();
                break;
            case "开心":
                setHappyEmotion();
                break;
            case "伤心":
                setSadEmotion();
                break;
            case "生气":
                setAngryEmotion();
                break;
            default:
                Toast.makeText(TiDaiFaShengActivity.this,"还未设置的感情",Toast.LENGTH_SHORT).show();
        }
    }

    private void setOriginalEmotion(){

    }

    private void setHappyEmotion(){
        int i = 0;
        for(int t:paramList){
            t = Math.round(t/8*7);
            paramList.set(i,t);
            i++;
        }
    }
    private void setSadEmotion(){
        int i = 0;
        for(int t:paramList){
            t = Math.round(t/4*5);
            paramList.set(i,t);
            i++;
        }
    }
    private void setAngryEmotion(){
        int i = 0;
        for(int t:paramList){
            t = Math.round(t/5*4);
            paramList.set(i,t);
            i++;
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
                unitCount = 0;
                mBtnStart.setEnabled(true);
            }
        });
    }

    private boolean checkInput(){
        String[] testString = getStringArray();
        String[] rawYinYuan={"a1", "a2", "a3", "a4", "ai1", "ai2", "ai3", "ai4", "an1", "an2", "an3",
                "an4", "ang1", "ang2", "ang3", "ang4", "ao1", "ao2", "ao3", "ao4", "ba1", "ba2",
                "ba3", "ba4", "bai1", "bai2", "bai3", "bai4", "ban1", "ban3", "ban4", "bang1",
                "bang3", "bang4", "bao1", "bao2", "bao3", "bao4", "bei1", "bei3", "bei4", "ben1",
                "ben3", "ben4", "beng1", "beng2", "beng4", "bi1", "bi2", "bi3", "bi4", "bian1",
                "bian3", "bian4", "biao1", "biao3", "biao4", "bie1", "bie2", "bie3", "bie4", "bin1",
                "bin4", "bing1", "bing3", "bing4", "bo1", "bo2", "bo3", "bo4", "bu1", "bu2", "bu3",
                "bu4", "ca1", "ca3", "cai1", "cai2", "cai3", "cai4", "can1", "can2", "can3", "can4",
                "cang1", "cang2", "cao1", "cao2", "cao3", "cao4", "ce4", "cen1", "cen2", "ceng1",
                "ceng2", "ceng4", "cha1", "cha2", "cha3", "cha4", "chai1", "chai2", "chai3", "chai4",
                "chan1", "chan2", "chan3", "chan4", "chang1", "chang2", "chang3", "chang4", "chao1",
                "chao2", "chao3", "chao4", "che1", "che3", "che4", "chen1", "chen2", "chen3", "chen4",
                "cheng1", "cheng2", "cheng3", "cheng4", "chi1", "chi2", "chi3", "chi4", "chong1",
                "chong2", "chong3", "chong4", "chou1", "chou2", "chou3", "chou4", "chu1", "chu2",
                "chu3", "chu4", "chuai1", "chuai2", "chuai3", "chuai4", "chuan1", "chuan2", "chuan3",
                "chuan4", "chuang1", "chuang2", "chuang3", "chuang4", "chui1", "chui2", "chun1",
                "chun2", "chun3", "chuo1", "chuo4", "ci1", "ci2", "ci3", "ci4", "cong1", "cong2",
                "cou4", "cu1", "cu2", "cu4", "cuan1", "cuan2", "cuan4", "cui1", "cui3", "cui4",
                "cun1", "cun2", "cun3", "cun4", "cuo1", "cuo2", "cuo3", "cuo4", "da1", "da2", "da3",
                "da4", "dai1", "dai3", "dai4", "dan1", "dan3", "dan4", "dang1", "dang3", "dang4",
                "dango", "dao1", "dao2", "dao3", "dao4", "de1", "de2", "de3", "de4", "den1", "den4",
                "deng4", "di1", "di2", "di3", "di4", "dia1", "dia3", "dian1", "dian3", "dian4",
                "diao1", "diao3", "diao4", "die1", "die2", "die4", "ding1", "ding3", "ding4", "diu1",
                "dong1", "dong2", "dong3", "dong4", "dou1", "dou3", "dou4", "du1", "du2", "du3",
                "du4", "duan1", "duan3", "duan4", "dui1", "dui4", "dun1", "dun3", "dun4", "duo1",
                "duo2", "duo3", "duo4", "e1", "e2", "e3", "e4", "ei1", "ei2", "ei3", "ei4", "en1",
                "en2", "en3", "en4", "eng1", "er1", "er2", "er3", "er4", "fa1", "fa2", "fa3", "fa4",
                "fan1", "fan2", "fan3", "fan4", "fang1", "fang2", "fang3", "fang4", "fei1", "fei2",
                "fei3", "fei4", "fen1", "fen2", "fen3", "fen4", "feng1", "feng2", "feng3", "feng4",
                "fo2", "fou3", "fu1", "fu2", "fu3", "fu4", "ga1", "ga2", "ga3", "ga4", "gai1", "gai3",
                "gai4", "gan1", "gan3", "gan4", "gang1", "gang3", "gang4", "gao1", "gao3", "gao4",
                "ge1", "ge2", "ge3", "gei3", "gen1", "gen3", "geng1", "geng3", "geng4", "gong3",
                "gou1", "gou3", "gou4", "gu1", "gu3", "gu4", "gua1", "gua3", "gua4", "guai1", "guai3",
                "guai4", "guan1", "guan3", "guan4", "guang1", "guang2", "guang3", "guang4", "gui1",
                "gui3", "gui4", "gun2", "gun3", "gun4", "guo1", "guo2", "guo3", "guo4", "ha1", "ha2",
                "ha4", "hai2", "hai3", "hai4", "han1", "han2", "han3", "han4", "hang1", "hang2",
                "hang4", "hao1", "hao2", "hao3", "hao4", "he1", "he2", "he4", "heart", "hei1", "hen2",
                "hen3", "hen4", "heng2", "heng4", "hong1", "hong2", "hong3", "hong4", "hou1", "hou2",
                "hou3", "hou4", "hu1", "hu3", "hu4", "hua1", "hua2", "hua4", "huai2", "huai3",
                "huai4", "huan1", "huan2", "huan3", "huan4", "huang1", "huang2", "huang4", "hui1",
                "hui2", "hui3", "hui4", "hun1", "hun2", "hun4", "huo2", "huo3", "huo4", "ji1", "ji2",
                "ji3", "ji4", "jia1", "jia2", "jia3", "jia4", "jian1", "jian3", "jian4", "jiang1",
                "jiang3", "jiang4", "jiao1", "jiao2", "jiao3", "jiao4", "jie1", "jie2", "jie3",
                "jie4", "jin1", "jin3", "jin4", "jing1", "jing3", "jing4", "jiong3", "jiu1", "jiu3",
                "jiu4", "ju1", "ju2", "ju3", "ju4", "juan1", "juan3", "juan4", "jue2", "jue3",
                "jue4", "jun2", "ka1", "ka3", "kai1", "kai3", "kai4", "kan1", "kan3", "kan4",
                "kang4", "kao1", "kao3", "kao4", "ke1", "ke2", "ke3", "ke4", "ken3", "keng1",
                "kong1", "kong3", "kong4", "kou1", "kou2", "kou3", "kou4", "ku1", "ku3", "ku4",
                "kua1", "kua3", "kua4", "kuai3", "kuai4", "kuan1", "kuan3", "kuang1", "kuang2",
                "kuang3", "kuang4", "kui1", "kui2", "kui3", "kui4", "kun1", "kun3", "kun4", "kuo4",
                "la1", "la2", "la3", "la4", "lai2", "lai4", "lan2", "lan3", "lan4", "lang1", "lang2",
                "lang3", "lang4", "lao1", "lao2", "lao3", "lao4", "le1", "le4", "lei1", "lei2",
                "lei3", "lei4", "leng2", "leng4", "li1", "li2", "li3", "li4", "lian2", "lian3",
                "lian4", "liang2", "liang3", "liang4", "liao1", "liao2", "liao4", "lie3", "lie4",
                "lin2", "lin3", "lin4", "ling1", "ling2", "ling3", "ling4", "list", "liu1", "liu2",
                "liu3", "liu4", "long2", "long3", "long4", "lou1", "lou2", "lou3", "lou4", "lu1",
                "lu2", "lu3", "lu4", "luan2", "luan3", "luan4", "lue4", "lun1", "lun2", "lun4",
                "luo1", "luo2", "luo3", "luo4", "lv2", "lv3", "lv4", "ma1", "ma2", "ma3", "ma4",
                "mai2", "mai3", "mai4", "man1", "man2", "man3", "man4", "mang2", "mang3", "mang4",
                "mao1", "mao2", "mao3", "mao4", "mei2", "mei3", "mei4", "men1", "men2", "men4",
                "meng1", "meng2", "meng3", "meng4", "mi1", "mi2", "mi3", "mi4", "mian2", "mian3",
                "mian4", "miao1", "miao2", "miao3", "miao4", "mie1", "mie4", "min2", "min3", "min4",
                "ming2", "ming3", "ming4", "miu4", "mo1", "mo2", "mo4", "mou2", "mu2", "mu3", "mu4",
                "na1", "na2", "na3", "na4", "nai3", "nai4", "nan1", "nan2", "nan4", "nang1", "nang2",
                "nang4", "nao1", "nao2", "nao3", "nao4", "ne4", "nei3", "nei4", "nen4", "neng2",
                "ni1", "ni2", "ni3", "ni4", "nian1", "nian2", "nian3", "niang2", "niao3", "niao4",
                "nie1", "nie4", "nin2", "ning2", "ning3", "niu1", "niu2", "niu3", "niu4", "nong2",
                "nong4", "nu2", "nu3", "nu4", "nuan3", "nue4", "nuo4", "nv3", "nv4", "o1", "o2",
                "o3", "o4", "ou1", "ou2", "ou3", "ou4", "pa1", "pa2", "pa4", "pai1", "pai2", "pai3",
                "pai4", "pan1", "pan2", "pan4", "pang1", "pang2", "pang4", "pao1", "pao2", "pao3",
                "pao4", "pei1", "pei2", "pei4", "pen1", "pen2", "peng1", "peng2", "peng3", "peng4",
                "pi1", "pi2", "pi3", "pi4", "pian1", "pian2", "pian3", "pian4", "piao1", "piao2",
                "piao3", "piao4", "pie1", "pie3", "pie4", "pin1", "pin2", "pin3", "pin4", "ping1",
                "ping2", "po1", "po2", "po3", "po4", "pou1", "pou2", "pou3", "pu1", "pu2", "pu3",
                "pu4", "qi1", "qi2", "qi3", "qi4", "qia1", "qia2", "qia3", "qia4", "qian1", "qian2",
                "qian3", "qian4", "qiang1", "qiang2", "qiang3", "qiang4", "qiao1", "qiao2", "qiao3",
                "qiao4", "qie1", "qie2", "qie3", "qie4", "qin1", "qin2", "qin3", "qin4", "qing1",
                "qing2", "qing3", "qing4", "qiong2", "qiu1", "qiu2", "qiu3", "qu1", "qu2", "qu3",
                "qu4", "quan1", "quan2", "quan3", "quan4", "que1", "que2", "que4", "qun2", "qun4",
                "ran2", "ran3", "rang1", "rang3", "rang4", "rao2", "rao3", "rao4", "re3", "ren2",
                "ren3", "ren4", "reng1", "reng2", "ri1", "ri2", "ri3", "ri4", "rong2", "rong3",
                "rou2", "ru2", "ru3", "ru4", "ruan3", "rui2", "rui3", "rui4", "ruo4", "sa1", "sa3",
                "sa4", "sai1", "sai4", "san1", "san3", "san4", "sang1", "sang3", "sang4", "sao1",
                "sao3", "sao4", "se4", "sen1", "sen4", "seng1", "sha1", "sha3", "sha4", "shai1",
                "shai3", "shai4", "shan1", "shan3", "shan4", "shang1", "shang3", "shang4", "shao1",
                "shao2", "shao3", "shao4", "she1", "she2", "she3", "she4", "shen1", "shen2",
                "shen3", "shen4", "sheng1", "sheng2", "sheng3", "sheng4", "shi1", "shi2", "shi3",
                "shi4", "shou1", "shou2", "shou3", "shou4", "shu1", "shu2", "shu3", "shu4", "shua1",
                "shua3", "shuai1", "shuai3", "shuai4", "shuan1", "shuan4", "shuang1", "shuang3",
                "shui2", "shui3", "shui4", "shun3", "shun4", "shuo1", "shuo4", "si1", "si2", "si3",
                "si4", "song1", "song2", "song3", "song4", "sou1", "sou3", "sou4", "su1", "su2",
                "su4", "suan1", "suan4", "sui1", "sui2", "sui3", "sui4", "sun1", "sun3", "suo1",
                "suo3", "ta1", "ta3", "ta4", "tai1", "tai2", "tai4", "tan1", "tan2", "tan3", "tan4",
                "tang1", "tang2", "tang3", "tang4", "tao1", "tao2", "tao3", "tao4", "te4", "ti1",
                "ti2", "ti3", "ti4", "tian1", "tian2", "tian3", "tian4", "tiao1", "tiao2", "tiao3",
                "tiao4", "tie1", "tie2", "tie3", "tie4", "ting1", "ting2", "ting3", "ting4", "tong1",
                "tong2", "tong3", "tong4", "tou1", "tou2", "tou3", "tou4", "tu1", "tu2", "tu3", "tu4",
                "tuan1", "tuan2", "tui1", "tui2", "tui3", "tui4", "tun1", "tun2", "tun3", "tun4",
                "tuo1", "tuo2", "tuo3", "tuo4", "wa1", "wa2", "wa3", "wa4", "wai1", "wai4", "wan1",
                "wan2", "wan3", "wan4", "wang1", "wang2", "wang3", "wang4", "wei1", "wei2", "wei3",
                "wei4", "wen1", "wen2", "wen3", "wen4", "weng1", "wo1", "wo3", "wo4", "wu1", "wu2",
                "wu3", "wu4", "xi1", "xi2", "xi3", "xi4", "xia1", "xia2", "xia4", "xian1", "xian2",
                "xian3", "xian4", "xiang1", "xiang2", "xiang3", "xiang4", "xiao1", "xiao2", "xiao3",
                "xiao4", "xie1", "xie2", "xie3", "xie4", "xin1", "xin2", "xin3", "xin4", "xing1",
                "xing2", "xing3", "xing4", "xiong1", "xiong2", "xiu1", "xiu3", "xiu4", "xu1", "xu2",
                "xu3", "xu4", "xuan1", "xuan2", "xuan3", "xuan4", "xue1", "xue2", "xue3", "xue4",
                "xun1", "xun2", "xun4", "ya1", "ya2", "ya3", "ya4", "yan1", "yan2", "yan3", "yan4",
                "yang1", "yang2", "yang3", "yang4", "yao1", "yao2", "yao3", "yao4", "ye1", "ye2",
                "ye3", "ye4", "yi1", "yi2", "yi3", "yi4", "yin1", "yin2", "yin3", "yin4", "ying1",
                "ying2", "ying3", "ying4", "yo1", "yo4", "yong1", "yong2", "yong3", "yong4", "you1",
                "you2", "you3", "you4", "yu1", "yu2", "yu3", "yu4", "yuan1", "yuan2", "yuan3",
                "yuan4", "yue1", "yue2", "yue3", "yue4", "yun1", "yun2", "yun3", "yun4", "yv1",
                "yv2", "yv3", "yv4", "z", "za1", "za2", "za3", "za4", "zai1", "zai3", "zai4", "zan1",
                "zan2", "zan3", "zan4", "zang1", "zang2", "zang3", "zang4", "zao1", "zao2", "zao3",
                "zao4", "ze2", "ze4", "zei2", "zei3", "zen2", "zen3", "zen4", "zeng1", "zeng4",
                "zha1", "zha2", "zha3", "zha4", "zhai1", "zhai2", "zhai3", "zhai4", "zhan1", "zhan3",
                "zhan4", "zhang1", "zhang2", "zhang3", "zhang4", "zhao1", "zhao2", "zhao3", "zhao4",
                "zhe1", "zhe2", "zhe3", "zhe4", "zhen1", "zhen3", "zhen4", "zheng1", "zheng2",
                "zheng3", "zheng4", "zhi1", "zhi2", "zhi3", "zhi4", "zhong1", "zhong2", "zhong3",
                "zhong4", "zhou1", "zhou2", "zhou3", "zhou4", "zhu1", "zhu2", "zhu3", "zhu4",
                "zhua1", "zhua2", "zhua3", "zhua4", "zhuai1", "zhuai2", "zhuai3", "zhuai4", "zhuan1",
                "zhuan2", "zhuan3", "zhuan4", "zhuang1", "zhuang2", "zhuang3", "zhuang4", "zhui1",
                "zhui2", "zhui3", "zhui4", "zhun1", "zhun2", "zhun3", "zhun4", "zhuo1", "zhuo2",
                "zhuo3", "zhuo4", "zi1", "zi2", "zi3", "zi4", "zong1", "zong2", "zong3", "zong4",
                "zou1", "zou2", "zou3", "zou4", "zu1", "zu2", "zu3", "zu4", "zuan1", "zuan3", "zuan4",
                "zui1", "zui3", "zui4", "zun1", "zun3", "zun4", "zuo1", "zuo2", "zuo3", "zuo4" };
        boolean flag = false;
        boolean earlyOutFlag = false;
        int count = 0;
        int count2 = 0;
        for (String string:testString) {
            for (String yin:rawYinYuan) {
                count2++;
                if(string.equals(yin)) {
                    count++;
                    break;
                }
                if(rawYinYuan.length == count2  && (!string.equals(yin))){
                    earlyOutFlag = true;
                }
            }
            if(earlyOutFlag){
                break;
            }
            count2 = 0;
        }
        if(count == testString.length){
            flag = true;
        }
        return flag;
    }

    private void nextArr(){
        String[] testString2 = getStringArray();
        current=current+1;
        Context context = getApplicationContext();
        mMediaPlayer = MediaPlayer.create(context, getResId(testString2[current], R.raw.class));
        float speed = getSpeed(unitCount);
        float volume = getVolume(unitCount);
        unitCount++;
        setPlayerParam(speed, volume);
        mMediaPlayer.start();
        if(current < testString2.length-1){
            talkNext();
        }else{
            talkOver();
        }
    };

    private String[] getStringArray(){
        String[] stringArray = null;
        if(!getTestString().equals("")){
            stringArray = getOriginalString().split(getTestReg());
            String restString = getOriginalString();
            for(int i = 0; i < stringArray.length-1; i++){
                stringArray[i] = restString.substring(0,stringArray[i].length()+1);
                restString = restString.substring(stringArray[i].length());
            }
            if(stringArray.length-1 < 0){
                stringArray = null;
            }else {
                stringArray[stringArray.length - 1] = restString;
            }
        }
        return stringArray;
    }

    private String getTestString(){
        String testString = "";
        if(!TextUtils.isEmpty(mEtInput.getText())){
            testString = mEtInput.getText().toString();
        }
        return testString;
    }

    private String getParamString(){
        return paramStringBuilder.toString();
    }

    private String getOriginalString(){
        return originalStringBuilder.toString();
    }

    private String getTestReg() {
        return "[1-5]";
    }

    private void setPlayerSpeed(float speed){
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.M) {
            PlaybackParams playbackParams = mMediaPlayer.getPlaybackParams();
            playbackParams.setSpeed(speed);
            mMediaPlayer.setPlaybackParams(playbackParams);
        }
    }

    private float getSpeed(int i){
        int touchTime = getTouchtime(i);
        int touchValue = getVaildTimeTime(touchTime);
        try {
            float speed = (float)1000/(touchValue);
            return speed;
        }catch (Exception e){
            //这部分仅作内部测试，所以不做后续处理了。
            Toast.makeText(getApplicationContext(),"输入有误",Toast.LENGTH_LONG).show();
            return (float)1.0;
        }
    }

    private void setPlayerVolume(float volume){
        mMediaPlayer.setVolume(volume,volume);//此法只能用于向下调音量
    }

    private float getVolume(int i){
        int touchTime = getTouchtime(i);
        int touchValue = getVaildTimeVolume(touchTime);
        try {
            float volume = (float)(touchValue)/1500;
            return volume;
        }catch (Exception e){
            //这部分仅作内部测试，所以不做后续处理了。
            Toast.makeText(getApplicationContext(),"输入有误",Toast.LENGTH_LONG).show();
            return (float)1.0;
        }
    }

    private int getTouchtime(int unitCount){
        /*
        int i = 0;
        int start;
        int end;
        int num_k = unitCount;
        int k = 0;
        while(k != num_k+1){
            if(paramStringBuilder.charAt(i) == '{'){
                k++;
            }
            i++;
        }
        start = i-1;
        while(paramStringBuilder.charAt(i) != '}'){
            i++;
        }
        end = i;
        String timeString = paramStringBuilder.toString().substring(start+1,end);
         */
        return paramList.get(unitCount);
    }

    private void setPlayerParam(float speed, float volume){
        setPlayerVolume(volume);
        setPlayerSpeed(speed);
    }

    private boolean isTone(String s){
        if(s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5")){
            return true;
        }else {
            return false;
        }
    }

    private boolean isTone(char ch){
        if(ch-'0' >= 0 && ch-'0' <= 4){
            return true;
        }else if(ch == '}') {
            return true;
        }else if(ch == ')'){
            return true;
        }else{
            return false;
        }
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
