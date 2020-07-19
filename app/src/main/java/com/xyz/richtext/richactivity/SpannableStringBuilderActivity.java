package com.xyz.richtext.richactivity;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import com.xyz.richtext.BaseRichTextActivity;

/**
 * created by john on 2020/7/19
 * SpannableStringBuilder 举例
 */
public class SpannableStringBuilderActivity extends BaseRichTextActivity {
    @Override
    public CharSequence getText() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();

        //拼接String 类型
        String string = "这是一个String字符串\n";
        spannableStringBuilder.append(string);

        //拼接SpannableString
        SpannableString spannableString = new SpannableString("这是要给SpannableString字符串");
        spannableString.setSpan(new ForegroundColorSpan(0x80323232), 0, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.append(spannableString);

        return spannableStringBuilder;
    }
}
