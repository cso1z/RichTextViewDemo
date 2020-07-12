package com.xyz.richtext;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import com.xyz.richtext.richactivity.ForegroundColorActivity;
import com.xyz.richtext.richactivity.ImageActivity;
import com.xyz.richtext.richactivity.SizeActivity;
import com.xyz.richtext.richactivity.StyleActivity;
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
        map.put(" 设置字体 StyleSpan ", StyleActivity.class);
        map.put(" 设置文字颜色 ForegroundColorSpan", ForegroundColorActivity.class);
        map.put(" 设置文字大小 AbsoluteSizeSpan | RelativeSizeSpan ", SizeActivity.class);
        map.put(" 设置图片 ImageSpan  ", ImageActivity.class);
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
