#WebViewEmptyView[ ![Download](https://api.bintray.com/packages/haydar-android/maven/webview_emptyview/images/download.svg) ](https://bintray.com/haydar-android/maven/webview_emptyview/_latestVersion)<a href='https://bintray.com/haydar-android/maven/webview_emptyview?source=watch' alt='Get automatic notifications about new "webview_emptyview" versions'><img src='https://www.bintray.com/docs/images/bintray_badge_color.png'></a>


##Download

###Gradle

``` gradle
dependencies {
	compile 'io.haydar.we:webview_emptyview:1.0'
}
```

###Getting Help
``` java
  webviewEmptyView.setWebViewClient(new WebViewEmptyViewClient(this))
```
new WebviewEmptyViewClient即可
可以自定义loadview和errorview，
``` java
  public WebViewEmptyViewClient(Context context, int mErrorLayout, int mErrorLayoutId, int mLoadLayout, int mLoadLayoutId)
```

``` java
   webviewEmptyView.setWebViewClient(new WebViewEmptyViewClient(this,R.layout.view_load,R.id.load_layout,R.layout.view_error,R.id.error_layout)
```


##License

```
BottomBar library for Android
Copyright (c) 2016 Iiro Krankka (http://github.com/roughike).

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```


