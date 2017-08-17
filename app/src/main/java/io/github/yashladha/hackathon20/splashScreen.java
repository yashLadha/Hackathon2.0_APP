package io.github.yashladha.hackathon20;

import android.content.Intent;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class splashScreen extends AwesomeSplash {
  @Override
  public void initSplash(ConfigSplash configSplash) {
    configSplash.setBackgroundColor(R.color.splashBackground);
    configSplash.setAnimCircularRevealDuration(1500);
    configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);
    configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM);

    configSplash.setLogoSplash(R.drawable.coderites);
    configSplash.setAnimLogoSplashTechnique(Techniques.DropOut);

    configSplash.setTitleSplash("Break the code");
    configSplash.setTitleTextColor(R.color.boldText);
    configSplash.setTitleTextSize(30f);
    configSplash.setAnimTitleDuration(1500);
    configSplash.setTitleFont("fonts/Roboto/Roboto-Regular.ttf");
    configSplash.setAnimTitleTechnique(Techniques.FadeInUp);
  }

  @Override
  public void animationsFinished() {
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
    finish();
  }
}
