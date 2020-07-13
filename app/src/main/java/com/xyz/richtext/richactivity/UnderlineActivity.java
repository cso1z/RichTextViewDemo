package com.xyz.richtext.richactivity;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;

import androidx.annotation.Nullable;

import com.xyz.richtext.BaseRichTextActivity;

/**
 * created by shenyonghui on 2020/7/13
 */
public class UnderlineActivity extends BaseRichTextActivity {

    @Override
    public SpannableString getText() {
        String text = "下面这句话是重点，\n记得划线";
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new UnderlineSpan(), text.length() - 4, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

}
