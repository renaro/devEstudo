package util;

import android.animation.ObjectAnimator;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by movile on 05/07/15.
 */
public class AnimationHelper {

    private final View mView;
    ObjectAnimator scaleX;
    ObjectAnimator scaleY;
    public ObjectAnimator rotatation;


    public AnimationHelper(View v) {
        mView =v;
    }



    public void rotate(int init, int end,int duration) {
        rotatation = ObjectAnimator.ofFloat(mView, "rotation", init, end);
        rotatation.setDuration(duration);

    }


    public void scale(int init, int end,int duration) {
        scaleX = ObjectAnimator.ofFloat(mView, "scaleX", init, end);
        scaleX.setDuration(duration);
        scaleY = ObjectAnimator.ofFloat(mView, "scaleY", init, end);
        scaleY.setDuration(duration);
    }

    public ArrayList<ObjectAnimator> getScaleAnimation() {
        ArrayList<ObjectAnimator> list= new ArrayList<>();
        list.add(scaleX);
        list.add(scaleY);
        return list;
    }
}
