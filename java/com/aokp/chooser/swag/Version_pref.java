package com.aokp.chooser.swag;


import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.preference.Preference;
import android.util.AttributeSet;

public class Version_pref extends Preference {
    public Version_pref(Context context, AttributeSet attrs) {
        super(context, attrs);
        String versionName;
        final PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                versionName = packageInfo.versionName;
            } catch (PackageManager.NameNotFoundException e) {
                versionName = null;
            }
            setSummary("Installed version is " + versionName);
        }
    }
}
