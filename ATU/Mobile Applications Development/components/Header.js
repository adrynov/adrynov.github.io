import React from "react";
import { Image, Linking, TouchableHighlight, StyleSheet, View } from "react-native";

const Header = () => {
    return (
        <View styles={styles.container}>
            <View>
                <TouchableHighlight onPress={() => Linking.openURL("https://www.mcdonalds.com/ie/")}
                >
                    <Image
                        source={{
                              uri: "https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/McDonald%27s_Golden_Arches.svg/2339px-McDonald%27s_Golden_Arches.svg.png",
                            // uri: 'assets/images/logo.png'
                        }}
                        style={styles.logo}
                    />
                </TouchableHighlight>
            </View>          
        </View>
    );
};


const styles = StyleSheet.create({
    container: {
        flexDirection: "row",
        alignItems: "center",
        justifyContent: "space-between",
    },
    logo: {
        width: 51,
        height: 45,
    },
    text: {
      color: "#fff",
    }
  });
  

export default Header;
