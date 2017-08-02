package com.jacksen.sophixdemo;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.taobao.sophix.PatchStatus;
import com.taobao.sophix.SophixManager;
import com.taobao.sophix.listener.PatchLoadStatusListener;

/**
 * Created by Admin on 2017/8/2.
 */

public class BaseApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        initSophix();
        super.onCreate();
    }

    private void initSophix() {
        Log.d("BaseApplication", SystemUtil.getAppVersion(this));
        SophixManager.getInstance().setContext(this)
                .setAppVersion(SystemUtil.getAppVersion(this))
                .setAesKey(null)
                .setEnableDebug(true)
                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
                    @Override
                    public void onLoad(int mode, int code, String info, int handlePatchVersion) {
                        switch (code) {
                            case PatchStatus.CODE_LOAD_SUCCESS: //
                                break;
                            case PatchStatus.CODE_LOAD_FAIL:
                                SophixManager.getInstance().cleanPatches();
                                break;
                            case PatchStatus.CODE_LOAD_RELAUNCH:

                                break;
                            default:

                                break;
                        }
                    }
                }).initialize();
    }
}
