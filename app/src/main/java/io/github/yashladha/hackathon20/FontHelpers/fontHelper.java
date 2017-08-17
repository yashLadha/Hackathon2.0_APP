package io.github.yashladha.hackathon20.FontHelpers;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Objects;

public class fontHelper {

  private Context mContext;

  public fontHelper(Context mContext) {
    this.mContext = mContext;
  }

  public Typeface fontGetter(String type) {
    String flagString = "";
    if (Objects.equals(type, "Light"))
      flagString = "Roboto-Light.ttf";
    else if (Objects.equals(type, "Medium"))
      flagString = "Roboto-Medium.ttf";
    else if (Objects.equals(type, "Regular"))
      flagString = "Roboto-Regular.ttf";
    else if (Objects.equals(type, "Bold"))
      flagString = "Roboto-Bold.ttf";
    return Typeface.createFromAsset(
        mContext.getAssets(),
        "fonts/Roboto/"+flagString
    );
  }

}
