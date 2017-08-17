package io.github.yashladha.hackathon20.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.gc.materialdesign.views.Card;

import java.util.ArrayList;

import io.github.yashladha.hackathon20.FontHelpers.fontHelper;
import io.github.yashladha.hackathon20.Models.UserLocation;
import io.github.yashladha.hackathon20.R;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {

  private Context mContext;
  private ArrayList<UserLocation> users;
  private fontHelper fh;

  public LocationAdapter(Context mContext, ArrayList<UserLocation> users) {
    this.mContext = mContext;
    this.users = users;
    fh = new fontHelper(mContext);
  }

  @Override
  public LocationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(
        R.layout.location_user_card, null, false
    );
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(LocationAdapter.ViewHolder holder, int position) {
    UserLocation temp = users.get(position);
    holder.Name.setText(temp.getUserName());
    holder.bhamashahId.setText(temp.getUserId());
    Log.d("Entered data: ", temp.getUserName());
  }

  @Override
  public int getItemCount() {
    return users.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    private Card card;
    private TextView Name;
    private TextView bhamashahId;

    public ViewHolder(View itemView) {
      super(itemView);
      card = (Card) itemView.findViewById(R.id.card_location);
      Name = (TextView) itemView.findViewById(R.id.tv_user_name);
      bhamashahId = (TextView) itemView.findViewById(R.id.tv_bhamashah_id);

      Name.setTypeface(fh.fontGetter("Medium"));
      bhamashahId.setTypeface(fh.fontGetter("Regular"));
    }
  }
}
