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