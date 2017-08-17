package io.github.yashladha.hackathon20.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.yashladha.hackathon20.FontHelpers.fontHelper;
import io.github.yashladha.hackathon20.Models.UserFamily;
import io.github.yashladha.hackathon20.R;

public class FamilyAdapter extends RecyclerView.Adapter<FamilyAdapter.ViewHolder> {

  private Context mContext;
  private ArrayList<UserFamily> users;
  private fontHelper fm;

  public FamilyAdapter(Context mContext, ArrayList<UserFamily> users) {
    this.mContext = mContext;
    this.users = users;
    fm = new fontHelper(mContext);
  }

  @Override
  public FamilyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(
        R.layout.user_family_index, null, false
    );
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(FamilyAdapter.ViewHolder holder, int position) {
    UserFamily temp = users.get(position);
    holder.nameEng.setText(temp.getNameEng());
    holder.dob.setText(temp.getDob());

    if (temp.getHof()) {
      holder.nameEng.setTypeface(fm.fontGetter("Bold"));
    }
  }

  @Override
  public int getItemCount() {
    return users.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView nameEng;
    private TextView dob;

    public ViewHolder(View itemView) {
      super(itemView);

      nameEng = (TextView) itemView.findViewById(R.id.tv_name_eng);
      dob = (TextView) itemView.findViewById(R.id.tv_dob);

      nameEng.setTypeface(fm.fontGetter("Regular"));
      dob.setTypeface(fm.fontGetter("Light"));
    }
  }
}
