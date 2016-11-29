package com.example.new_one.HelperClasses;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ProgressBar;

import com.example.new_one.Controller_interfacer.AsyncTaskResponse;
import com.example.new_one.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.view.View.VISIBLE;


//1-->Params, the type of the parameters sent to the task upon execution.
//2-->Progress, the type of the progress units published during the background computation.
//3-->Result, the type of the result of the background computation.
public class AsyncTaskResponseFetcher extends AsyncTask<String,Integer, String> {

    int myProgressCount=0;
    private ProgressBar myProgressBar;
    public Activity parentActivity;
    private final String LOG_TAG = AsyncTaskResponseFetcher.class.getSimpleName();
    public AsyncTaskResponse delegate = null;

    public AsyncTaskResponseFetcher()
    {
        Log.e("TracingPoint","FetchWeatherTask_thread_called");
    }

    public AsyncTaskResponseFetcher(String url,Activity activity)
    {
        parentActivity=activity;
    }


////<ProgressBar Operations>
    protected void onPreExecute()
    {
        myProgressBar  = (ProgressBar)parentActivity.findViewById(R.id.progressbar_Horizontal);
        myProgressBar.setVisibility(VISIBLE);
        myProgressBar.setProgress(0);
        myProgressCount = 0;
        Log.e("ProgressBarOberation", "--->ProgressStarted");
    }


    public void progressOperation(String...params)
    {
        Log.e("ProgressBarOberation", "--->ProgressOperations_Started");
        int start=Integer.parseInt(params[0]);
        for(int i=0;i<=start;i+=5){
            try {
                    publishProgress(i);///to publish updates on the UI thread while the background computation is still running.
                                         // Each call to this method will trigger the execution of onProgressUpdate(Progress...) on the UI thread.
                    Log.v("Progress","increment " + i);
                    onProgressUpdate(i);
                    SystemClock.sleep(1000);

            } catch (Exception e) {
                Log.e("Error", e.toString());
            }
        }

    }
    @Override
    protected void onProgressUpdate(Integer...values) {
        // TODO Auto-generated method stub
        int y=values[0];
        myProgressBar.setProgress(y);
    }

    protected void onCancelled() {
        myProgressBar.setMax(0); // stop the progress
    }

    ////<///ProgressBar Operations>
    @Override
    protected String doInBackground(String... params) {

        progressOperation(params[1]);
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        // Will contain the raw JSON response as a string.
        String forecastJsonStr = null;

        try {
            // Construct the URL for the OpenWeatherMap query

            String apiKey = "&APPID=" +"d67dc92adba6a095840b1d873b1067b5";
            URL url = new URL(params[0].concat(apiKey));

            // Create the request to OpenWeatherMap, and open the connection
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                // But it does make debugging a *lot* easier if you print out the completed
                // buffer for debugging.
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                // Stream was empty.  No point in parsing.
                return null;
            }
            forecastJsonStr = buffer.toString();
            Log.d(LOG_TAG, "There is Data=" + forecastJsonStr);

        } catch (IOException e) {
            Log.e(LOG_TAG, "Error ", e);
            // If the code didn't successfully get the weather data, there's no point in attemping
            // to parse it.
            return null;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e(LOG_TAG, "Error closing stream", e);
                }
            }
        }


       return forecastJsonStr;

    }
    @Override
    protected void onPostExecute(String  result) {
        delegate.processFinish(result);



    }








}
