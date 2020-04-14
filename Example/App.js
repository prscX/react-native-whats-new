import React, { Component } from 'react'
import { StyleSheet, Text, View, TouchableOpacity } from 'react-native'
import { RNWhatsNew } from '@prscx/react-native-whats-new'

import Icon from "react-native-vector-icons/FontAwesome";

Icon.loadFont()

type Props = {
}

export default class App extends Component<Props> {
  _onPress = () => {
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
      onDone: () => {
        console.log('on done');
      },
      onCancel: () => {
        console.log('on cancel');
      },
    });
  }

  render() {
    return (
      <View style={styles.container}>
        <TouchableOpacity onPress={this._onPress}>
          <Text>Click</Text>
        </TouchableOpacity>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF'
  }
})