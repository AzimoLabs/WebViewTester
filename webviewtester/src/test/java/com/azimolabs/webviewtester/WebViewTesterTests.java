package com.azimolabs.webviewtester;

import android.webkit.ValueCallback;
import android.webkit.WebView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

/**
 * Created by maciek on 27.05.2016.
 */
public class WebViewTesterTests {

    @Mock
    WebView webViewMock;

    WebViewTester tester;

    @Captor
    ArgumentCaptor<ValueCallback> callbackArgumentCaptor;

    private String receivedValue;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        tester = new WebViewTester();
        tester.init(webViewMock);
    }

    @After
    public void tearDown() {
        tester.reset();
        receivedValue = null;
    }

    @Test
    public void testShouldGettingInnerHTMLReturnTextWithoutQuotes() {
        tester.getInnerHtmlOfItemWithClassName("sampleClassName", new WebViewTester.ValueGetListener() {
            @Override
            public void valueObtained(String value) {
                receivedValue = value;
            }
        });
        verify(webViewMock).evaluateJavascript(anyString(), callbackArgumentCaptor.capture());

        ValueCallback callback = callbackArgumentCaptor.getValue();
        callback.onReceiveValue("\"sample_value\"");

        assertEquals(receivedValue, "sample_value");
    }

    @Test
    public void testShouldGettingValueReturnTextWithoutQuotes() {
        tester.getValueOfItemWithId("sampleId", new WebViewTester.ValueGetListener() {
            @Override
            public void valueObtained(String value) {
                receivedValue = value;
            }
        });
        verify(webViewMock).evaluateJavascript(anyString(), callbackArgumentCaptor.capture());

        ValueCallback callback = callbackArgumentCaptor.getValue();
        callback.onReceiveValue("\"sample_value\"");

        assertEquals(receivedValue, "sample_value");
    }

}