package com.xyz.richtext.richactivity;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;

import com.xyz.richtext.BaseRichTextActivity;

import java.util.Locale;

/**
 * created by shenyonghui on 2020/7/9
 * 设置文本字体
 */
public class StyleActivity extends BaseRichTextActivity {
    @Override
    public CharSequence getText() {
        String textNormal = "这是正常字体文字\n";
        String textBold = "这是加粗字体文字\n";
        String textItalic = "这是斜体字体文字\n";
        String textBoldItalic = "这是加粗斜体字体文字";
        SpannableString textSpanned = new SpannableString(String.format(Locale.CHINA, "%1$s%2$s%3$s%4$s", textNormal, textBold, textItalic, textBoldItalic));
        textSpanned.setSpan(new StyleSpan(Typeface.NORMAL), 0, textNormal.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        textSpanned.setSpan(new StyleSpan(Typeface.BOLD), textNormal.length(), textNormal.length() + textNormal.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        textSpanned.setSpan(new StyleSpan(Typeface.ITALIC), textNormal.length() + textNormal.length(), textNormal.length() + textNormal.length() + textItalic.length(),
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        textSpanned.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), textNormal.length() + textNormal.length() + textItalic.length(),
                textNormal.length() + textNormal.length() + textItalic.length() + textBoldItalic.length(),
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        return textSpanned;
    }
}
