import React from 'react';
import { FlatList, Image, StyleSheet, Text, TouchableHighlight, View } from 'react-native'
import { categories } from '../data/categories';

const Category = ({ item }) => {
    return <View style={styles.item}>
        <TouchableHighlight underlayColor='#EE1C0E' style={styles.itemHighlight}>
            <View style={{ alignItems: 'center' }}>
                <Image
                    source={{ uri: item.image }}
                    style={styles.itemImage}
                />
                <Text style={styles.itemText}>{item.name}</Text>

            </View>
        </TouchableHighlight>
    </View>;
};

const Categories = () => {
    return (
        <View style={styles.container}>
            {categories.map((item, index) => {
                return <Category item={item}  />;
            })}
        </View>

        
    );
}

const styles = {
    container: {
        marginTop: 20,
        marginHorizontal: "auto",
        width: 400,
        flexDirection: "row",
        flexWrap: "wrap"
    },
    item: {
        flex: 1,
        minWidth: 100,
        maxWidth: 100,
        height: 100,
        width: '30%',
        justifyContent: "center",
        alignItems: "center",

        // paddingLeft: 10,
        // paddingRight: 10,
        //  marginTop: 10,
    },
    itemHighlight: {
        justifyContent: 'center',
        // borderRadius: '50%',
        paddingLeft: 5,
        paddingRight: 5,
        backgroundColor: '#111111',
    },
    itemImage: {
        width: 50, height: 50
    },
    itemText: {
        color: '#fff',
        fontSize: 14,
        marginTop: 10,
    }
};

export default Categories;