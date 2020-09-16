package top.gtf35.nightmodedemo;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * 实现日夜间切换接口 demo
 */
public class CustomLinearLayout extends LinearLayout implements INightSwitch {
    public CustomLinearLayout(Context context) {
        super(context);
        loadViews(context);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        loadViews(context);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        loadViews(context);
    }

    private void loadViews(final Context ctx) {
        // 切换为当前的日夜间模式
        NightControl.wrapNowMode(this);

        setOrientation(LinearLayout.VERTICAL);

        CustomButton button = new CustomButton(ctx);
        LinearLayout.LayoutParams buttonLP = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 200);
        addView(button, buttonLP);

        CustomTextView textView = new CustomTextView(ctx);
        LinearLayout.LayoutParams textLP = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 200);
        addView(textView, textLP);
    }

    /**
     * 切换为夜间模式
     *
     * @param fromUser 是用户主动切换触发
     */
    @Override
    public void changeToNightMode(boolean fromUser) {
        // 动画示例，自己实现颜色属性动画
        if (fromUser) {
            ObjectAnimator.ofArgb(this, "backgroundColor", Color.BLACK).start();
        } else {
            setBackgroundColor(Color.BLACK);
        }
    }

    /**
     * 切换为日间模式
     *
     * @param fromUser 是用户主动切换触发
     */
    @Override
    public void changeToDayMode(boolean fromUser) {
        // 动画示例，自己实现颜色属性动画
        if (fromUser) {
            ObjectAnimator.ofArgb(this, "backgroundColor", Color.WHITE).start();
        } else {
            setBackgroundColor(Color.WHITE);
        }
    }
}
