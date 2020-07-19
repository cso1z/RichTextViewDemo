package com.xyz.richtext;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import com.xyz.richtext.richactivity.BackgroundColorActivity;
import com.xyz.richtext.richactivity.ClickableActivity;
import com.xyz.richtext.richactivity.FlagsActivity;
import com.xyz.richtext.richactivity.ForegroundColorActivity;
import com.xyz.richtext.richactivity.HtmlActivity;
import com.xyz.richtext.richactivity.ImageActivity;
import com.xyz.richtext.richactivity.MaskFilterActivity;
import com.xyz.richtext.richactivity.ScaleXActivity;
import com.xyz.richtext.richactivity.SizeActivity;
import com.xyz.richtext.richactivity.SpannableStringBuilderActivity;
import com.xyz.richtext.richactivity.StrikethroughActivity;
import com.xyz.richtext.richactivity.StyleActivity;
import com.xyz.richtext.richactivity.SubscriptActivity;
import com.xyz.richtext.richactivity.SuperscriptActivity;
import com.xyz.richtext.richactivity.TextAppearanceActivity;
import com.xyz.richtext.richactivity.AutoLinkActivity;
import com.xyz.richtext.richactivity.TypefaceActivity;
import com.xyz.richtext.richactivity.UnderlineActivity;
import com.xyz.richtext.richactivity.UrlActivity;
import com.xyz.richtext.weight.ClickItemView;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author shenyonghui
 */
public class MainActivity extends AppCompatActivity {
    private static Map<String, Class> map;

    static {
        map = new LinkedHashMap<>();
        map.put("SpannableStringBuilder", SpannableStringBuilderActivity.class);
        map.put("flags 参数说明", FlagsActivity.class);
        map.put(" 设置字体 StyleSpan", StyleActivity.class);
        map.put(" 文本字体 TypefaceSpan", TypefaceActivity.class);
        map.put(" 设置文字颜色 ForegroundColorSpan", ForegroundColorActivity.class);
        map.put(" 设置文字大小 AbsoluteSizeSpan | RelativeSizeSpan", SizeActivity.class);
        map.put(" 设置图片 ImageSpan", ImageActivity.class);
        map.put(" 设置文本可点击 ClickableSpan", ClickableActivity.class);
        map.put(" 文本超链接 URLSpan", UrlActivity.class);
        map.put(" 背景色  BackgroundColorSpan", BackgroundColorActivity.class);
        map.put(" 下划线  UnderlineSpan", UnderlineActivity.class);
        map.put(" 中划线  StrikethroughSpan", StrikethroughActivity.class);
        map.put(" 修饰效果  MaskFilterSpan", MaskFilterActivity.class);
        map.put(" 下标  SubscriptSpan", SubscriptActivity.class);
        map.put(" 上标  SuperscriptSpan", SuperscriptActivity.class);
        map.put(" 基于x轴缩放  ScaleXSpan", ScaleXActivity.class);
        map.put(" 文本样式  TextAppearanceSpan", TextAppearanceActivity.class);
        map.put(" TextView自带的url、电话等样式  AutoLink", AutoLinkActivity.class);
        map.put(" 使用html改变TextView文字样式  Html", HtmlActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setContentView(scrollView);
        LinearLayout container = new LinearLayout(this);
        container.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        container.setOrientation(LinearLayout.VERTICAL);
        for (Map.Entry<String, Class> entry : map.entrySet()) {
            String title = entry.getKey();
            Class clazz = entry.getValue();
            ClickItemView itemView = new ClickItemView(this);
            itemView.setData(title, clazz);
            itemView.requestLayout();
            container.addView(itemView);
        }
        scrollView.addView(container);
    }
}
