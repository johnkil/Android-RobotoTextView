Change Log
==========


## Version 4.0.0

_2017-07-26_

 * Support AppCompat v26.0.0. Changed attribute names:
    - `typeface` -> `robotoTypeface`
    - `fontFamily` -> `robotoFontFamily`
    - `textWeight` -> `robotoTextWeight`
    - `textStyle` -> `robotoTextStyle`


## Version 3.0.0

_2017-02-14_

 * Updated roboto fonts [v2.136](https://github.com/google/roboto/releases/tag/v2.136).
 * Implemented `RobotoInflater` to apply roboto typeface for original TextView (like a [Calligraphy](https://github.com/chrisjenx/Calligraphy)).
 * Implemented [gradle plugin](https://github.com/johnkil/Android-RobotoTextView/tree/master/robototextview-gradle-plugin) for managing the roboto fonts.
 * Refactoring of implementation: 
   - Removed deprecated class `RobotoDigitalClock`.
   - Joined of `RobotoTypefaceManager` and `RobotoTypefaceUtils` into `RobotoTypefaces`.
 * Support AppCompat v25.1.1.


## Version 2.5.1

_2016-08-26_

 * Support AppCompat v24.2.


## Version 2.5.0

_2016-01-22_

 * Support brand new `Roboto Mono` typefaces.
 * Rename method for set up typeface for TextView/Paint (`setup(...)` -> `setUp(...)`).
 * Updated build tools and dependencies (Gradle Plugin 2.0.0-alpha6, AppCompat v23.1.1).


## Version 2.4.3

_2015-09-11_

 * Implemented `RobotoTextAppearanceSpan`.
 * Updated build tools and dependencies (Gradle Plugin 1.5.0-beta2, AppCompat v23.1).


## Version 2.4.2

_2015-08-31_

 * Sync roboto fonts with latest version from [Google Fonts](https://www.google.com/fonts/specimen/Roboto).
 * Fix: Russian rouble glyph in pre-lollipop android.


## Version 2.4.1

_2015-08-19_

 * Support AppCompat v23.


## Version 2.4.0

_2015-04-22_

 * Support AppCompat widgets from [AppCompat v22.1](http://android-developers.blogspot.ru/2015/04/android-support-library-221.html).
 * Support Gradle 1.1.


## Version 2.3.0

_2015-01-23_

 * Support Tint widgets from AppCompat v21.
 * Support Gradle 1.0.


## Version 2.2.0

_2014-10-06_

 * Implemented `RobotoTypefaceSpan`.
 * Use Anti-Alias rendering.
 * Support Gradle 0.13.


## Version 2.1.0

_2014-06-26_

 * Support Roboto Typefaces from Android L (Material Design).
 * Implementation of Alternative Attributes to Set the Typeface.
 * Use Sub-Pixel Rendering.
 * Support Gradle 0.11.


## Version 2.0.1

_2014-04-28_

 * Make typeface constants public.
 * Default to Roboto Regular instead of Thin when no typeface is specified.


## Version 2.0.0

_2013-12-05_

 * Separated sample from library project.
 * Pushed to Maven Central.


## Version 1.5.0

_2013-11-06_

 * Support brand new `Roboto Condensed` font from Android 4.4 ([info](http://www.theverge.com/2013/10/31/5049672/android-kit-kat-4-4-google-software-operating-system)).
 * Update Gradle build (support gradle v 1.8).


## Version 1.4.0

_2013-08-11_

 * Support brand new `Roboto` typefaces from Android 4.3 ([info](http://www.androidpolice.com/2013/06/29/typeface-teardown-roboto-gets-a-facelift-in-android-4-3/)).
 * Add Gradle build.
 * Fix: #14 RobotoMultiAutoCompleteTextView inheritance.


## Version 1.3.0

_2013-05-20_

 * Implemented of direct/indirect subclasses of TextView with native support for the Roboto fonts (`RobotoAutoCompleteTextView`, `RobotoButton`, `RobotoCheckBox`, `RobotoCheckedTextView`, `RobotoChronometer`, `RobotoCompoundButton`, `RobotoDigitalClock`, `RobotoEditText`, `RobotoExtractEditText`, `RobotoMultiAutoCompleteTextView`, `RobotoRadioButton`, `RobotoSwitch`, `RobotoTextClock`, `RobotoToggleButton`).


## Version 1.2.0

_2013-03-31_

 * Support brand new `Roboto Slab` typefaces by Google.
 * Use res-auto in namespace URI.
 * Fix: Do not try to use custom font in Eclipse Layout Editor.


## Version 1.1.0

_2013-03-20_

 * Fix: Reuse of created typefaces.
 * Fix: Support for changing the font size of the settings.


## Version 1.0.0

_2013-03-18_

Initial release.
