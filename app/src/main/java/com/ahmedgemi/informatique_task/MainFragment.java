package com.ahmedgemi.informatique_task;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {

    InputStreamReader input_stream_reader;
    BufferedReader buffered_reader;
    List<String> list_desc; // List collecting Description...

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, container, false);
        run_script();
        return v;
    }


    public void run_script() {
        new Get_JSON().execute();
    }


    public String get_json() {

        String lines;
        input_stream_reader = new InputStreamReader(getResources().openRawResource(R.raw.data));
        buffered_reader = new BufferedReader(input_stream_reader);

        StringBuilder builder = new StringBuilder();

        try {
            while ((lines = buffered_reader.readLine()) != null) {
                builder.append(lines);// Now we got json as STRING BUILDER
                return builder.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }


    public class Get_JSON extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... strings) {

            String json_object = get_json();
            try {
                JSONObject JObject = new JSONObject(json_object);

                JSONArray JArray = JObject.getJSONArray("");

                list_desc = new ArrayList<>();

                for (int i = 0; i < JArray.length(); i++) {
                    JSONObject object = JArray.getJSONObject(i);
                    String desc = object.getString("description");
                    list_desc.add(desc);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }
    }
}


