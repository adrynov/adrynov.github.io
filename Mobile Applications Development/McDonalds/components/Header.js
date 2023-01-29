import React from "react";
import { Image, Linking, TouchableHighlight, StyleSheet, Text, View } from "react-native";

const Header = () => {
    return (
        <View styles={styles.container}>
            <View>
                <TouchableHighlight onPress={() => Linking.openURL("https://www.mcdonalds.com/ie/en-ie.html")}>
                    <Image
                        source={{
                              uri: "https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/McDonald%27s_Golden_Arches.svg/2339px-McDonald%27s_Golden_Arches.svg.png",                                                        
                        }}
                        style={styles.logo}
                    />
                    {/* <Image source={require('./logo.png')}  style={styles.logo} /> */}
                </TouchableHighlight>
            <Text style={styles.header}>Hello, how are you??</Text>
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
        width: 60, height: 50
    },
    header: {
        marginTop: 10,
        fontSize: 30,
        fontWeight: 'bold',
        color: "#fff"
    },
  });
  

export default Header;
