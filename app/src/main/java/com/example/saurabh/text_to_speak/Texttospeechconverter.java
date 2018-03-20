package com.example.saurabh.text_to_speak;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class Texttospeechconverter extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;
    private Button btn;
    private EditText et;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texttospeechconverter);

        tts = new TextToSpeech(this,this);
        btn = (Button) findViewById(R.id.btn1);
        et = (EditText) findViewById(R.id.et1);

        btn.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                speakout();
            }
        });
    }

    private void speakout() {
        CharSequence text = et.getText();
        tts.speak(text,TextToSpeech.QUEUE_FLUSH,null,"id1");
    }



        public void onDestroy() {
            if (tts != null) {
                tts.stop();
                tts.shutdown();
            }
            super.onDestroy();

        }

        public void onInit(int status){
            if (status == TextToSpeech.SUCCESS){
                int result = tts.setLanguage(Locale.ENGLISH);

                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS","THIS LANGUAGE IS NOT SUPPORTED ");
                }else {
                    btn.setEnabled(true);
                    speakout();
                }
            }else {
                Log.e("TTS","INITIALIZATION FAILED");
            }
        }




    };




