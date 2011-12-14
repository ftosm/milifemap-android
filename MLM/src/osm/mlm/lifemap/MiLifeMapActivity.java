package osm.mlm.lifemap;

import com.vendevo.lifemap.R;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class MiLifeMapActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        createTab(WelcomeActivity.class, "miLifemap", R.drawable.tab_image);
        createTab(DiscoverActivity.class, "Discover", R.drawable.tab_image);
        createTab(UploadActivity.class, "Upload", R.drawable.tab_image);
        createTab(SettingsActivity.class, "Settings", R.drawable.tab_image);
         
        getTabHost().setCurrentTab(0);
        
    }

    /** Creates a new tab with the given activity class as content **/
    private void createTab(Class<? extends Activity> activity, 
            String tabAlias,int drawable) {
         
        Intent intent = new Intent().setClass(this, activity);
         
        Resources res = getResources();
        TabHost tabHost = getTabHost();
         
        TabHost.TabSpec spec = tabHost
            .newTabSpec(tabAlias.toLowerCase().replace(" ", "_"))   // this is optional
            .setIndicator(tabAlias, res.getDrawable(drawable))      // sets the drawable
            .setContent(intent);                                    // should be self-explaning
         
        tabHost.addTab(spec);
    }

    
    
    
}