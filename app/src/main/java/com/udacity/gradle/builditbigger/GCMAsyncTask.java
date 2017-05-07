package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.joketelling.application.backend.myBackendJokes.MyBackendJokes;
import com.myandroidjokelibrary.android.MainActivity;

import java.io.IOException;

/**
 * Created by Dell on 5/7/2017.
 */

class GCMAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyBackendJokes myApiService = null;
    private Context mContext;

    @Override
    protected final String doInBackground(Context... context) {
        if(myApiService == null) {  // Only do this once
            MyBackendJokes.Builder builder = new MyBackendJokes.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://android-app-backend.appspot.com/_ah/api/");
            myApiService = builder.build();
        }

        mContext = context[0];
        try {
            return myApiService.getJokes().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        Intent intent = new Intent(mContext, com.myandroidjokelibrary.android.MainActivity.class);
        intent.putExtra(MainActivity.JOKE_KEY, joke);
        mContext.startActivity(intent);
    }
}