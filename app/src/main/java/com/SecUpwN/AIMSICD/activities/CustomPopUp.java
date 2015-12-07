/* Android IMSI-Catcher Detector | (c) AIMSICD Privacy Project
 * -----------------------------------------------------------
 * LICENSE:  http://git.io/vki47 | TERMS:  http://git.io/vki4o
 * -----------------------------------------------------------
 */
 
/* Coded by Paul Kinsella <paulkinsella29@yahoo.ie>

   Basic Pop Up Screen with Icon - Header - data

   To create a new dialog add this to the case block:

      case 6://your case value for your custom popup
	   createPopUp(
           "YOUR TITLE",
           "YOUR HEADER",
           "YOUR DATA"
           ,getResources().getDrawable(R.drawable.sense_idle));//set your icon

   To call from any activity use:

      MiscUtils.startPopUpInfo(YOUR APP CONTEXT,0);

   The int value is your custom dialog value eg case 10:

 */

package com.SecUpwN.AIMSICD.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.SecUpwN.AIMSICD.R;
import com.SecUpwN.AIMSICD.utils.MiscUtils;

public class CustomPopUp extends AppCompatActivity {
    TextView tv_popup_title,about_tv_status,about_tv_data;
    ImageView about_icon_holder;
    int mode = 0; //default
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.about_pop_up);

        about_icon_holder = (ImageView)findViewById(R.id.about_icon_holder);
        about_tv_status = (TextView)findViewById(R.id.about_tv_status);
        about_tv_data = (TextView)findViewById(R.id.about_tv_data);
        tv_popup_title = (TextView)findViewById(R.id.tv_popup_title);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mode = extras.getInt("display_mode");
        }

        setFinishOnTouchOutside(true);
    }

    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if(mode == 6 || mode == 7 || mode == 8) {
                    MiscUtils.showNotification(getApplicationContext(),
                            getResources().getString(R.string.app_name_short),
                            getResources().getString(R.string.app_name_short) + " - " + getResources().getString(R.string.status_good),
                            R.drawable.sense_ok, false);
                }
                finish();
        }
        return true;
    }
}
