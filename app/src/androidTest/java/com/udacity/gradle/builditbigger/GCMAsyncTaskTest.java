package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

import java.util.concurrent.ExecutionException;

/**
 * Created by Dell on 5/7/2017.
 */

public class GCMAsyncTaskTest   extends AndroidTestCase {

    private static final String TAG = GCMAsyncTaskTest.class.getSimpleName();



    @SuppressWarnings("unchecked")
    public void test() throws Exception {
        GCMAsyncTask gcmAsyncTask = new GCMAsyncTask(null);
        gcmAsyncTask.execute();
        try {
            String joke = gcmAsyncTask.get();
            assertNotNull(joke);
            assertTrue(joke.length() > 0);
            Log.d("Please Check Joke :",""+joke);
         } catch (InterruptedException | ExecutionException e) {
             Log.e(TAG, Log.getStackTraceString(e));
        }
    }

}