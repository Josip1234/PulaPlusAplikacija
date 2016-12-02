package com.josip.acer.pulaplusaplikacija;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestoranActivity extends Activity {
    private String jsonResult;
    private String url = "http://pulaplus.esy.es/dogjson.php";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogadjaj);
        listView = (ListView) findViewById(R.id.listView3);
        accessWebService();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // Async Task to access the web
    private class JsonReadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(params[0]);
            try {
                HttpResponse response = httpclient.execute(httppost);
                jsonResult = inputStreamToString(
                        response.getEntity().getContent()).toString();
            }

            catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private StringBuilder inputStreamToString(InputStream is) {
            String rLine = "";
            StringBuilder answer = new StringBuilder();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));

            try {
                while ((rLine = rd.readLine()) != null) {
                    answer.append(rLine);
                }
            }

            catch (IOException e) {
                // e.printStackTrace();
                Toast.makeText(getApplicationContext(),
                        "Error..." + e.toString(), Toast.LENGTH_LONG).show();
            }
            return answer;
        }

        @Override
        protected void onPostExecute(String result) {
            ListDrwaer();
        }
    }// end async task

    public void accessWebService() {
        RestoranActivity.JsonReadTask task = new RestoranActivity.JsonReadTask();
        // passes values for the urls string array
        task.execute(new String[] { url });
    }

    // build hash set for list view
    public void ListDrwaer() {
        List<Map<String, String>> dogadjajList = new ArrayList<Map<String, String>>();


        try {
            JSONObject jsonResponse = new JSONObject(jsonResult);
            JSONArray jsonMainNode = jsonResponse.optJSONArray("restorani");


            for (int i = 0; i < jsonMainNode.length(); i++) {
                JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);


                String naziv = jsonChildNode.optString("naziv");
                String mjesto= jsonChildNode.optString("mjesto");
                String kontakt=jsonChildNode.optString("kontakt");
                String mail=jsonChildNode.optString("mail");

                String outPut = naziv+mjesto+kontakt+mail;

                dogadjajList.add(createDogadjaj("restorani", outPut));

            }
        } catch (JSONException e) {
            Toast.makeText(getApplicationContext(), "Error" + e.toString(),
                    Toast.LENGTH_SHORT).show();
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, dogadjajList,
                android.R.layout.simple_list_item_2,
                new String[] { "restorani" }, new int[] { android.R.id.text2 });

        listView.setAdapter(simpleAdapter);
    }

    private HashMap<String, String> createDogadjaj(String naziv, String mjesto) {
        HashMap<String, String> restoran = new HashMap<String, String>();
        restoran.put(naziv,mjesto);
        return restoran;
    }

}
