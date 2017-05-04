package tw.idv.madmanchen.mdsegmentedcontrollib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Author:      chenshaowei
 * Version      V1.0
 * Description:
 * Modification History:
 * Date         Author          version         Description
 * ---------------------------------------------------------------------
 * 2017/5/2      chenshaowei         V1.0.0          Create
 * What is modified:
 */

public class MDSegmentedControl extends RadioGroup {
    private OnChoiceListener mOnChoiceListener;
    private int selectTextColor, defaultTextColor;
    private int firstItemBgResId, centerItemBgResId, lastItemBgResId;

    public interface OnChoiceListener {
        void onChoice(View view, int pos);
    }

    public MDSegmentedControl(Context context) {
        super(context);
        initView();
    }

    public MDSegmentedControl(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SegmentedControl);
        defaultTextColor = typedArray.getColor(R.styleable.SegmentedControl_defaultTextColor, ContextCompat.getColor(context, R.color.segmentedControlBgColor));
        selectTextColor = typedArray.getColor(R.styleable.SegmentedControl_selectTextColor, Color.WHITE);
        firstItemBgResId = typedArray.getResourceId(R.styleable.SegmentedControl_firstItemBackground, R.drawable.sty_rb_first);
        centerItemBgResId = typedArray.getResourceId(R.styleable.SegmentedControl_centerItemBackground, R.drawable.sty_rb_center);
        lastItemBgResId = typedArray.getResourceId(R.styleable.SegmentedControl_lastItemBackground, R.drawable.sty_rb_last);
        typedArray.recycle();

    }

    public void setOnChoiceListener(OnChoiceListener onChoiceListener) {
        mOnChoiceListener = onChoiceListener;
    }

    public void setChoice(int pos) {
        RadioButton radioButton = (RadioButton) getChildAt(pos);
        radioButton.setChecked(true);
    }

    private void initView() {
        setOrientation(HORIZONTAL);
        setOnCheckedChangeListener(mOnCheckedChangeListener);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.weight = 1;
        for (int i = 0; i < getChildCount(); i++) {
            RadioButton child = (RadioButton) getChildAt(i);
            child.setLayoutParams(layoutParams);
            child.setLines(1);
            child.setPadding(6, 6, 6, 6);
            child.setGravity(Gravity.CENTER);
            child.setButtonDrawable(android.R.color.transparent);
            if (i == 0) {
                child.setBackgroundResource(firstItemBgResId);
            } else if (i == getChildCount() - 1) {
                child.setBackgroundResource(lastItemBgResId);
            } else {
                child.setBackgroundResource(centerItemBgResId);
            }
            refreshView(i);
        }
    }

    private OnCheckedChangeListener mOnCheckedChangeListener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            for (int i = 0; i < getChildCount(); i++) {
                refreshView(i);
            }
            View view = findViewById(checkedId);
            int pos = indexOfChild(view);
            if (mOnChoiceListener != null) {
                mOnChoiceListener.onChoice(view, pos);
            }
        }
    };

    private void refreshView(int pos) {
        RadioButton child = (RadioButton) getChildAt(pos);
        if (child.isChecked()) {
            child.setTextColor(selectTextColor);
        } else {
            child.setTextColor(defaultTextColor);
        }

    }
}
