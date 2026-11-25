package dev.nyxasteria.performance;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.*;
public final class MainActivity extends Activity {
 @Override public void onCreate(Bundle state) {
  super.onCreate(state);
  LinearLayout root = new LinearLayout(this);
  root.setOrientation(LinearLayout.VERTICAL);
  root.setGravity(Gravity.CENTER);
  root.setBackgroundColor(0xff111115);
  TextView title = new TextView(this);
  title.setText("Performance Pages"); title.setTextColor(0xffff995a); title.setTextSize(32); root.addView(title);
  TextView message = new TextView(this);
  message.setText("Hello World"); message.setTextColor(0xffffffff); message.setTextSize(24); root.addView(message);
  Button close = new Button(this); close.setText("Close");
  close.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ finish(); } }); root.addView(close);
  setContentView(root);
 }
}