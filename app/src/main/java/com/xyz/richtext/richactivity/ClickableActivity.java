package com.xyz.richtext.richactivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Browser;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.xyz.richtext.BaseRichTextActivity;

/**
 * created by john on 2020/7/12
 * 设置文本可点击
 */
public class ClickableActivity extends BaseRichTextActivity {

    private String url = "http://baidu.com";

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
        String text = "这句话中有两个地方可以点击，\n第一个地方是百度，\n另一个地方在这四个字";
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new Clickable(firstClickListener), text.indexOf("百度"), text.indexOf("，\n另"), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new Clickable(secondClickListener), text.indexOf("这四个字"), text.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        return spannableString;
    }

    private View.OnClickListener firstClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri uri = Uri.parse(url);
            Context context = v.getContext();
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.putExtra(Browser.EXTRA_APPLICATION_ID, context.getPackageName());
            context.startActivity(intent);
        }
    };

    private View.OnClickListener secondClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(ClickableActivity.this, "第二个点击事件", Toast.LENGTH_SHORT).show();

        }
    };

    static class Clickable extends ClickableSpan {
        View.OnClickListener listener;

        Clickable(View.OnClickListener listener) {
            this.listener = listener;
        }

        @Override
        public void onClick(@NonNull View v) {
            listener.onClick(v);
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
