package top.gtf35.nightmodedemo;

/**
 * 日夜间切换接口
 */
public interface INightSwitch {

    /**
     * 切换为夜间模式
     */
    void changeToNightMode();

    /**
     * 切换为日间模式
     */
    void changeToDayMode();
}
