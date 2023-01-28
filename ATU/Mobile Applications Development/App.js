import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';

import Header  from './components/Header';
import Categories from './components/Categories';

export default function App() {
  return (
    <View style={styles.container}>
      <Header />
      <Categories />
      {/* 
			
			<Popular /> */}
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 24,
    paddingTop: 55,
    paddingBottom: 75,
    backgroundColor: '#000',  
    alignItems: 'center',
    justifyContent: 'center',
  },
  text: {
    color: "#fff",
  },
  text1: {
    fontSize: 30,
    fontWeight: 'bold',
    color: "#fff"
},
});
