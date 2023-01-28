import React from 'react';
import { FlatList, Image, StyleSheet, Text, TouchableHighlight, View } from 'react-native'
import { ProductCategories as categories } from '../data';

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
                return <Category item={item} key={index}  />;
            })}
        </View>
    );
}

const styles = {
    container: {
        marginTop: 20,
        marginHorizontal: "auto",
        paddingLeft: 0,
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
    },
    itemHighlight: {
        justifyContent: 'center',
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