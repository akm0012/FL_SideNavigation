package edu.auburn.akm0012.menunList.animations;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;

public class CollapseAnimation extends Animation implements Animation.AnimationListener {

	private View view;
	private static int ANIMATION_DURATION;
	private int LastWidth;
	private int FromWidth;
	private int ToWidth;
	private static int STEP_SIZE=30;
	public CollapseAnimation(View v, int FromWidth, int ToWidth, int Duration) {
		
		this.view = v;
		LayoutParams lyp =  view.getLayoutParams();
		ANIMATION_DURATION = 1;
		this.FromWidth = lyp.width;
		this.ToWidth = lyp.width;
		setDuration(ANIMATION_DURATION);
		setRepeatCount(20);
		setFillAfter(false);
		setInterpolator(new AccelerateInterpolator());
		setAnimationListener(this);
	}

	public void onAnimationEnd(Animation anim) {
		// TODO Auto-generated method stub
		
	}

	public void onAnimationRepeat(Animation anim) {
		// TODO Auto-generated method stub
		LayoutParams lyp =  view.getLayoutParams();
		lyp.width = lyp.width - ToWidth/20;
		view.setLayoutParams(lyp);
	}

	public void onAnimationStart(Animation anim) {
		// TODO Auto-generated method stub
		LayoutParams lyp =  view.getLayoutParams();
		LastWidth = lyp.width;
	}


}

