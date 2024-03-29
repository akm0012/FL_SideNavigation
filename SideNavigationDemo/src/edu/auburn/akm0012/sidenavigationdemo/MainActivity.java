package edu.auburn.akm0012.sidenavigationdemo;


import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import edu.auburn.akm0012.menunList.animations.CollapseAnimation;
import edu.auburn.akm0012.menunList.animations.ExpandAnimation;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
	private LinearLayout MenuList;
	private Button btnToggleMenuList;
	private int screenWidth;
	private boolean isExpanded;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        MenuList = (LinearLayout) findViewById(R.id.linearLayout2);
        btnToggleMenuList = (Button) findViewById(R.id.button1);
        
        DisplayMetrics metrics = new DisplayMetrics();
        
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        
        screenWidth = metrics.widthPixels;
        
        btnToggleMenuList.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		if (isExpanded) {
        			isExpanded = false;
        			MenuList.startAnimation(new CollapseAnimation(MenuList, 0,(int)(screenWidth*0.7), 20));
        		}else {
            		isExpanded = true;
            		MenuList.startAnimation(new ExpandAnimation(MenuList, 0,(int)(screenWidth*0.7), 20));
        		}
        		}
        });
    }
}
