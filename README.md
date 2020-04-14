<h1 align="center">

<p align="center">
  <a href="https://www.npmjs.com/package/react-native-whats-new"><img src="http://img.shields.io/npm/v/react-native-whats-new.svg?style=flat" /></a>
  <a href="https://github.com/prscX/react-native-whats-new/pulls"><img alt="PRs Welcome" src="https://img.shields.io/badge/PRs-welcome-brightgreen.svg" /></a>
  <a href="https://github.com/prscX/react-native-whats-new#License"><img src="https://img.shields.io/npm/l/react-native-whats-new.svg?style=flat" /></a>
</p>


    ReactNative: Native WhatsNew (Android/iOS)

If this project has helped you out, please support us with a star 🌟
</h1>

RNWhatsNew enables you to easily showcase your awesome new app features. This library is a React Native bridge around native whats new libraries.


| **Android: [TonnyL/WhatsNew](https://github.com/TonnyL/WhatsNew)**             |
| ----------------- |


| **iOS: [SvenTiigi/WhatsNewKit](https://github.com/SvenTiigi/WhatsNewKit)**             |
| ----------------- |


## 📖 Getting started

`$ yarn add react-native-whats-new`
`$ yarn add react-native-vector-icons`

- **iOS**

> **iOS Prerequisite:** Please make sure `CocoaPods` is installed on your system

	- Add the following to your `Podfile` -> `ios/Podfile` and run pod update:

```
  use_native_modules!

  pod 'RNVectorIcons', :path => '../node_modules/react-native-vector-icons'
  pod 'RNWhatsNew', :path => '../node_modules/@prscx/react-native-whats-new/ios'

  use_frameworks!

  pod 'WhatsNewKit', :git => 'https://github.com/prscX/WhatsNewKit', :branch => 'react-native'
```

- **Android**

- Please add below script in your build.gradle

```
buildscript {
    repositories {
        maven { url "https://jitpack.io" }
        ...
    }
}

allprojects {
    repositories {
        maven { url "https://jitpack.io" }
        ...
    }
}
```


## 💻 Usage

```
let facebook, instagram, skype

if (Platform.OS === 'android') {
    facebook = (
    <Icon name={'twitter.png'} color={'#000000'} size={40} />
    );
    instagram = (
    <Icon name={'twitter.png'} color={'#000000'} size={40} />
    );
    skype = <Icon name={'twitter.png'} color={'#000000'} size={40} />;
} else {
    facebook = (
    <Icon
        name={'facebook'}
        color={'#000000'}
        size={40}
        family={'FontAwesome'}
    />
    );
    instagram = (
    <Icon
        name={'instagram'}
        color={'#000000'}
        size={40}
        family={'FontAwesome'}
    />
    );
    skype = (
    <Icon
        name={'skype'}
        color={'#000000'}
        size={40}
        family={'FontAwesome'}
    />
    );
}

RNWhatsNew.Show({
    title: 'Whats New',
    titleColor: '#545444',
    buttonTextColor: '#FFFFFF',
    buttonBackgroundColor: '#2777AE',
    items: [
    {
        title: 'Feature 1 Title',
        subtitle: 'Feature 1 Subtitle',
        icon: facebook
    },
    {
        title: 'Feature 2 Title',
        subtitle: 'Feature 2 Subtitle',
        icon: instagram
    },
    {
        title: 'Feature 3 Title',
        subtitle: 'Feature 3 Subtitle',
        icon: skype
    }
    ],
    onDone: () => {s}
});
```

> * Purpose of this library is to edit photos which are within app sandbox, we recommend to move captured image to app sandbox then using RNFS share image path with library for the edit.

> * Example: If we capture image through cameraRoll then we should first move image to app sandbox using RNFS then share app storage path with the editor.

## 💡 Props

- **General(iOS & Android)**

| Prop                   | Type                | Default | Note                                             |
| ---------------------- | ------------------- | ------- | ------------------------------------------------ |
| `title`     | `string`            |         | Specify title of the slider                 |
| `titleColor`     | `string: [HEX-COLOR]`            |         | Specify title color value                 |
| `items`     | `array`            |         | Specify items [Features] needs to be displayed                 |
| `buttonBackgroundColor`     | `string: [HEX-COLOR]`            |         | Specify color of bottom button                 |

- **Android Props**

| Prop                   | Type                | Default | Note                                             |
| ---------------------- | ------------------- | ------- | ------------------------------------------------ |
| `itemTitleColor`     | `string: [HEX-COLOR]`            |         | Specify item title color                 |
| `itemSubtitleColor`     | `string [HEX-COLOR]`            |         | Specify item subtitle color                 |
| `buttonTextColor`     | `string [HEX-COLOR]`            |         | Specify bottom button text color                 |

- **iOS Props**

| Prop                   | Type                | Default | Note                                             |
| ---------------------- | ------------------- | ------- | ------------------------------------------------ |

## Icons

- **RN Vector Icons:** It supports [react-native-vector-icons](https://github.com/oblador/react-native-vector-icons) library. Please find below snippet for the usage:

```javascript
	let facebook = <Icon family={'FontAwesome'} name={'facebook'} color={'#000000'} size={30} />

	<RNPopover.Menu label={"Facebook"} icon={facebook} />
```

> **Note:**
> - We have added `family` prop for `Icon` class, please make sure that you pass the props


- **Custom Icons**

> **Note:**
> Since we are using native libraries, we have not found a solution in order to render RN Images in production, therefore please copy all your image assets in platform specific folders:

- Android: Please copy your image assets in app resource drawable folder
- iOS: Please copy your image assets in app resources folder

> Please refer example application for the image usage.


## ✨ Credits

- Android: [TonnyL/WhatsNew](https://github.com/TonnyL/WhatsNew)
- iOS: [SvenTiigi/WhatsNewKit](https://github.com/SvenTiigi/WhatsNewKit)

## 🤔 How to contribute
Have an idea? Found a bug? Please raise to [ISSUES](https://github.com/prscX/react-native-whats-new/issues).
Contributions are welcome and are greatly appreciated! Every little bit helps, and credit will always be given.

## 💫 Where is this library used?
If you are using this library in one of your projects, add it in this list below. ✨


## 📜 License
This library is provided under the Apache 2 License.

RNPhotoEditor @ [prscX](https://github.com/prscX)

## 💖 Support my projects
I open-source almost everything I can, and I try to reply everyone needing help using these projects. Obviously, this takes time. You can integrate and use these projects in your applications for free! You can even change the source code and redistribute (even resell it).

However, if you get some profit from this or just want to encourage me to continue creating stuff, there are few ways you can do it:
* Starring and sharing the projects you like 🚀
* If you're feeling especially charitable, please follow [prscX](https://github.com/prscX) on GitHub.

  <a href="https://www.buymeacoffee.com/prscX" target="_blank"><img src="https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png" alt="Buy Me A Coffee" style="height: auto !important;width: auto !important;" ></a>

  Thanks! ❤️
  <br/>
  [prscX.github.io](https://prscx.github.io)
  <br/>
  </ Pranav >
