package com.xyz.richtext.richactivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.xyz.richtext.BaseRichTextActivity;

/**
 * created by john on 2020/7/12
 * 文本超链接
 */
public class UrlActivity extends BaseRichTextActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView.setTextIsSelectable(true);
        //方法重新设置文字点击
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        //方法重新设置文字背景为透明色。
        textView.setHighlightColor(getResources().getColor(android.R.color.darker_gray));
    }

    @Override
    public SpannableString getText() {
        SpannableString ss = new SpannableString("谷歌");
        ss.setSpan(new Url("http://www.baidu.com"), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ss;
    }

    static class Url extends URLSpan {

        Url(String url) {
            super(url);
        }

        @Override
        public void updateDrawState(@NonNull TextPaint ds) {
            super.updateDrawState(ds);
            ds.setColor(0xFF0474E5);//设置文字颜色
            ds.setUnderlineText(false);    //去除超链接的下划线
            ds.clearShadowLayer();
        }
    }
}
