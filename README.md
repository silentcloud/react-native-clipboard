# react-native-clipboard

React Native component for getting or setting clipboard content

## Usage

```javascript
npm install react-native-cilpboard --save
```

In XCode, in the project navigator, right click Libraries ➜ Add Files to [your project's name], Go to node_modules ➜ react-native-clipboard and add the `RNClipboard.xcodeproj` file

In XCode, in the project navigator, select your project. Add the lib*.a from the RNClipboard project to your project's Build Phases ➜ Link Binary With Libraries Click `RNClipboard.xcodeproj` file you added before in the project navigator and go the Build Settings tab. Make sure 'All' is toggled on (instead of 'Basic'). Look for Header Search Paths and make sure it contains  both $(SRCROOT)/../react-native/React and $(SRCROOT)/../../React - mark both as recursive.

Run your project (Cmd+R)

## Examples

```javascript

var Clipboard = require('react-native-clipboard');

Clipboard.get(content => {
  console.log(content);
});

Clipboard.set('abc');

```

