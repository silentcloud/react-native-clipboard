# react-native-clipboard

React Native component for getting or setting clipboard content

## Usage

```javascript
npm install react-native-clipboard --save
```
## iOS
In XCode, in the project navigator, right click Libraries ➜ Add Files to [your project's name], Go to node_modules ➜ react-native-clipboard and add the `RNClipboard.xcodeproj` file

In XCode, in the project navigator, select your project. Add the lib*.a from the RNClipboard project to your project's Build Phases ➜ Link Binary With Libraries Click `RNClipboard.xcodeproj` file you added before in the project navigator and go the Build Settings tab. Make sure 'All' is toggled on (instead of 'Basic'). Look for Header Search Paths and make sure it contains  both $(SRCROOT)/../react-native/React and $(SRCROOT)/../../React - mark both as recursive.

Run your project (Cmd+R)

## Android
* In `android/setting.gradle`

```gradle
...
include ':react-native-clipboard'
project(':react-native-clipboard').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-clipboard/RNClipboardAndroid/app')
```

* In `android/app/build.gradle`

```gradle
...
dependencies {
    ...
    compile project(':react-native-clipboard')
}
```

* register module (in MainActivity.java)

```java

import com.davidsandor.rnclipboardandroid.RNClipboardAndroidPackage;;  // <--- import

public class MainActivity extends Activity implements DefaultHardwareBackBtnHandler {
  ......

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mReactRootView = new ReactRootView(this);

    mReactInstanceManager = ReactInstanceManager.builder()
      .setApplication(getApplication())
      .setBundleAssetName("index.android.bundle")
      .setJSMainModuleName("index.android")
      .addPackage(new MainReactPackage())
      .addPackage(new RNClipboardAndroidPackage())              // <------ add here
      .setUseDeveloperSupport(BuildConfig.DEBUG)
      .setInitialLifecycleState(LifecycleState.RESUMED)
      .build();

    mReactRootView.startReactApplication(mReactInstanceManager, "example", null);

    setContentView(mReactRootView);
  }

  ......

}
```

## Examples

```javascript

var Clipboard = require('react-native-clipboard');

Clipboard.get(content => {
  console.log(content);
});

Clipboard.set('abc');

```

