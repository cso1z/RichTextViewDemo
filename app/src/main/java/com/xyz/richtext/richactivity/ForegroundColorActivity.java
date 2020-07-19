package com.xyz.richtext.richactivity;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import com.xyz.richtext.BaseRichTextActivity;
import com.xyz.richtext.R;

/**
 * created by john on 2020/7/12
 * 设置文字颜色
 */
public class ForegroundColorActivity extends BaseRichTextActivity {
    @Override
    public CharSequence getText() {
        String normalText = "这是正常布局中设置的颜色文字\n";
        String blueText = "这是蓝色文字\n";
        String redText = "这个红色文字\n";
        String text = String.format("%1$s%2$s%3$s", normalText, blueText, redText);
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new ForegroundColorSpan(Color.BLUE), normalText.length(), (normalText + blueText).length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.RED), text.length() - redText.length(), text.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        return spannableString;
    }
}