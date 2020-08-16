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
    private List<Integer> paramSpeedList = new ArrayList<>();
    private List<Integer> paramVolumeList = new ArrayList<>();

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
            initialParam();
            getAllParam();
            setEmotion();
            mBtnStart.setEnabled(false);
            Context context = getApplicationContext();
            mMediaPlayer = MediaPlayer.create(context, getResId(talkStrings[0], R.raw.class));
            float speed = getSpeed(current);
            float volume = getVolume(current);
            setPlayerParam(speed, volume);
            mMediaPlayer.start();
            if (talkStrings.length == 1) {
                talkOver();
            } else {
                talkNext();
            }
        }
    }

    private void initialParam() {
        current = 0;
        paramList.clear();
        paramSpeedList.clear();
        paramVolumeList.clear();
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
        setSpecificEmotion(1.0f,1.0f);
    }

    private void setHappyEmotion(){
        setSpecificEmotion(0.87f,1.2f);
    }

    private void setSadEmotion(){
        setSpecificEmotion(1.25f,0.8f);
    }

    private void setAngryEmotion(){
        setSpecificEmotion(0.8f,1.3f);
    }

    private void setSpecificEmotion(float speedFactor, float volumeFactor){
        int i = 0;
        for(int t:paramList){
            int speed = Math.round(t*speedFactor);
            int volume = Math.round(t*volumeFactor);
            paramSpeedList.add(i,speed);
            paramVolumeList.add(i,volume);
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
                mBtnStart.setEnabled(true);
                mMediaPlayer.reset();
                mMediaPlayer.release();
            }
        });
    }

    private boolean checkInput(){
        String[] testString = getStringArray();
        String[] rawYinYuan = RawYinYuanData.getRawYinYuan();
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
        current++;
        Context context = getApplicationContext();
        mMediaPlayer = MediaPlayer.create(context, getResId(testString2[current], R.raw.class));
        float speed = getSpeed(current);
        float volume = getVolume(current);
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
        int touchTime = getSpeedTouchTime(i);
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
        int touchTime = getVolumeTouchTime(i);
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

    private int getSpeedTouchTime(int unitCount){
        return paramSpeedList.get(unitCount);
    }

    private int getVolumeTouchTime(int unitCount){
        return paramVolumeList.get(unitCount);
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
