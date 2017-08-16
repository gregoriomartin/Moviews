package digitalhouse.android.a0317moacns1c_02.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_02.R;

/**
 * Created by Pablo on 20/06/2017.
 */

public class PageIndicator {
    private Integer size;
    private Integer currentPage;
    private List<TextView> dotList;
    private LinearLayout container;

    public PageIndicator(LinearLayout container, Integer size) {
        this.container = container;
        this.size = size;
        this.currentPage = 0;
        createDots();
    }

    private void createDots(){
        dotList = new ArrayList<>();
        for (int i=0; i<size; i++) {
            TextView dot = new TextView(container.getContext());
            dot.setText("|");
            dot.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            dot.setTextColor(Color.BLACK);
            dot.setBackgroundColor(Color.argb(80,255,255,255));
            dotList.add(dot);
            container.addView(dot);
        }
    }

    public void setPage(Integer page) {
        dotList.get(currentPage).setTextColor(Color.BLACK);
        dotList.get(page).setTextColor(Color.WHITE);
        currentPage = page;
    }

}
