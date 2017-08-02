package com.jacksen.sophixdemo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by Admin on 2017/8/2.
 */

public class SystemUtil {


    /**
     * @param context
     * @return
     */
    public static String getAppVersion(Context context) {
        PackageInfo pkg = null;
        try {
            pkg = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);// 版本名称
            return pkg.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
