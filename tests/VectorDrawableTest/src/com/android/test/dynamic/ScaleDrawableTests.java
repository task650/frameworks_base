/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.android.test.dynamic;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.GridLayout;
import android.widget.ScrollView;

@SuppressWarnings({"UnusedDeclaration"})
public class ScaleDrawableTests extends Activity {
    private static final String LOGCAT = "VectorDrawable1";

    private String[] scaleTypes = {
            "MATRIX      (0)",
            "FIT_XY      (1)",
            "FIT_START   (2)",
            "FIT_CENTER  (3)",
            "FIT_END     (4)",
            "CENTER      (5)",
            "CENTER_CROP (6)",
            "CENTER_INSIDE (7)"
    };

    protected int[] icon = {
            R.drawable.bitmap_drawable01,
            R.drawable.bitmap_drawable01,
            R.drawable.bitmap_drawable01,
            R.drawable.bitmap_drawable01,
            R.drawable.bitmap_drawable01,
            R.drawable.bitmap_drawable01,
            R.drawable.bitmap_drawable01,
            R.drawable.bitmap_drawable01,
    };

    protected int[] vector_icons = {
            R.drawable.vector_drawable16,
            R.drawable.vector_drawable16,
            R.drawable.vector_drawable16,
            R.drawable.vector_drawable16,
            R.drawable.vector_drawable16,
            R.drawable.vector_drawable16,
            R.drawable.vector_drawable16,
            R.drawable.vector_drawable16,
            R.drawable.vector_drawable16,
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScrollView scrollView = new ScrollView(this);
        GridLayout container = new GridLayout(this);
        scrollView.addView(container);
        container.setColumnCount(3);
        container.setBackgroundColor(0xFF888888);

        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        params.width = 400;
        params.height = 300;

        for (int i = 0; i < icon.length; i++) {
            TextView t = new TextView(this);
            t.setText(scaleTypes[i]);
            container.addView(t);

            ImageView png_view = new ImageView(this);
            png_view.setLayoutParams(params);
            png_view.setScaleType(ImageView.ScaleType.values()[i]);
            png_view.setImageResource(icon[i]);
            container.addView(png_view);

            ImageView view = new ImageView(this);
            view.setLayoutParams(params);
            view.setScaleType(ImageView.ScaleType.values()[i]);
            view.setImageResource(vector_icons[i]);
            container.addView(view);
        }

        setContentView(scrollView);
    }
}
