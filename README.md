Android-RobotoTextView
======================

Implementation of a [TextView](http://developer.android.com/reference/android/widget/TextView.html) with native support for all the [Roboto](http://developer.android.com/design/style/typography.html) fonts on all versions of Android.


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

This library is compatible from API 1 (Android 1.0).


Usage
-----

Sample layout with RobotoTextView:

``` xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
             xmlns:app="http://schemas.android.com/apk/res/com.devspark.robototextview"
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

[1]: http://i50.tinypic.com/etay2t.png