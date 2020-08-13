import React from "react";
import Nav from "../components/Nav";
import Header from "../components/Header";
import Sample from "../components/Sample";
import "../css/Home.css";
import axios from "axios";

class Home extends React.Component {
  state = {
    items: [
      {
        id:1,
        product_id:1,
        size:"free",
        color:"blue",
        remain: 323,
        price: 15000,
      },
      {
        id: 2,
        product_id: 2,
        size: "free",
        color: "red",
        remain: 355,
        price: 15000,
      },
      {
        id: 3,
        product_id: 3,
        size: "free",
        color: "green",
        remain: 123,
        price: 15000,
      },
    ],
    products: [
      {id: 1,
        brandid: 1,
        name: "엄",
        rating: 3.5,
        soldAmount: 423,
        category_1: "엄준식",
        category_2: "아무무",
        image: "data:image/jpeg;base64,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",
        price: 99999,
      },
      {
        id: 2,
        brandid: 1,
        name: "준",
        rating: 4.0,
        soldAmount: 333,
        category_1: "엄준식",
        category_2: "아무무",
        image: "data:image/jpeg;base64,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",
        price:99999,
      },
      {
        id: 3,
        brandid: 1,
        name: "식",
        rating: 4.2,
        soldAmount: 1928,
        category_1: "엄준식",
        category_2: "아무무",
        image: "data:image/jpeg;base64,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",
        price:99999,
      },
    ],
  };

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
    const { items, products } = this.state;
    
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
