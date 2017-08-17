package io.github.yashladha.hackathon20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gc.materialdesign.views.ButtonRectangle;

public class MainActivity extends AppCompatActivity {

  private ButtonRectangle locationBtn;
  private ButtonRectangle adhaarBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    locationBtn = (ButtonRectangle) findViewById(R.id.btnRecLocation);
    locationBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), Location.class);
        startActivity(intent);
      }
    });

    adhaarBtn = (ButtonRectangle) findViewById(R.id.adhaarCardBtn);
    adhaarBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), FamilyInfo.class);
        startActivity(intent);
      }
    });
  }
}
