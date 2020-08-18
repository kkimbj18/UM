import React from "react";
import Nav from "../components/Nav";
import Header from "../components/Header";
import Sample from "../components/Sample";
import "../css/Home.css";
import axios from "axios";
import {item, product} from '../db';

class Home extends React.Component {

  checkUser = async () => {
    try {
      const check = await axios.get(
        "http://ec2-3-34-81-212.ap-northeast-2.compute.amazonaws.com:8080/check"
      );
      console.log(check);
    } catch (error) {
      console.log(error);
      alert("문제가 생겨스빈다.");
    }
  };

  componentDidMount() {
    this.checkUser();
  }

  render() {
    const items = item;
    const products = product;
    
    for(let i =0; i<products.length; i++){
      for(let j=0; j<items.length; j++){
        if(items[j].product_id == products[i].id){
          products[i].price = items[j].price <= products[i].price ? items[j].price : products[i].price;
        }
      }
    }

    return (
      <div className="App">
        <Header />
        <Nav />
        <main className="main">
          <div className="samples">
            {products.map((products, index) => {
              return (
                <Sample
                  key={index}
                  product={products}
                />
              );
            })}
          </div>
        </main>
      </div>
    );
  }
}

export default Home;
