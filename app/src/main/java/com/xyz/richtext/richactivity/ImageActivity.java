package com.xyz.richtext.richactivity;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import com.xyz.richtext.BaseRichTextActivity;
import com.xyz.richtext.R;
import com.xyz.richtext.richactivity.weight.CenterAlignImageSpan;

/**
 * created by john on 2020/7/12
 */
public class ImageActivity extends BaseRichTextActivity {
    @Override
    public SpannableString getText() {
        SpannableString sp = new SpannableString("这是图片的电风扇圣诞节");
        //获取一张图片
        Drawable drawable = getDrawable(R.mipmap.icon);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());

        //居中对齐imageSpan
        CenterAlignImageSpan imageSpan = new CenterAlignImageSpan(drawable);
        sp.setSpan(imageSpan, 0, 1, ImageSpan.ALIGN_BASELINE);

        //普通imageSpan 做对比
        ImageSpan imageSpan2 = new ImageSpan(drawable);
        sp.setSpan(imageSpan2, 3, 4, ImageSpan.ALIGN_BASELINE);
        return sp;
    }
}
