package top.gtf35.nightmodedemo;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * 夜间模式中控
 */
public class NightControl {

    public static final String TAG = "NightControl";
    private static boolean mIsNight = false;

    /**
     * 获取目前是不是夜间模式
     *
     * @return true 夜间
     */
    public static boolean isNight() {
        return mIsNight;
    }

    /**
     * 让实现了 NightSwitch 的 view 适应当前的模式
     *
     * @param nightSwitch [NightSwitch.java] 的实现类
     */
    public static void wrapNowMode(INightSwitch nightSwitch) {
        if (mIsNight) {
            nightSwitch.changeToNightMode(false);
        } else {
            nightSwitch.changeToDayMode(false);
        }
    }

    /**
     * 更新当前页面所有实现了 NightSwitch 的 View 的模式
     *
     * @param ctx 上下文
     * @param isNight 要切换的模式
     */
    public static void updateNightMode(Context ctx, boolean isNight) {
        mIsNight = isNight;
        Activity nowActivity = getWrapperActivity(ctx);
        if (nowActivity == null) {
            Log.i(TAG, "updateNightMode: nowActivity == null");
            return;
        }
        updateAllViews(isNight, nowActivity.getWindow().getDecorView());
    }

    /**
     * 更新自己和子 View 的模式
     *
     * @param isNight 要切换的模式
     * @param v 根 View
     */
    private static void updateAllViews(boolean isNight, View v) {
        if (v == null) return;

        if (v instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) v;
            for (int i = 0; i < vg.getChildCount(); i++) {
                updateAllViews(isNight, vg.getChildAt(i));
            }
        }

        if (v instanceof INightSwitch) {
            INightSwitch nightSwitchImp = (INightSwitch)v;
            if (isNight) {
                nightSwitchImp.changeToNightMode(true);
            } else {
                nightSwitchImp.changeToDayMode(true);
            }
        }

    }

    /**
     * 获取 Activity 的实现
     *
     * @param context 上下文
     * @return Wrapper
     */
    private static Activity getWrapperActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        } else if (context instanceof ContextWrapper) {
            return getWrapperActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

}
