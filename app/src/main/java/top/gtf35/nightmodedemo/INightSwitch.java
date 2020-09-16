package top.gtf35.nightmodedemo;

/**
 * 日夜间切换接口
 */
public interface INightSwitch {

    /**
     * 切换为夜间模式
     *
     * @param fromUser 是用户主动切换触发
     */
    void changeToNightMode(boolean fromUser);

    /**
     * 切换为日间模式
     *
     * @param fromUser 是用户主动切换触发
     */
    void changeToDayMode(boolean fromUser);
}
