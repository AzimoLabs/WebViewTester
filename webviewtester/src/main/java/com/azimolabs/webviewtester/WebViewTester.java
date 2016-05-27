package com.azimolabs.webviewtester;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/**
 * Created by maciek on 27.05.2016.
 */
public class WebViewTester {

    public static final String SUCCESS = "success";

    private WebView webView;

    public void init(WebView webView) {
        this.webView = webView;
    }

    public void reset() {
        webView = null;
    }

    // clicks handling

    public void clickOnItemWithClassName(String className) {
        clickOnItemWithClassName(className, 0, new DummyValueCallback());
    }

    public void clickOnItemWithClassName(String className, ValueCallback<String> callback) {
        clickOnItemWithClassName(className, 0, callback);
    }

    public void clickOnItemWithClassName(String className, int index) {
        clickOnItemWithClassName(className, index, new DummyValueCallback());
    }

    public void clickOnItemWithClassName(String className, int index, ValueCallback<String> callback) {
        String function = prepareClickJSFunction("document.getElementsByClassName('", className, true, index);
        webView.evaluateJavascript(function, callback);
    }

    public void clickOnItemWithId(String id) {
        clickOnItemWithId(id, new DummyValueCallback());
    }

    public void clickOnItemWithId(String id, ValueCallback<String> callback) {
        String function = prepareClickJSFunction("document.getElementById('", id, false, -1);
        webView.evaluateJavascript(function, callback);
    }

    public void clickOnItemWithName(String name) {
        clickOnItemWithName(name, 0, new DummyValueCallback());
    }

    public void clickOnItemWithName(String name, ValueCallback<String> callback) {
        clickOnItemWithName(name, 0, callback);
    }

    public void clickOnItemWithName(String name, int index) {
        clickOnItemWithName(name, index, new DummyValueCallback());
    }

    public void clickOnItemWithName(String name, int index, ValueCallback<String> callback) {
        String function = prepareClickJSFunction("document.getElementsByName('", name, true, index);
        webView.evaluateJavascript(function, callback);
    }

    private String prepareClickJSFunction(String findingString, String valueToFind, boolean hasIndexPath, int index) {
        return prepareJSFunction(findingString, valueToFind, ".click(); ", hasIndexPath, index);
    }

    // setting values
    public void setValueForItemWithClassName(String className, String newValue) {
        setValueForItemWithClassName(className, newValue, 0, new DummyValueCallback());
    }

    public void setValueForItemWithClassName(String className, String newValue, ValueCallback<String> callback) {
        setValueForItemWithClassName(className, newValue, 0, callback);
    }

    public void setValueForItemWithClassName(String className, String newValue, int index) {
        setValueForItemWithClassName(className, newValue, index, new DummyValueCallback());
    }

    public void setValueForItemWithClassName(String className, String newValue, int index, ValueCallback<String> callback) {
        String function = prepareSetValueJSFunction("document.getElementsByClassName('", className, newValue, true, index);
        webView.evaluateJavascript(function, callback);
    }

    public void setValueForItemWithId(String id, String newValue) {
        setValueForItemWithId(id, newValue, new DummyValueCallback());
    }

    public void setValueForItemWithId(String id, String newValue, ValueCallback<String> callback) {
        String function = prepareSetValueJSFunction("document.getElementById('", id, newValue, false, -1);
        webView.evaluateJavascript(function, callback);
    }

    public void setValueForItemWithName(String name, String newValue) {
        setValueForItemWithName(name, newValue, 0, new DummyValueCallback());
    }

    public void setValueForItemWithName(String name, String newValue, ValueCallback<String> callback) {
        setValueForItemWithName(name, newValue, 0, callback);
    }

    public void setValueForItemWithName(String name, String newValue, int index) {
        setValueForItemWithName(name, newValue, index, new DummyValueCallback());
    }

    public void setValueForItemWithName(String name, String newValue, int index, ValueCallback<String> callback) {
        String function = prepareSetValueJSFunction("document.getElementsByName('", name, newValue, true, index);
        webView.evaluateJavascript(function, callback);
    }

    private String prepareSetValueJSFunction(String findingString, String valueToFind, String valueToSet, boolean hasIndexPath, int index) {
        StringBuilder actionBuilder = new StringBuilder();
        actionBuilder.append(".value =  '");
        actionBuilder.append(valueToSet);
        actionBuilder.append("';");
        return prepareJSFunction(findingString, valueToFind, actionBuilder.toString(), hasIndexPath, index);
    }

    // choosing select

    public void chooseItemWithValueForSelectWithId(String selectId, String itemValue) {
        chooseItemWithValueForSelectWithId(selectId, itemValue, new DummyValueCallback());
    }

    public void chooseItemWithValueForSelectWithId(String selectId, String itemValue, ValueCallback<String> callback) {
        String function = prepareSetSelectionFunction("document.getElementById('", selectId, itemValue, false, -1);
        webView.evaluateJavascript(function, callback);
    }

    public void chooseItemWithValueForSelectWithClassName(String className, String itemValue) {
        chooseItemWithValueForSelectWithClassName(className, itemValue, 0, new DummyValueCallback());
    }

    public void chooseItemWithValueForSelectWithClassName(String className, String itemValue, ValueCallback<String> callback) {
        chooseItemWithValueForSelectWithClassName(className, itemValue, 0, callback);
    }

    public void chooseItemWithValueForSelectWithClassName(String className, String itemValue, int index) {
        chooseItemWithValueForSelectWithClassName(className, itemValue, index, new DummyValueCallback());
    }

    public void chooseItemWithValueForSelectWithClassName(String className, String itemValue, int index, ValueCallback<String> callback) {
        String function = prepareSetSelectionFunction("document.getElementsByClassName('", className, itemValue, true, index);
        webView.evaluateJavascript(function, callback);
    }

    public void chooseItemWithValueForSelectWithName(String className, String itemValue) {
        chooseItemWithValueForSelectWithName(className, itemValue, 0, new DummyValueCallback());
    }

    public void chooseItemWithValueForSelectWithName(String className, String itemValue, ValueCallback<String> callback) {
        chooseItemWithValueForSelectWithName(className, itemValue, 0, callback);
    }

    public void chooseItemWithValueForSelectWithName(String className, String itemValue, int index) {
        chooseItemWithValueForSelectWithName(className, itemValue, index, new DummyValueCallback());
    }

    public void chooseItemWithValueForSelectWithName(String className, String itemValue, int index, ValueCallback<String> callback) {
        String function = prepareSetSelectionFunction("document.getElementsByName('", className, itemValue, true, index);
        webView.evaluateJavascript(function, callback);
    }

    private String prepareSetSelectionFunction(String findingString, String valueToFind, String itemValue, boolean hasIndexPath, int index) {
        StringBuilder functionScript = new StringBuilder();

        functionScript.append("(function() { ");
        functionScript.append("var sel = ");
        functionScript.append(findingString);
        functionScript.append(valueToFind);
        functionScript.append("')");
        if (hasIndexPath) {
            functionScript.append("[");
            functionScript.append(index);
            functionScript.append("]");
        }
        functionScript.append("; ");

        functionScript.append("var opts = sel.options; ");
        functionScript.append("for (var opt, j = 0; opt = opts[j]; j++) { ");
        functionScript.append("if (opt.value == '");
        functionScript.append(itemValue);
        functionScript.append("') { ");
        functionScript.append("sel.selectedIndex = j; ");
        functionScript.append("break; }");
        functionScript.append("} ");

        functionScript.append(" return '");
        functionScript.append(SUCCESS);
        functionScript.append("'; })();");

        return functionScript.toString();
    }

    // checking items
    public void checkItemWithId(String selectId, boolean checked) {
        checkItemWithId(selectId, checked, new DummyValueCallback());
    }

    public void checkItemWithId(String selectId, boolean checked, ValueCallback<String> callback) {
        String function = prepareJSFunction("document.getElementById('", selectId, ".checked = " + checked + "; ", false, -1);
        webView.evaluateJavascript(function, callback);
    }

    public void checkItemWithClassName(String className, boolean checked) {
        checkItemWithClassName(className, checked, 0, new DummyValueCallback());
    }

    public void checkItemWithClassName(String className, boolean checked, ValueCallback<String> callback) {
        checkItemWithClassName(className, checked, 0, callback);
    }

    public void checkItemWithClassName(String className, boolean checked, int index) {
        checkItemWithClassName(className, checked, index, new DummyValueCallback());
    }

    public void checkItemWithClassName(String className, boolean checked, int index, ValueCallback<String> callback) {
        String function = prepareJSFunction("document.getElementByClassName('", className, ".checked = " + checked + "; ", true, index);
        webView.evaluateJavascript(function, callback);
    }

    public void checkItemWithName(String name, boolean checked) {
        checkItemWithName(name, checked, 0, new DummyValueCallback());
    }

    public void checkItemWithName(String name, boolean checked, ValueCallback<String> callback) {
        checkItemWithName(name, checked, 0, callback);
    }

    public void checkItemWithName(String name, boolean checked, int index) {
        checkItemWithName(name, checked, index, new DummyValueCallback());
    }

    public void checkItemWithName(String name, boolean checked, int index, ValueCallback<String> callback) {
        String function = prepareJSFunction("document.getElementByName('", name, ".checked = " + checked + "; ", true, index);
        webView.evaluateJavascript(function, callback);
    }

    // getting values

    // innerHTML
    public void getInnerHtmlOfItemWithId(String id, final ValueGetListener listener) {
        String function = prepareGetJSFunction("document.getElementById('", id, "innerHTML", false, -1);
        getValueCall(function, listener);
    }

    public void getInnerHtmlOfItemWithClassName(String className, final ValueGetListener listener) {
        String function = prepareGetJSFunction("document.getElementsByClassName('", className, "innerHTML", true, 0);
        getValueCall(function, listener);
    }

    public void getInnerHtmlOfItemWithClassName(String className, int index, final ValueGetListener listener) {
        String function = prepareGetJSFunction("document.getElementsByClassName('", className, "innerHTML", true, index);
        getValueCall(function, listener);
    }

    public void getInnerHtmlOfItemWithName(String className, final ValueGetListener listener) {
        String function = prepareGetJSFunction("document.getElementsByName('", className, "innerHTML", true, 0);
        getValueCall(function, listener);
    }

    public void getInnerHtmlOfItemWithName(String className, int index, final ValueGetListener listener) {
        String function = prepareGetJSFunction("document.getElementsByName('", className, "innerHTML", true, index);
        getValueCall(function, listener);
    }

    // value
    public void getValueOfItemWithId(String id, final ValueGetListener listener) {
        String function = prepareGetJSFunction("document.getElementById('", id, "value", false, -1);
        getValueCall(function, listener);
    }

    public void getValuelOfItemWithClassName(String className, final ValueGetListener listener) {
        String function = prepareGetJSFunction("document.getElementsByClassName('", className, "value", true, 0);
        getValueCall(function, listener);
    }

    public void getValueOfItemWithClassName(String className, int index, final ValueGetListener listener) {
        String function = prepareGetJSFunction("document.getElementsByClassName('", className, "value", true, index);
        getValueCall(function, listener);
    }

    public void getValueOfItemWithName(String className, final ValueGetListener listener) {
        String function = prepareGetJSFunction("document.getElementsByName('", className, "value", true, 0);
        getValueCall(function, listener);
    }

    public void getValueOfItemWithName(String className, int index, final ValueGetListener listener) {
        String function = prepareGetJSFunction("document.getElementsByName('", className, "value", true, index);
        getValueCall(function, listener);
    }

    // checked
    public void getCheckedStateOfItemWithId(String id, final ValueGetListener listener) {
        String function = prepareGetJSFunction("document.getElementById('", id, "value", false, -1);
        getValueCall(function, listener);
    }

    public void getCheckedStatelOfItemWithClassName(String className, final ValueGetListener listener) {
        String function = prepareGetJSFunction("document.getElementsByClassName('", className, "checked", true, 0);
        getValueCall(function, listener);
    }

    public void getCheckedStateOfItemWithClassName(String className, int index, final ValueGetListener listener) {
        String function = prepareGetJSFunction("document.getElementsByClassName('", className, "checked", true, index);
        getValueCall(function, listener);
    }

    public void getCheckedStateOfItemWithName(String className, final ValueGetListener listener) {
        String function = prepareGetJSFunction("document.getElementsByName('", className, "checked", true, 0);
        getValueCall(function, listener);
    }

    public void getCheckedStateOfItemWithName(String className, int index, final ValueGetListener listener) {
        String function = prepareGetJSFunction("document.getElementsByName('", className, "checked", true, index);
        getValueCall(function, listener);
    }

    private void getValueCall(String function, final ValueGetListener listener) {
        webView.evaluateJavascript(function, new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                if (value != null && value.startsWith("\"")) {
                    value = value.substring(1, value.length() - 1);
                }
                listener.valueObtained(value);
            }
        });
    }

    private String prepareJSFunction(String findingString, String valueToFind, String actionString, boolean hasIndexPath, int index) {
        StringBuilder functionScript = new StringBuilder();
        functionScript.append("(function() { ");
        functionScript.append(findingString);
        functionScript.append(valueToFind);
        functionScript.append("')");
        if (hasIndexPath) {
            functionScript.append("[");
            functionScript.append(index);
            functionScript.append("]");
        }
        functionScript.append(actionString);
        functionScript.append(" return '");
        functionScript.append(SUCCESS);
        functionScript.append("'; })();");

        return functionScript.toString();
    }

    private String prepareGetJSFunction(String findingString, String valueToFind, String gettingString, boolean hasIndexPath, int index) {
        StringBuilder functionScript = new StringBuilder();
        functionScript.append("(function() { ");
        functionScript.append("var item = ");
        functionScript.append(findingString);
        functionScript.append(valueToFind);
        functionScript.append("')");
        if (hasIndexPath) {
            functionScript.append("[");
            functionScript.append(index);
            functionScript.append("]");
        }
        functionScript.append("; return item.");
        functionScript.append(gettingString);
        functionScript.append("; })();");

        return functionScript.toString();
    }

    public interface ValueGetListener {

        void valueObtained(String value);

    }

    private static class DummyValueCallback implements ValueCallback<String> {

        @Override
        public void onReceiveValue(String value) {
            // do nothing
        }

    }

}