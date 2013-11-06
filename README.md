Android-RobotoTextView
======================

Implementation of a [TextView](http://developer.android.com/reference/android/widget/TextView.html) and all its direct/indirect subclasses with native support for the [Roboto](http://developer.android.com/design/style/typography.html) fonts, includes the brand new [Roboto Slab](http://www.google.com/fonts/specimen/Roboto+Slab) fonts.

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


Usage
-----

Sample layout with RobotoTextView:

``` xml
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
             xmlns:app="http://schemas.android.com/apk/res-auto"
             android:layout_width="match_parent"
             android:layout_height="match_parent">
             
    <com.devspark.robototextview.widget.RobotoTextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:typeface="roboto_thin"
            android:textSize="22sp"
            android:text="Roboto Thin"/>
</FrameLayout>
```

Available values ​​for the `typeface` attribute:

* roboto_thin
* roboto_thin_italic
* roboto_light
* roboto_light_italic
* roboto_regular
* roboto_italic
* roboto_medium
* roboto_medium_italic
* roboto_bold
* roboto_bold_italic
* roboto_black
* roboto_black_italic
* roboto_condensed_light
* roboto_condensed_light_italic
* roboto_condensed_regular
* roboto_condensed_italic
* roboto_condensed_bold
* roboto_condensed_bold_italic
* roboto_slab_thin
* roboto_slab_light
* roboto_slab_regular
* roboto_slab_bold



Developed By
------------
* Evgeny Shishkin - <johnkil78@gmail.com>


License
-------

    Copyright 2013 Evgeny Shishkin
    
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
