package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Dell on 5/7/2017.
 */

@RunWith(AndroidJUnit4.class)
public class GCMAsyncTaskTest {

    private static final String TAG = GCMAsyncTaskTest.class.getSimpleName();

    public GCMAsyncTaskTest() {
    }

    @Test
    public void executeMe() throws Exception {
        GCMAsyncTask gcmAsyncTask = new GCMAsyncTask();
        gcmAsyncTask.execute();
        try {
            String joke = gcmAsyncTask.get();
            assertNotNull(joke);
            assertTrue(joke.length() > 0);
         } catch (InterruptedException | ExecutionException e) {
             Log.e(TAG, Log.getStackTraceString(e));
        }
    }

}