package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.joketelling.application.backend.myBackendJokes.MyBackendJokes;

import java.io.IOException;

/**
 * Created by Dell on 5/7/2017.
 */

class GCMAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyBackendJokes myApiService = null;
    private Context mContext;
    public JokeReceivedListener jokeCallback;

    public GCMAsyncTask(JokeReceivedListener listener) {
        jokeCallback = listener;
    }
    @Override
    protected final String doInBackground(Void...voids) {
        if(myApiService == null) {  // Only do this once
            MyBackendJokes.Builder builder = new MyBackendJokes.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://stock-hawk-41c91.appspot.com/_ah/api/");
            myApiService = builder.build();
        }

        try {
            return myApiService.getJokes().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        if (jokeCallback != null) {
            jokeCallback.onJokeReceived(joke);
        }
    }

    public interface JokeReceivedListener{
        void onJokeReceived(String joke);

    }
}