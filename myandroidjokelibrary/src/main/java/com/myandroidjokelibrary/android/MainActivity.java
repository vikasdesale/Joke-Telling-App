package com.myandroidjokelibrary.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String JOKE_KEY = "Joke‌‌‌‌‌‌";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lib);
        Intent intent =getIntent();
        String joke = intent.getStringExtra(JOKE_KEY);
        TextView jokeTextView = (TextView)findViewById(R.id.jock_text);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }
    }
}
