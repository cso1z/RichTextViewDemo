package com.xyz.richtext.richactivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.util.Linkify;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.xyz.richtext.BaseRichTextActivity;
import com.xyz.richtext.R;

/**
 * Created by hebiwen on 2020/7/17.
 */
public class AutoLinkActivity extends BaseRichTextActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String text = "<a href=\"http://www.baidu.com\">百度</a> \n\r tel:18007147721";
        textView.setAutoLinkMask(Linkify.ALL);
        textView.setLinkTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        textView.setHighlightColor(ContextCompat.getColor(this, R.color.colorPrimary));
        textView.setText(text);
    }

    @Override
    public SpannableString getText() {
        return null;
    }
}
