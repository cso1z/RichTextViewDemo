package com.xyz.richtext;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * created by shenyonghui on 2020/7/9
 */
public abstract class BaseRichTextActivity extends Activity {
    public TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new TextView(this);
        textView.setGravity(Gravity.CENTER);
        textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 80);
        setContentView(textView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (getText() != null) {
            textView.setText(getText());
        }
    }

    public abstract CharSequence getText();
}
