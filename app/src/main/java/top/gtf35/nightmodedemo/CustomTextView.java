package top.gtf35.nightmodedemo;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 实现日夜间切换接口 demo
 */
public class CustomTextView extends TextView implements INightSwitch {

    public CustomTextView(Context context) {
        super(context);
        custom();
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        custom();
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        custom();
    }

    private void custom() {
        // 切换为当前的日夜间模式
        NightControl.wrapNowMode(this);

        setText("示例文本");
    }

    /**
     * 切换为夜间模式
     *
     * @param fromUser 是用户主动切换触发
     */
    @Override
    public void changeToNightMode(boolean fromUser) {
        setTextColor(Color.parseColor("#FAFAFA"));
    }

    /**
     * 切换为日间模式
     *
     * @param fromUser 是用户主动切换触发
     */
    @Override
    public void changeToDayMode(boolean fromUser) {
        setTextColor(Color.parseColor("#212121"));
    }
}
