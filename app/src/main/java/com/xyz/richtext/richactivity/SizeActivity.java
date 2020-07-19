package com.xyz.richtext.richactivity;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;

import com.xyz.richtext.BaseRichTextActivity;

/**
 * created by john on 2020/7/12
 * 设置文字大小
 */
public class SizeActivity extends BaseRichTextActivity {
    @Override
    public CharSequence getText() {
        String normalText = "这是正常布局中设置的文字大小\n";
        String absoluteText = "这是使用绝对大小 40\n";
        String relativeText = "这是使用相对大小 1.5倍\n";
        String text = String.format("%1$s%2$s%3$s", normalText, absoluteText, relativeText);
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new AbsoluteSizeSpan(40), normalText.length(), (normalText + absoluteText).length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new RelativeSizeSpan(1.5F), text.length() - relativeText.length(), text.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        return spannableString;
    }
}
