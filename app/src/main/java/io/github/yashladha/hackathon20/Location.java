package io.github.yashladha.hackathon20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.github.yashladha.hackathon20.APIHelper.Helper;
import io.github.yashladha.hackathon20.Adapter.LocationAdapter;
import io.github.yashladha.hackathon20.Models.UserLocation;

public class Location extends AppCompatActivity {

  private LocationAdapter locAdapter;
  private ArrayList<UserLocation> users;
  private RecyclerView locationView;

  @Override

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_location);

    locationView = (RecyclerView) findViewById(R.id.rv_location_users);
    users = new ArrayList<>();
    locAdapter = new LocationAdapter(getApplicationContext(), users);
    RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
    locationView.setLayoutManager(lm);
    locationView.setAdapter(locAdapter);

    Helper dl = new Helper(getApplicationContext(),
        "http://172.16.37.192:8000/core/location/321608"
    );
    dl.locationData(new VolleyCallback() {
      @Override
      public void onSuccess(String result) {
        Log.d("Success Location data: ", result);
        getData(result);
      }
    });
  }

  private void getData(String result) {
    try {
      JSONArray array = new JSONArray(result);
      for (int i = 0; i < array.length(); ++i) {
        JSONObject object = (JSONObject) array.get(i);
        UserLocation tempObj = new UserLocation(
            object.get("user_name").toString(),
            object.get("bhamashah_id").toString()
        );
        users.add(tempObj);
        locAdapter.notifyDataSetChanged();
      }
      Log.d("Data Fetched Arraylist", users.toString());
    } catch (JSONException e) {
      Log.e("Location", "Error location");
    }

  }
}
