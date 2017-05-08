package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.myjokesjava.android.MyJokes;

import static com.myandroidjokelibrary.android.MainActivity.JOKE_KEY;


public class MainActivity extends AppCompatActivity implements GCMAsyncTask.JokeReceivedListener {
    private ProgressBar spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        setUp();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        spinner.setVisibility(View.VISIBLE);
        String joke = MyJokes.getMyJoke();
      //  Intent intent = new Intent(this, com.myandroidjokelibrary.android.MainActivity.class);
        //        intent.putExtra(com.myandroidjokelibrary.android.MainActivity.JOKE_KEY, joke);
         //      startActivity(intent);
      //  Toast.makeText(this, randomJoke, Toast.LENGTH_SHORT).show();
        new GCMAsyncTask().execute(this);
    }

    private void setUp() {
        AdView mAdView = (AdView)findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdView adView = (AdView)this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("0123456789ABCDEF")
                .build();
        adView.loadAd(adRequest);
    }


    @Override
    public void onJokeReceived(String joke) {
        spinner.setVisibility(View.GONE);
        Intent intent = new Intent(MainActivity.this, com.myandroidjokelibrary.android.MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(JOKE_KEY, joke);
        startActivity(intent);
    }
}
