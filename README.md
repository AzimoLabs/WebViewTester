# WebViewTester

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-WebViewTester-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/3660)

Android tool to automate interaction with web pages displayed in Android WebViews. Could be especially helpful in testing UI with Espresso.

So far it provides methods to:
```
- get value
- set value
- set checked state
- click on element
- pick one of items from <select>
- get inner HTML
```

All mentioned methods find element either by its id, name or className. When there are more elements returned by name or className selector, we can use additional index parameter.

Methods allow to use callbacks which will be executed after method ends.

Works on Android KitKat and above. WebView has to have JavaScript support enabled.

## Download

### Library dependency

```gradle
dependencies {
  compile 'com.azimolabs.webviewtester:webviewtester:0.1'
}
```

### Java code

If you don't want to add another dependency to your project, just copy [WebViewTester.java](https://github.com/AzimoLabs/WebViewTester/blob/master/webviewtester/src/main/java/com/azimolabs/webviewtester/WebViewTester.java) class to your source directory.

Examples of usage are shown in sample application.

## License

    Copyright (C) 2016 Azimo

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

