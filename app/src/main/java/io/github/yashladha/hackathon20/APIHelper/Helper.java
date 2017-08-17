package io.github.yashladha.hackathon20.APIHelper;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import io.github.yashladha.hackathon20.VolleyCallback;

public class Helper {

  private String url;
  private Context mContext;

  public Helper(Context mContext, String url) {
    this.mContext = mContext;
    this.url = url;
  }

  public void locationData(final VolleyCallback callback) {
    RequestQueue queue = Volley.newRequestQueue(mContext);
    JsonArrayRequest request = new JsonArrayRequest(
        Request.Method.GET,
        url,
        null,
        new Response.Listener<JSONArray>() {
          @Override
          public void onResponse(JSONArray response) {
            String resp = response.toString();
            callback.onSuccess(response.toString());
          }
        },
        new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            Log.e("Fetch Data Location: ", error.getMessage());
          }
        }
    );
    queue.add(request);
  }

}
