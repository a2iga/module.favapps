package ru.rx1310.a2iga.module.favapps.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import ru.rx1310.a2iga.module.favapps.R;

public class AppUtils {
    
    public static String getAppName(Context c, String pn) {

        try {

            PackageManager pm = c.getPackageManager();
            ApplicationInfo ai = pm.getApplicationInfo(pn, PackageManager.GET_META_DATA);

            String r = (String) pm.getApplicationLabel(ai);

            return r;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static Drawable getAppIcon(Context c, String pn) {
        
        try {
            return c.getPackageManager().getApplicationIcon(pn);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        
        return null;
        
    }
    
    public static void runApp(Context context, String pkgName) {
        
        Intent i = context.getPackageManager().getLaunchIntentForPackage(pkgName);

        if (i == null)
            i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("market://details?id=" + pkgName));

        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(i);
        
    }
    
}
