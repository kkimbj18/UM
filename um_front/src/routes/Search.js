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
          <h4>{name}의 검색 결과입니다.</h4>
          <div className="samples">
            {name === "안윤회" ? (<div className="noResult"><img src="http://software.ajou.ac.kr/bbs/data/professor/5eedf970_Yenewondim.PNG"></img>
            <span>생일 축하한다.</span></div>) : products.length === 0 ? products.map((products, index) => {
              return <Sample key={index} product={products} />;
            }): (<div className="noResult"><img src="https://dimg.donga.com/wps/NEWS/IMAGE/2019/10/09/97794110.4.jpg"></img>
            <span>검색 결과가 없어용</span></div>)}
          </div>
        </main>
      </div>
    );
  }
}

export default Search;
