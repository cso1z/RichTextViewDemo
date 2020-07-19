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
 * Sets the autolink mask of the text
 */
public class AutoLinkActivity extends BaseRichTextActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView.setTextIsSelectable(true);
        textView.setAutoLinkMask(Linkify.ALL);
        textView.setLinkTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        textView.setHighlightColor(ContextCompat.getColor(this, R.color.colorPrimary));
    }

    @Override
    public CharSequence getText() {
        return "百度: http://www.baidu.com \n tel:18007147721";
    }
}
