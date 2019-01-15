# MoreTextView
多行文字，折叠/展开功能，多个属性自定义

#### 先上效果图

![MoreTextView](https://github.com/starno1/MoreTextView/blob/master/ScreenShot/ezgif-4-46e2aed8ddc1.gif)

### 自定义属性说明：
**contentText** // 内容显示

**contentTextSize** //内容字体大小 

**contentTextColor** // 内容字体颜色

**expandTextSize**// 折叠字体大小 

**exOpenText** // 折叠按钮打开时 显示文字

**exOpenTextColor** // 折叠按钮打开时 字体颜色

**exCloseText** // 折叠按钮关闭时 显示文字 

**exCloseTextColor** // 折叠按钮关闭时 字体颜色

**exOpenDrawable** // 折叠按钮打开时 右侧图标

**exCloseDrawable** // 折叠按钮关闭时 右侧图标

**expandGravity** // 折叠位置：LEFT RIGHT CENTER

**maxLine** // 内容最大显示行数

**isExpendShow** // 折叠按钮是否显示；默认显示

**exDrawableMarginLeft** // 右侧图标距离左侧折叠文字marginLeft

**expendMarginTop** // 折叠布局距离顶部距离marginTop

**durationMillis** // 展开/收起动画时间

### 提供方法：

// 设置文本内容

```public void setContent(String content)```

// 设置Html片段

```public void setHtmlContent(String content)```

### 使用：

在gradle中加入：

`compile 'com.github.starno1:MoreTextView:1.0.2'`

布局文件中使用：
```
<com.zxing.moretextview.MoreTextView
        android:id="@+id/moreTextView"
        app:contentText="内容"
        app:contentTextColor="#23abf9"
        app:contentTextSize="16"
        app:durationMillis="200"
        app:exCloseDrawable="@drawable/close"
        app:exCloseText="展开"
        app:exCloseTextColor="#ff0000"
        app:exDrawableMarginLeft="20dp"
        app:exOpenDrawable="@drawable/open"
        app:exOpenText="收起"
        app:exOpenTextColor="#00ff00"
        app:expandGravity="LEFT"
        app:expandTextSize="16"
        app:expendMarginTop="20dp"
        app:isExpendShow="true"
        app:maxLine="2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@android:color/white"
        android:padding="15dp"></com.zxing.moretextview.MoreTextView>
```

