package ru.rx1310.a2iga.module.favapps;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import ru.rx1310.a2iga.module.favapps.R;
import ru.rx1310.a2iga.module.favapps.utils.SharedPrefUtils;
import android.widget.Toast;
import android.preference.SwitchPreference;

public class ModuleSettings extends PreferenceActivity {

    Intent i;

    PreferenceScreen ps;
    Preference cleanCell;
	SwitchPreference showIcons;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        i = getIntent();
		
        ps = getPreferenceManager().createPreferenceScreen(this);
        
        cleanCell = new Preference(this);
        cleanCell.setTitle("Удалить ячейки");
        cleanCell.setKey("CLEAN_CELL");
        
		showIcons = new SwitchPreference(this);
		showIcons.setTitle(R.string.show_icons);
		showIcons.setSummary(R.string.show_icons_desc);
		showIcons.setKey("SHOW_ICONS");
		
        setPreferenceScreen(ps);
        
        ps.addPreference(cleanCell);
		ps.addPreference(showIcons);

        // Получение Package Name от A2IGA
        String ia = i.getAction();
        String it = i.getType();

		if (Intent.ACTION_SEND.equals(ia) && it != null || "text/plain".equals(it)) cellList(i, true);
        
    }
    
    public boolean onPreferenceTreeClick(PreferenceScreen ps, Preference p) {

        switch (p.getKey()) {

            case "CLEAN_CELL":
                cellList(i, false);
                break;

            default: break;

        }

        return super.onPreferenceTreeClick(ps, p);

	}
    
    
    // Диалог с выводом списка ячеек, которые можно пере|записать
    void cellList(Intent i, final boolean fillCell) {
        
        final String pn = i.getStringExtra(Intent.EXTRA_TEXT);
        
        String title;
        
        if (fillCell) title = "Записать ячейку";
        else title = "Стереть ячейку";
        
        AlertDialog.Builder b = new AlertDialog.Builder(ModuleSettings.this);
        
        b.setCancelable(false);
        b.setTitle(title);
        
        b.setItems(R.array.fc_items, new DialogInterface.OnClickListener() {
            
            public void onClick(DialogInterface d, int p) {
                
                if (fillCell) updateCell("k" + p, pn);
                else updateCell("k" + p, null);
                
            }
             
        });
        
        b.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() { // обработка нажатия кнопки "No"
            public void onClick(DialogInterface d, int i) {
                //d.dismiss();
                finish();
            }
        });
        
        
        b.show();
        
    }
    
    void updateCell(String cellKey, String data) {
        SharedPrefUtils.saveData(ModuleSettings.this, cellKey, data);
        ModuleSettings.this.finish();
    }
    
}
