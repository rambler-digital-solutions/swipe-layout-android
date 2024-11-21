# Swipe Layout

Flexible Android Widget

![sample](https://github.com/rambler-digital-solutions/swipe-layout-android/blob/master/rambler.mail.gif?raw=true)

## Download

Add it in your root build.gradle.kts at the end of repositories:
```grovvy
allprojects {
    repositories {
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}
```
Add the dependency
```groovy
dependencies {
    implementation("com.github.rambler-digital-solutions:swipe-layout-android:1.0.17")
}
```
## Usage

**Swipe Layout** may contain up to 3 children with **left**, **right** or **center** gravity attributes.

You could disable swipe completely calling method `setSwipeEnabled(false)` or using XML-attribute `'app:swipe_enabled="false'`

To disable swipe from one of the side you could use methods `setLeftSwipeEnabled(false)` and `setRightSwipeEnabled(false)` or via XML:

```xml
<ru.rambler.libs.swipe_layout.SwipeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="@dimen/item_height"
    app:left_swipe_enabled="false"
    app:right_swipe_enabled="true"/>
```

Full list of widget attributes can be found [here](https://github.com/rambler-digital-solutions/swipe-layout-android/blob/develop/swipe-layout/src/main/res/values/attrs.xml).

```xml
<ru.rambler.libs.swipe_layout.SwipeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="@dimen/item_height">

    <!--CENTER. app:gravity="center" - is default value -->
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        
        ...
    </LinearLayout>

    <!--RIGHT-->
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:gravity="right"
        app:bring_to_clamp="150dp"
        app:clamp="self"        
        app:sticky="100dp">

        ...
    </LinearLayout>

    <!--LEFT-->
    <FrameLayout
        android:layout_width="200dp"
        android:layout_height="match_parent"
        app:gravity="left"
        app:bring_to_clamp="100dp"
        app:clamp="self"        
        app:sticky="none">

        ...
    </FrameLayout>
</ru.rambler.libs.swipe_layout.SwipeLayout>
```

## License

    Licensed under the Apache License, Version 2.0 (the "License");
    
        http://www.apache.org/licenses/LICENSE-2.0
