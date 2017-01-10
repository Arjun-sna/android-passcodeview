package in.arjsna.passcodeviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by arjun on 8/4/16.
 */
public class LoggedInActivity extends AppCompatActivity {
  @Override protected void onCreate(Bundle savedInstanceState) {
    overridePendingTransition(R.anim.fade_in, R.anim.slide_out_down);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.logged_in_activity);
  }

  @Override protected void onResume() {
    super.onResume();
  }

  @Override public void onBackPressed() {
    super.onBackPressed();
    overridePendingTransition(R.anim.fade_in, R.anim.slide_out_down);
  }
}
