package com.zxing.moretextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by zxing on 2019/1/8
 *
 * @desc
 */
public class MoreTextView extends LinearLayout {

    private TextView tvContent;
    private LinearLayout layoutExpand;
    private TextView tvExpand;
    private ImageView ivExpand;

    // 自定义属性
    // 内容
    private String contentText;
    // 内容字体大小
    private float contentSize;
    // 内容字体颜色
    private int contentColor;
    // 折叠按钮打开时 显示
    private String exOpenText = "收起";
    // 折叠按钮打开时 字体颜色
    private int exOpenTextColor;
    // 折叠按钮打开时 右侧箭头
    private Drawable exOpenDrawable;
    // 折叠按钮关闭时 显示
    private String exCloseText = "展开";
    // 折叠按钮关闭时 字体颜色
    private int exCloseTextColor;
    // 折叠按钮关闭时 右侧图标
    private Drawable exCloseDrawable;
    // 折叠字体大小
    private float expandSize;
    // 内容最大显示行数
    private int maxLine = 3;
    // 折叠位置：LEFT RIGHT CENTER
    private int expandGravity;
    // 折叠按钮是否显示；默认显示
    private boolean isExpendShow;
    // 折叠右侧图标margin
    private int exDrawableMarginLeft;
    // 折叠距离顶部距离margin
    private int expendMarginTop;
    // 展开收起动画时间
    private int durationMillis;

    // 默认值
    // 字体大小
    private int defaultSize = 18;
    // 字体颜色
    private int defaultTextColor = Color.BLACK;
    // 内容默认显示行数
    private int defaultLine = 3;
    // 折叠默认显示位置 CENTER 居中
    private int defaultExpandGravity = 3;

    public MoreTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs);
    }

    public MoreTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context, attrs);
    }

    /**
     * 初始化
     */
    private void initialize(Context context, AttributeSet attrs) {
        setOrientation(VERTICAL);
        setBackgroundColor(Color.WHITE);
        View rootView = LayoutInflater.from(context).inflate(R.layout.layout_more_text, null);
        tvContent = rootView.findViewById(R.id.tv_content);
        layoutExpand = rootView.findViewById(R.id.layout_expend);
        tvExpand = rootView.findViewById(R.id.tv_expend);
        ivExpand = rootView.findViewById(R.id.iv_expend);
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        addView(rootView, llp);

        initAttrs(context, attrs);
        initListener();
    }

    /**
     * 初始化属性
     */
    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MoreTextView);
        contentText = typedArray.getString(R.styleable.MoreTextView_contentText);
        contentSize = typedArray.getInteger(R.styleable.MoreTextView_contentTextSize, defaultSize);
        contentColor = typedArray.getColor(R.styleable.MoreTextView_contentTextColor, defaultTextColor);
        exOpenText = typedArray.getString(R.styleable.MoreTextView_exOpenText);
        exOpenTextColor = typedArray.getColor(R.styleable.MoreTextView_exOpenTextColor, defaultTextColor);
        exCloseText = typedArray.getString(R.styleable.MoreTextView_exCloseText);
        exCloseTextColor = typedArray.getColor(R.styleable.MoreTextView_exCloseTextColor, defaultTextColor);
        expandSize = typedArray.getInteger(R.styleable.MoreTextView_expandTextSize, defaultSize);
        maxLine = typedArray.getInt(R.styleable.MoreTextView_maxLine, defaultLine);
        exCloseDrawable = typedArray.getDrawable(R.styleable.MoreTextView_exCloseDrawable);
        exOpenDrawable = typedArray.getDrawable(R.styleable.MoreTextView_exOpenDrawable);
        expandGravity = typedArray.getInt(R.styleable.MoreTextView_expandGravity, defaultExpandGravity);
        isExpendShow = typedArray.getBoolean(R.styleable.MoreTextView_isExpendShow, true);
        exDrawableMarginLeft = typedArray.getDimensionPixelSize(R.styleable.MoreTextView_exDrawableMarginLeft, 5);
        expendMarginTop = typedArray.getDimensionPixelSize(R.styleable.MoreTextView_expendMarginTop, 10);
        durationMillis = typedArray.getInt(R.styleable.MoreTextView_durationMillis, 350);
        typedArray.recycle();
    }

    /**
     * 初始化监听
     */
    private void initListener() {
        // 内容设置
        tvContent.setText(contentText);
        tvContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, contentSize);
        tvContent.setTextColor(contentColor);
        if (isExpendShow) {
            layoutExpand.setVisibility(VISIBLE);
            // 折叠提示语设置
            tvExpand.setText(exCloseText);
            tvExpand.setTextSize(TypedValue.COMPLEX_UNIT_DIP, expandSize);
            tvExpand.setTextColor(exCloseTextColor);
            // 折叠图片设置
            ivExpand.setImageDrawable(exCloseDrawable);
            LinearLayout.LayoutParams ivExpandParams = (LayoutParams) ivExpand.getLayoutParams();
            ivExpandParams.leftMargin = exDrawableMarginLeft;
            ivExpand.setLayoutParams(ivExpandParams);

            post(new Runnable() {
                @Override
                public void run() {
                    // 内容高度设置
                    int showHeight = tvContent.getLineHeight() * maxLine;
                    int realHeight = tvContent.getHeight();
                    if (realHeight > showHeight) {
                        tvContent.setHeight(showHeight);
                        layoutExpand.setVisibility(VISIBLE);
                    } else {
                        tvContent.setHeight(realHeight);
                        layoutExpand.setVisibility(GONE);
                    }
                    tvExpand.setText(exCloseText);
                    ivExpand.setImageDrawable(exCloseDrawable);
                }
            });
            // 折叠提示语位置
            LinearLayout.LayoutParams params = (LayoutParams) layoutExpand.getLayoutParams();
            switch (expandGravity) {
                case 1:
                    params.gravity = Gravity.LEFT;
                    break;
                case 2:
                    params.gravity = Gravity.CENTER_HORIZONTAL;
                    break;
                case 3:
                    params.gravity = Gravity.RIGHT;
                    break;
            }
            params.topMargin = expendMarginTop;
            layoutExpand.setLayoutParams(params);
            // 按钮点击事件
            layoutExpand.setOnClickListener(new OnClickListener() {
                boolean isExpand = false;

                @Override
                public void onClick(View view) {
                    isExpand = !isExpand;
                    tvContent.clearAnimation();
                    final int deltaValue;
                    final int startValue = tvContent.getHeight();
                    if (isExpand) {
                        deltaValue = tvContent.getLineHeight() * tvContent.getLineCount() - startValue;
                        tvExpand.setText(exOpenText);
                        tvExpand.setTextColor(exOpenTextColor);
                        ivExpand.setImageDrawable(exOpenDrawable);
                    } else {
                        deltaValue = tvContent.getLineHeight() * maxLine - startValue;
                        tvExpand.setText(exCloseText);
                        tvExpand.setTextColor(exCloseTextColor);
                        ivExpand.setImageDrawable(exCloseDrawable);
                    }
                    Animation animation = new Animation() {
                        protected void applyTransformation(float interpolatedTime, Transformation t) {
                            tvContent.setHeight((int) (startValue + deltaValue * interpolatedTime));
                        }
                    };
                    animation.setDuration(durationMillis);
                    tvContent.startAnimation(animation);
                }
            });
        } else {
            layoutExpand.setVisibility(GONE);
        }
    }

    public void setContent(String content){
        tvContent.setText(content);
        invalidate();
    }

}
