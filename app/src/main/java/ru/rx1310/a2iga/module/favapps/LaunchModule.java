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

public class LaunchModule extends PreferenceActivity {

    Preference appItem1, 
               appItem2, 
               appItem3, 
               appItem4;
               
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        PreferenceScreen mPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
        setPreferenceScreen(mPreferenceScreen);

        // Preference item for App1
        appItem1 = new Preference(this);
        appItem1.setTitle("App 1");
        appItem1.setSummary("Summary for App 1");
        
        // Preference item for App2
        appItem2 = new Preference(this);
        appItem2.setTitle("App 2");
        appItem2.setSummary("Summary for App 2");
        
        // Preference item for App3
        appItem3 = new Preference(this);
        appItem3.setTitle("App 3");
        appItem3.setSummary("Summary for App 3");
        
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
    
}
