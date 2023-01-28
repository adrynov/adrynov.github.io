import React from 'react';
import { Image, StyleSheet, Text, TouchableHighlight, View } from 'react-native'
import { categories } from '../data/categories';

const Category = (category, index) => (
    <View style={styles.categoryContainer}>
        <Text style={styles.category}>category</Text>
    </View>
);

const Categories = () => {
    return (
        <View style={styles.container}>
            <Text style={styles.text1}>Hello</Text>
            <Text style={styles.text1}>how are you??</Text>
            <View style={styles.categories}>
                {categories.map((category, index) =>
                    // <Text style={styles.category}>Hello</Text>
                    <Category category="category"></Category>
                    // <TouchableHighlight
                    //     underlayColor='#EE1C0E'
                    //     style={{
                    //         height: 100,
                    //         justifyContent: 'center',
                    //         borderRadius: '50%',
                    //         paddingLeft: 5,
                    //         paddingRight: 5,
                    //         backgroundColor: '#111111',
                    //     }}
                    // >
                    //     <View style={{ alignItems: 'center' }}>
                    //         <Image
                    //             source={{ uri: category.image }}
                    //             style={{ width: 40, height: 40, borderRadius: '50%' }}
                    //         />
                    //         <Text
                    //             style={{
                    //                 fontSize: 14,
                    //                 color: '#fff',
                    //                 marginTop: 10,
                    //                 textAlign: 'center',
                    //             }}
                    //         >
                    //             {category.name}
                    //         </Text>
                    //     </View>
                    // </TouchableHighlight>
                )}
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
    },
    categoryContainer: {
        width: '30%',
        marginBottom: 20,
    },
    category: {
        color: "#fff",
    }

});


export default Categories;