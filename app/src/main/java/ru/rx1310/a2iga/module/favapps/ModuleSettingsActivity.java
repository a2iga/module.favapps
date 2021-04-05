package ru.rx1310.a2iga.module.favapps;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.preference.PreferenceCategory;

public class ModuleSettingsActivity extends PreferenceActivity {
    
    PreferenceCategory ctgPkg;
    EditTextPreference pkgInput1,
                       pkgInput2,
                       pkgInput3,
                       pkgInput4;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
       // pkgApp1 = SharedPrefUtils.getStringData(this, Constants.PKG_APP1);
        
        PreferenceScreen mPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
        setPreferenceScreen(mPreferenceScreen);

        ctgPkg = new PreferenceCategory(this);
        ctgPkg.setTitle(R.string.pref_pkg_ctg);
        
        pkgInput1 = new EditTextPreference(this);
        pkgInput1.setTitle(R.string.pref_pkg_app1);
        pkgInput1.setDialogIcon(R.mipmap.ic_launcher);
        pkgInput1.setDialogTitle("Title");
        pkgInput1.setDialogMessage("Message");
        pkgInput1.setKey(Constants.PKG_APP1);
        
        mPreferenceScreen.addPreference(ctgPkg);
        mPreferenceScreen.addPreference(pkgInput1);
        
    }
    
}
