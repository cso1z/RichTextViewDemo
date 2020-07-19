package com.xyz.richtext.richactivity;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import com.xyz.richtext.BaseRichTextActivity;
import com.xyz.richtext.R;
import com.xyz.richtext.richactivity.weight.CenterAlignImageSpan;

/**
 * created by john on 2020/7/12
 * 设置图片
 */
public class ImageActivity extends BaseRichTextActivity {

    @Override
    public CharSequence getText() {
        String normalImageText = "这是正常在首部加图片\n";
        String centerImageText = "这是在首部加居中图片";
        String text = normalImageText + centerImageText;
        SpannableString sp = new SpannableString(text);

        //获取一张图片
        Drawable drawable = getDrawable(R.mipmap.icon);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());

        //普通imageSpan 做对比
        ImageSpan imageSpan = new ImageSpan(drawable);
        sp.setSpan(imageSpan, 0, 1, ImageSpan.ALIGN_BASELINE);
        //居中对齐imageSpan
        CenterAlignImageSpan imageSpan1 = new CenterAlignImageSpan(drawable);
        sp.setSpan(imageSpan1, normalImageText.length(), normalImageText.length() + 1, ImageSpan.ALIGN_CENTER);

        return sp;
    }
}
