package com.begentgroup.sampledesignsupport;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016-07-27.
 */
public class ElevationImageView extends ImageView {
    public ElevationImageView(Context context) {
        super(context);
    }

    public ElevationImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        float elevation = context.getResources().getDimension(R.dimen.image_elevation);
        setElevation(elevation);
    }


    public float getElevation() {
        Log.i("ElevationImageView", "getElevation");
        if (Build.VERSION.SDK_INT >= 21) {
            return super.getElevation();
        } else {
            return elevation;
        }
    }

    float elevation = 0f;

    @Override
    public void setElevation(float elevation) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(elevation);
        } else {
            this.elevation = elevation;
        }
    }
}
