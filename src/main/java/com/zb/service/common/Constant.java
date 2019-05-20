package com.zb.service.common;

/**
 * Created by bzheng on 2018/12/17.
 */
public interface Constant {

    /**
     * 报警类型
     */
    interface AlarmType {

        /**
         * 超速报警
         */
        String OVERSPEED = "OVERSPEED";

        /**
         * 超时停车报警
         */
        String TIMEOUT = "TIMEOUT";

        /**
         * 疲劳驾驶报警
         */
        String FATIGUE = "FATIGUE";

        /**
         * 离线报警
         */
        String OFFLINE = "OFFLINE";

        /**
         * 异常油量报警
         */
        String FUEL = "FUEL";


    }
}
