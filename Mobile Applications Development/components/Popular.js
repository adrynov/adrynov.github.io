import React from 'react'
import { Image, FlatList, StyleSheet, Text, TouchableHighlight, View } from 'react-native'

import { PopularProducts as products } from '../data';

const images = new Array(11).fill('https://placehold.co/600x360');

const Item = ({ item }) => {
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

function Popular() {
  return (
    <View style={styles.container}>
      <Text style={styles.header}>Popular</Text>
      <View style={styles.container}>
            {products.map((item, index) => {
                return <Item item={item} key={index}  />;
            })}
        </View>
    </View>
  )
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
  headerText: {
    color: '#fff'
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
  },
  header: {
    fontSize: 30,
    fontWeight: 'bold',
    color: "#fff",
    paddingLeft: 20,
},
};


export default Popular;