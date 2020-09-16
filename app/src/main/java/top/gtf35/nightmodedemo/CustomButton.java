package top.gtf35.nightmodedemo;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

/**
 * 实现日夜间切换接口 demo
 */
public class CustomButton extends Button implements INightSwitch {
    public CustomButton(Context context) {
        super(context);
        custom(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        custom(context);
    }

    public CustomButton(final Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        custom(context);
    }


    /**
     * 切换为夜间模式
     */
    @Override
    public void changeToNightMode() {
        // 动画示例，自己实现颜色属性动画
        ObjectAnimator.ofArgb(
                this,
                "backgroundColor",
                Color.parseColor("#424242")
        ).start();

        ObjectAnimator.ofArgb(
                this,
                "textColor",
                Color.parseColor("#FAFAFA")
        ).start();
    }

    /**
     * 切换为日间模式
     */
    @Override
    public void changeToDayMode() {
        // 动画示例，自己实现颜色属性动画
        ObjectAnimator.ofArgb(
                this,
                "backgroundColor",
                Color.parseColor("#FAFAFA")
        ).start();

        ObjectAnimator.ofArgb(
                this,
                "textColor",
                Color.parseColor("#424242")
        ).start();
    }

    private void custom(final Context ctx) {
        setText("切换日/夜间");

        // 切换为当前的日夜间模式
        NightControl.wrapNowMode(this);

        setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // 调用 NightControl.updateNightMode(ctx, 是不是夜间模式); 切换主题
                // 调用 NightControl.isNight() 获取当前主题
                NightControl.updateNightMode(ctx, !NightControl.isNight());
            }
        });
    }
}
