#仿 iOS SegmentedControl
使用
-----
**1. Gradle dependency** (recommended)

  -  Add the following to your project level `build.gradle`:
 
```gradle
allprojects {
	repositories {
		maven { url "https://jitpack.io" }
	}
}
```
  -  Add this to your app `build.gradle`:
 
```gradle
dependencies {
	compile 'com.github.army650663:MDSegmentedControl:v1.0.2'
}
```
###範例
 - 可設定項目
```
預設文字顏色
defaultTextColor
選取後文字顏色
selectTextColor
中間選項的 Drawable
centerItemBackground
頭選項的 Drawable
firstItemBackground
尾選項的 Drawable
lastItemBackground
```

 - layout.xml
```xml
<tw.idv.madmanchen.mdsegmentedcontrollib.MDSegmentedControl
        android:id="@+id/sc"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:padding="1dp"
        app:selectTextColor="@color/black"
        app:defaultTextColor="@color/white">

        <RadioButton
            android:id="@+id/radioButton0"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:checked="true"
            android:text="Android"
            android:textSize="20sp"/>

        <RadioButton
            android:id="@+id/radioButton1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="iPhone"
            android:textSize="20sp"/>

        <RadioButton
            android:id="@+id/radioButton2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Win"
            android:textSize="20sp"/>
 </tw.idv.madmanchen.mdsegmentedcontrollib.MDSegmentedControl>
```

####變更背景顏色
- colors.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="segmentedControlBgColor">#a46228</color>
</resources>
```