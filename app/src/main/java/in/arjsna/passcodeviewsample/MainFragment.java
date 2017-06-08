package in.arjsna.passcodeviewsample;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import in.arjsna.passcodeview.PassCodeView;

/**
 * Created by arjun on 23/1/17.
 */
public class MainFragment extends Fragment{
  private final String PASSCODE = "1234";
  private PassCodeView passCodeView;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View mRootView = inflater.inflate(R.layout.fragment_main, container, false);
    passCodeView = (PassCodeView) mRootView.findViewById(R.id.pass_code_view);
    TextView promptView = (TextView) mRootView.findViewById(R.id.promptview);
    Typeface typeFace = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Font-Bold.ttf");
    passCodeView.setTypeFace(typeFace);
    passCodeView.setKeyTextColor(R.color.black_shade);
    passCodeView.setEmptyDrawable(R.drawable.empty_dot);
    passCodeView.setFilledDrawable(R.drawable.filled_dot);
    promptView.setTypeface(typeFace);
    bindEvents();
    return mRootView;
  }

  private void bindEvents() {
    passCodeView.setOnTextChangeListener(new PassCodeView.TextChangeListener() {
      @Override public void onTextChanged(String text) {
        if (text.length() == 4) {
          if (text.equals(PASSCODE)) {
            Intent intent = new Intent(getActivity(), LoggedInActivity.class);
            startActivity(intent);
            getActivity().finish();
          } else {
            passCodeView.setError(true);
          }
        }
      }
    });
  }


}
