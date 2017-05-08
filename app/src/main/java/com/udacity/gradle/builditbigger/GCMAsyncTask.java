package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.joketelling.application.backend.myBackendJokes.MyBackendJokes;

import java.io.IOException;

/**
 * Created by Dell on 5/7/2017.
 */

class GCMAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyBackendJokes myApiService = null;
    public JokeReceivedListener jokeCallback;

    public GCMAsyncTask(JokeReceivedListener listener) {
        jokeCallback = listener;
    }

    @Override
    protected final String doInBackground(Void... voids) {

        if (myApiService == null) {  // Only do this once
            MyBackendJokes.Builder builder = new MyBackendJokes.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    // if using genymotion it seems to have the address of 10.0.3.2 instead of 10.0.2.2
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")

                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

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

    public interface JokeReceivedListener {
        void onJokeReceived(String joke);

    }
}