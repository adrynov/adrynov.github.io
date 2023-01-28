import React from 'react';
import { Image, StyleSheet, Text, View } from 'react-native'

const Categories = () => {
    return (
        <View style={styles.container}>
            <Text style={styles.text1}>Hello</Text>
            <Text style={styles.text1}>how are you??</Text>
            <View style={styles.categories}>
                
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    container: { paddingTop: 40 },
    text1: {
        fontSize: 30,
        fontWeight: 'bold',
        color: "#fff"
    },
    categories: {
        marginTop: 30,
        flexDirection: 'row',
        flexWrap: 'wrap',
        justifyContent: 'space-between',
    }
});


export default Categories;