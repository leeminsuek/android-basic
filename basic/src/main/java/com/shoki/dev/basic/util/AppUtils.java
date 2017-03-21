package com.shoki.dev.basic.util;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

public class AppUtils {

    /**
     * 앱 백그라운드에 있는지 확인
     * ture = fore
     * false = back
     *
     * @param context
     * @return
     */

    public static boolean isAppOnForeground(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        if (appProcesses == null) {
            return false;
        }
        final String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND && appProcess.processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 핸들러 처리
     *
     * @param runnable
     * @param interval
     */
    public static void createHandlerPostDelayed(Runnable runnable, int interval) {
        new android.os.Handler().postDelayed(
                runnable,
                interval
        );
    }


    /**
     * 최신버전 체크
     *
     * @param version1 // project version
     * @param version2 // server new version
     * @return -1 : 최소버전이 더 높음
     * 0 : 버전 동일
     * 1 : 업데이트 필요
     */
    public static int checkUpdate(String version1, String version2) {

        String[] oldVersion = version1.split("\\.");//Build.Config
        String[] newVersion = version2.split("\\.");//new version

        int[] oldVersionConvert = new int[oldVersion.length];
        int[] newVersionConvert = new int[newVersion.length];

        int i = 0;
        for (String str : oldVersion) {
            oldVersionConvert[i++] = Integer.parseInt(str);
        }

        i = 0;
        for (String str : newVersion) {
            newVersionConvert[i++] = Integer.parseInt(str);
        }

        i = 0;
        int update = 0;
        while (update == 0 && i < oldVersionConvert.length) {
            if (oldVersionConvert[i] == newVersionConvert[i]) {
                update = 0;
            } else if (oldVersionConvert[i] > newVersionConvert[i]) {
                update = -1;
            } else {
                update = 1;
            }
            i++;
        }
        return update;
    }
}
