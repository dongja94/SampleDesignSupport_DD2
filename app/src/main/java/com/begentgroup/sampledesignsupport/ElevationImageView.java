package com.begentgroup.sampledesignsupport;

import android.content.Context;
import android.util.AttributeSet;
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
    }

    @Override
    public float getElevation() {
        return 48f;
    }
}
