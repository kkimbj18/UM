import React from "react";
import Nav from "../components/Nav";
import Header from "../components/Header";
import Sample from "../components/Sample";
import "../css/Home.css";
import axios from "axios";
import { item } from "../db";
import qs from "qs";

class Search extends React.Component {
  state = {
    token: localStorage.getItem('token'),
    account: localStorage.getItem('authenticatedUser'),
  };

  getQurey = ({ location }) => {
    const query = qs.parse(location.search, {
      ignoreQueryPrefix: true
    });
    const detail = query.detail === 'true';
    return query;
  }

  getProducts = async(name) => {
    let products = [];
    try {
      products = await axios.get(`http://ec2-3-34-81-212.ap-northeast-2.compute.amazonaws.com:8080/search/${name}`);
    }catch(error) {
      console.log(error);
      products = []
    }
    return products;
  }

  render() {
    const items = item;
    console.log(this.props);
    const query = this.getQurey(this.props)
    const { name } = query;
    console.log(name);
    let products = [];
    products = this.getProducts(name);
    console.log(products);

    return (
      <div className="App">
        <Header />
        <Nav />
        <main className="main">
          <div className="samples">
            {products.length === 0 ? products.map((products, index) => {
              return <Sample key={index} product={products} />;
            }): (<span>{name}의 검색 결과가 없어용</span>)}
          </div>
        </main>
      </div>
    );
  }
}

export default Search;
