package com.xyz.richtext.richactivity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import com.xyz.richtext.BaseRichTextActivity;
import com.xyz.richtext.R;
import com.xyz.richtext.richactivity.weight.CenterAlignImageSpan;

import org.xml.sax.XMLReader;

/**
 * Created by hebiwen on 2020/7/17.
 */
public class HtmlActivity extends BaseRichTextActivity {

        private String html = "<a href=\"http://www.baidu.com\">百度</a>"
            + " <a href=\"tel:13007147721\">13007147721</a>"
            + " <h1>H 1标题<h1>"
            + " <h2>H 2标题<h2>"
            + " <h3>H 3标题<h3>"
            + " <h4>H 4标题<h4>"
            + " <img></img>"
            + " <ll></ll>";

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView.setText(Html.fromHtml(html, null, new MTagHandler()));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /**
     * 可以用来实现TextView、EditText中获取表情图片
     */
    class MImageGetter implements Html.ImageGetter {

        @Override
        public Drawable getDrawable(String source) {
            // html中的图片不能直接显示本地图片，需要通过实现imageGetter来加载
            Drawable drawable = ContextCompat.getDrawable(HtmlActivity.this, R.mipmap.ic_launcher);
            // 必须设置bounds，否则不会显示
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            return drawable;
        }
    }

    class MTagHandler implements Html.TagHandler {

        @Override
        public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {
            if (tag.equalsIgnoreCase("ll")) {
                int startTag = 0, endTag = 0;
                if (opening) {
                    startTag = output.length();
                } else {
                    endTag = output.length();
                    Drawable drawable = ContextCompat.getDrawable(HtmlActivity.this, R.mipmap.ic_launcher_round);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    ImageSpan imageSpan = new ImageSpan(drawable);
                    output.setSpan(imageSpan, startTag, endTag, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
        }
    }

    @Override
    public SpannableString getText() {
        return null;
    }
}
