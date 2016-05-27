# WebViewTester

Uses JavaScript calls to automate interaction with web pages displayed in Android WebViews. Could be especially helpful in testing.

So far it provides methods to:
```
- getting HTML elements innerHTML
- getting HTML elements value
- setting HTML elements value
- setting HTML elements checked state
- select one of items in HTML <select>
- click on HTML element
```

All mentioned methods find element either by its id, name or className. When name or className used, element index in page's class/name elements list could be also used.
Methods allow to use callback which will be executed after method ended.

Works on Android KitKat and above. WebView has to enable JavaScript support.

# Usage

You can import it using gradle dependencies (tbd), or by simple coping WebViewTester class from gitHub project automator module.

Examples of usage are shown in sample application.