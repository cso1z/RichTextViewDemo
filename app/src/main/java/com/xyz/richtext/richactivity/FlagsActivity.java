package com.xyz.richtext.richactivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * created by shenyonghui on 2020/7/14
 * flags 各参数说明
 */
public class FlagsActivity extends Activity {

    private LinearLayout container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        container = new LinearLayout(this);
        container.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        container.setOrientation(LinearLayout.VERTICAL);
        container.setGravity(Gravity.CENTER);
        setContentView(container);
        spanExclusiveExclusive();
        spanExclusiveInclusive();
        spanInclusiveExclusive();
        spanInclusiveInclusive();
    }

    /**
     * 前面包括，后面包括
     */
    private void spanInclusiveInclusive() {
        TextView textView = new TextView(this);
        textView.setGravity(Gravity.CENTER);

        SpannableStringBuilder textSpannedBuilder1 = new SpannableStringBuilder();
        SpannableString textSpanned10 = new SpannableString("前面包括，后面包括:");
        SpannableString textSpanned11 = new SpannableString("INCLUSIVE");
        textSpanned11.setSpan(new BackgroundColorSpan(Color.YELLOW), 0, textSpanned11.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        SpannableString textSpanned12 = new SpannableString(" INCLUSIVE");
        textView.setText(textSpannedBuilder1.append(textSpanned10).append(textSpanned11).append(textSpanned12));

        container.addView(textView);
    }

    /**
     * 前面包括  后面不包括
     */
    private void spanInclusiveExclusive() {
        TextView textView = new TextView(this);
        textView.setGravity(Gravity.CENTER);

        SpannableStringBuilder textSpannedBuilder1 = new SpannableStringBuilder();
        SpannableString textSpanned10 = new SpannableString("前面包括，后面不包括:");
        SpannableString textSpanned11 = new SpannableString("INCLUSIVE");
        textSpanned11.setSpan(new BackgroundColorSpan(Color.YELLOW), 0, textSpanned11.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        SpannableString textSpanned12 = new SpannableString(" EXCLUSIVE");
        textView.setText(textSpannedBuilder1.append(textSpanned10).append(textSpanned11).append(textSpanned12));

        container.addView(textView);
    }

    /**
     * 前不包括 后包括
     */
    private void spanExclusiveInclusive() {
        TextView textView = new TextView(this);
        textView.setGravity(Gravity.CENTER);

        SpannableStringBuilder textSpannedBuilder1 = new SpannableStringBuilder();
        SpannableString textSpanned10 = new SpannableString("前面不包括，后面包括:");
        SpannableString textSpanned11 = new SpannableString("EXCLUSIVE");
        textSpanned11.setSpan(new BackgroundColorSpan(Color.YELLOW), 0, textSpanned11.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        SpannableString textSpanned12 = new SpannableString(" INCLUSIVE");
        textView.setText(textSpannedBuilder1.append(textSpanned10).append(textSpanned11).append(textSpanned12));

        container.addView(textView);
    }

    /**
     * 前后都不包括
     */
    private void spanExclusiveExclusive() {
        TextView textView = new TextView(this);
        textView.setGravity(Gravity.CENTER);

        SpannableStringBuilder textSpannedBuilder1 = new SpannableStringBuilder();
        SpannableString textSpanned10 = new SpannableString("前后都不包括:");
        SpannableString textSpanned11 = new SpannableString("EXCLUSIVE");
        textSpanned11.setSpan(new BackgroundColorSpan(Color.YELLOW), 0, textSpanned11.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        SpannableString textSpanned12 = new SpannableString(" EXCLUSIVE");
        textView.setText(textSpannedBuilder1.append(textSpanned10).append(textSpanned11).append(textSpanned12));

        container.addView(textView);
    }
}