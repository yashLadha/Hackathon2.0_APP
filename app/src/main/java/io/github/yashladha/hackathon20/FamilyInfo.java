package io.github.yashladha.hackathon20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.github.yashladha.hackathon20.APIHelper.Helper;
import io.github.yashladha.hackathon20.Adapter.FamilyAdapter;
import io.github.yashladha.hackathon20.Models.UserFamily;

public class FamilyInfo extends AppCompatActivity {

  private ArrayList<UserFamily> users;
  private FamilyAdapter adapter;
  private RecyclerView view;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_family_info);

    users = new ArrayList<>();
    view = (RecyclerView) findViewById(R.id.rv_family_info);
    RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
    view.setLayoutManager(lm);
    adapter = new FamilyAdapter(getApplicationContext(), users);
    view.setAdapter(adapter);

    Helper dl = new Helper(getApplicationContext(),
        "http://172.16.37.192:8000/core/family_details/WDDQMOW"
    );
    dl.locationData(new VolleyCallback() {
      @Override
      public void onSuccess(String result) {
        getData(result);
      }
    });
  }

  private void getData(String result) {
    try {
      JSONArray array = new JSONArray(result);
      for (int i = 0;i < array.length(); ++i) {
        JSONObject obj = (JSONObject) array.get(i);
        UserFamily temp = new UserFamily(
            obj.getBoolean("hof"),
            obj.getString("name_eng"),
            obj.getString("name_hnd"),
            obj.getString("gender"),
            obj.getString("aadhaar_id"),
            obj.getString("dob")
        );
        users.add(temp);
        adapter.notifyDataSetChanged();
      }
    } catch (JSONException e) {
      Log.e("FamilyInfo Data ", e.getMessage());
    }
  }
}
