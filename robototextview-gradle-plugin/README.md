RobotoTextView Gradle Plugin
============================

Gradle plugin for removing unused roboto fonts.


Download
--------

Add the plugin dependency:

``` groovy
buildscript {
    repositories {
        maven { url "https://oss.sonatype.org/content/repositories/snapshots" }
    }
    dependencies {
        classpath 'com.github.johnkil.android-robototextview:robototextview-gradle-plugin:3.0.0-SNAPSHOT'
    }
}
```

and then apply it in your module:

```groovy
apply plugin: 'com.devspark.robototextview.gradle-plugin'
```


Usage
-----

To specify the fonts that you want to exclude:

```groovy
robototextview {
    exclude 'RobotoSlab', 'RobotoMono'
}
```

or specify only those fonts that you want to include:

```groovy
robototextview {
    include 'Roboto', 'RobotoCondensed'
}
```

_Note: Don't use `include` and `exclude` together._


License
-------

    Copyright 2017 Evgeny Shishkin

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
