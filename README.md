Android-RobotoTextView
======================

Implementation of a [TextView](http://developer.android.com/reference/android/widget/TextView.html) and all its direct/indirect subclasses with native support for the [Roboto](http://www.google.com/design/spec/style/typography.html) fonts, includes the brand new [Roboto Slab](http://www.google.com/fonts/specimen/Roboto+Slab) fonts.

Implemented next views:

* `RobotoTextView`
* `RobotoAutoCompleteTextView`
* `RobotoButton`
* `RobotoCheckBox`
* `RobotoCheckedTextView`
* `RobotoChronometer`
* `RobotoCompoundButton`
* `RobotoDigitalClock`
* `RobotoEditText`
* `RobotoExtractEditText`
* `RobotoMultiAutoCompleteTextView`
* `RobotoRadioButton`
* `RobotoSwitch`
* `RobotoTextClock`
* `RobotoToggleButton`

Support next fonts:

* [Roboto](http://www.google.com/fonts/specimen/Roboto)
* [Roboto Condensed](http://www.google.com/fonts/specimen/Roboto+Condensed)
* [Roboto Slab](http://www.google.com/fonts/specimen/Roboto+Slab)


Sample
------

Application is available on Google Play:

<a href="http://play.google.com/store/apps/details?id=com.devspark.robototextview">
  <img alt="Get it on Google Play"
       src="http://www.android.com/images/brand/get_it_on_play_logo_small.png" />
</a>

![screenshot][1]


Compatibility
-------------

This library is compatible from API 3 (Android 1.5).


Example
-------

``` xml
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
             xmlns:app="http://schemas.android.com/apk/res-auto"
             android:layout_width="match_parent"
             android:layout_height="match_parent">

    <com.devspark.robototextview.widget.RobotoTextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:typeface="roboto_thin"/>
</FrameLayout>
```


Usage
-----

#### In XML

To setup a typeface you must specify the parameter `typeface`:

``` xml
<com.devspark.robototextview.widget.RobotoTextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:typeface="roboto_light_italic"/>
```

or specify a set of parameters `fontFamily`, `textWeight` and `textStyle`:
``` xml
<com.devspark.robototextview.widget.RobotoTextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:fontFamily="roboto"
            app:textWeight="light"
            app:textStyle="italic"/>
```

Setup typeface in code:

#### In Code

Using parameter `typeface`:
``` java
RobotoTextView textView = new RobotoTextView(context);
Typeface typeface = RobotoTypefaceManager.obtainTypeface(
        context, 
        RobotoTypefaceManager.Typeface.ROBOTO_LIGHT_ITALIC);
RobotoTextViewUtils.setTypeface(textView, typeface);
```

Using parameters `fontFamily`, `textWeight` and `textStyle`:
``` java
RobotoTextView textView = new RobotoTextView(context);
Typeface typeface = RobotoTypefaceManager.obtainTypeface(
        context, 
        RobotoTypefaceManager.FontFamily.ROBOTO,
        RobotoTypefaceManager.TextWeight.LIGHT,
        RobotoTypefaceManager.TextStyle.ITALIC);
RobotoTextViewUtils.setTypeface(textView, typeface);
```


Gradle
------

Android-RobotoTextView library is now pushed to Maven Central as a AAR, so you just need to add the following dependency to your build.gradle.

``` xml
dependencies {
    compile 'com.github.johnkil.android-robototextview:robototextview:2.1.0'
}
```

If you intend to use is not all fonts, the extra fonts can be removed.

``` xml
android.applicationVariants.all{ variant ->
    variant.mergeAssets.doFirst {
        File fonts = file("${rootDir}/build/intermediates/exploded-aar/com.github.johnkil.android-robototextview/robototextview/2.1.0/assets/fonts")
        if (fonts.exists()) {
            for (File file : fonts.listFiles()) {
                if (file.getName().contains("RobotoSlab")) {
                    println("delete " + file.getName() + " font")
                    file.delete()
                };
            }
        }
    }
}
```

Example Gradle project using Android-RobotoTextView:

* [Android-RobotoTextView-Gradle-Sample](https://github.com/johnkil/Android-RobotoTextView-Gradle-Sample)


Developed By
------------
* Evgeny Shishkin - <johnkil78@gmail.com>


License
-------

    Copyright 2014 Evgeny Shishkin
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
    http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[1]: http://i46.tinypic.com/b9dg69.png
