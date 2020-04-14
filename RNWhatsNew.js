import React, { PureComponent } from "react";
import { ViewPropTypes, NativeModules, Platform } from "react-native";
import RNImageHelper from "react-native-image-helper"

import PropTypes from "prop-types";

const { RNWhatsNew } = NativeModules;

class WhatsNew extends PureComponent {
    static propTypes = {
        ...ViewPropTypes,
    };

    static defaultProps = {
        titleColor: '',
        itemTitleColor: '',
        itemSubtitleColor: '',
        buttonTextColor: '',
        buttonBackgroundColor: ''
    };

    static Show(props) {
        props.items = props.items.map(element => {
            if (element.title === undefined) element.title = "";
            if (element.subtitle === undefined) element.subtitle = "";

            if (element.icon && element.icon.props) {
                element.icon = element.icon.props;

                let vectorIcon = RNImageHelper.Resolve(element.icon.family, element.icon.name);
                element.icon = Object.assign({}, element.icon, vectorIcon);
            } else if (element.icon !== undefined) {
                element.icon = { name: element.icon, family: "", glyph: "", color: "", size: 0 };
            } else {
                element.icon = {}
            }

            return element;
        });

        if (props.titleColor === undefined) props.titleColor = WhatsNew.defaultProps.titleColor
        if (props.itemTitleColor === undefined) props.itemTitleColor = WhatsNew.defaultProps.itemTitleColor
        if (props.itemSubtitleColor === undefined) props.itemSubtitleColor = WhatsNew.defaultProps.itemSubtitleColor
        if (props.buttonTextColor === undefined) props.buttonTextColor = WhatsNew.defaultProps.buttonTextColor
        if (props.buttonBackgroundColor === undefined) props.buttonBackgroundColor = WhatsNew.defaultProps.buttonBackgroundColor

        RNWhatsNew.Show(
            props,
            (...args) => {
                props.onDone && props.onDone(...args);
            },
            (...args) => {
                props.onCancel && props.onCancel(...args);
            }
        );
    }
}

export { WhatsNew as RNWhatsNew }