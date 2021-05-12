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
import ru.rx1310.a2iga.module.favapps.utils.SharedPrefUtils;
import ru.rx1310.a2iga.module.favapps.utils.AppUtils;

public class ModuleLaunch extends PreferenceActivity {

    PreferenceScreen ps;
    Preference c0, c1, c2, c3;
    String ck0, ck1, ck2, ck3;
	boolean showIcons;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
		showIcons = SharedPrefUtils.getBooleanData(this, "SHOW_ICONS");
		
        // Cell Pref Keys (CK)
        ck0 = SharedPrefUtils.getStringData(this, "k0");
        ck1 = SharedPrefUtils.getStringData(this, "k1");
        ck2 = SharedPrefUtils.getStringData(this, "k2");
        ck3 = SharedPrefUtils.getStringData(this, "k3");
        
        ps = getPreferenceManager().createPreferenceScreen(this);
        
        // Cells (C)
        c0 = new Preference(this);
        c0.setTitle(AppUtils.getAppName(this, ck0));
        c0.setSummary(cellSummary(1));
        
        c1 = new Preference(this);
        c1.setTitle(AppUtils.getAppName(this, ck1));
        c1.setSummary(cellSummary(2));
        
        c2 = new Preference(this);
        c2.setTitle(AppUtils.getAppName(this, ck2));
        c2.setSummary(cellSummary(3));
        
        c3 = new Preference(this);
        c3.setTitle(AppUtils.getAppName(this, ck3));
        c3.setSummary(cellSummary(4));
        
		if (showIcons) {
			c0.setIcon(AppUtils.getAppIcon(this, ck0));
			c1.setIcon(AppUtils.getAppIcon(this, ck1));
			c2.setIcon(AppUtils.getAppIcon(this, ck2));
			c3.setIcon(AppUtils.getAppIcon(this, ck3));
		}
		
        setPreferenceScreen(ps);
        
        if (ck0 != null) ps.addPreference(c0);
        if (ck1 != null) ps.addPreference(c1);
        if (ck2 != null) ps.addPreference(c2);
        if (ck3 != null) ps.addPreference(c3);
        
    }
    
    public boolean onPreferenceTreeClick(PreferenceScreen ps, Preference p) {

        switch (p.getOrder()) {
            
            case 0:
                AppUtils.runApp(this, ck0);
                break;
                
            case 1:
                AppUtils.runApp(this, ck1);
                break;

            case 2:
                AppUtils.runApp(this, ck2);
                break;

            case 3:
                AppUtils.runApp(this, ck3);
                break;
                
            default: break;

        }

        return super.onPreferenceTreeClick(ps, p);

	}
    
    String cellSummary(int cellNum) {
        
        String result = getString(R.string.cell) + " " + cellNum;
        
        return result;
    }
    
}
