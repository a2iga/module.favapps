package ru.rx1310.a2iga.module.favapps;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.graphics.drawable.BitmapDrawable;
import android.content.pm.ApplicationInfo;

public class LaunchModule extends PreferenceActivity {

    Preference appItem1, 
               appItem2, 
               appItem3, 
               appItem4;
               
    String pkgNameApp1,
           pkgNameApp2,
           pkgNameApp3,
           pkgNameApp4;
               
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        PreferenceScreen mPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
        setPreferenceScreen(mPreferenceScreen);
        //getActionBar().hide();
        
        // Preference item for App1
        appItem1 = new Preference(this);
        appItem1.setTitle("App 1");
        appItem1.setSummary(getAppName(this, "ru.rx1310.app.a2iga"));
        appItem1.setIcon(getAppIcon(this, "ru.rx1310.app.a2iga"));
        
        // Preference item for App2
        appItem2 = new Preference(this);
        appItem2.setTitle("App 2");
        appItem2.setSummary(getAppName(this, "com.android.settings"));
        appItem2.setIcon(getAppIcon(this, "com.android.settings"));
        
        // Preference item for App3
        appItem3 = new Preference(this);
        appItem3.setTitle("App 3");
        appItem3.setSummary(getAppName(this, "com.niksoftware.snapseed"));
        appItem3.setIcon(getAppIcon(this, "com.niksoftware.snapseed"));
        
        // Preference item for App4
        appItem4 = new Preference(this);
        appItem4.setTitle("App 4");
        appItem4.setSummary("Summary for App 4");
        
        // Add items in PreferenceScreen
        mPreferenceScreen.addPreference(appItem1);
        mPreferenceScreen.addPreference(appItem2);
        mPreferenceScreen.addPreference(appItem3);
        mPreferenceScreen.addPreference(appItem4);

    }
    
    // ? Получение имени приложения
    public static String getAppName(Context context, String packageName) {

        try {

            PackageManager pm = context.getPackageManager();
            ApplicationInfo ai = pm.getApplicationInfo(packageName, PackageManager.GET_META_DATA);

            String appName = (String) pm.getApplicationLabel(ai);

            return appName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            //Log(context, "e", "getAppName: " + e);
            return "e: getAppName();";
        }

	}
    
    public static Drawable getAppIcon(Context context, String pkgName) {
        try {
            return context.getPackageManager().getApplicationIcon(pkgName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
