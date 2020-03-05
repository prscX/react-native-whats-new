import React, { PureComponent } from "react";
import { ViewPropTypes, NativeModules, Platform } from "react-native";
import PropTypes from "prop-types";

const { RNWhatsNew } = NativeModules;

class WhatsNew extends PureComponent {
    static propTypes = {
        ...ViewPropTypes,
    };

    static defaultProps = {
    };

    static Show(props) {
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