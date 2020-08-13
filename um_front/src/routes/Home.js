import React from "react";
import Nav from "../components/Nav";
import Header from "../components/Header";
import Sample from "../components/Sample";
import "../css/Home.css";
import axios from "axios";

class Home extends React.Component {
  state = {
    products: [],
    items: [],
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
    const { items } = this.state;
    return (
      <div className="App">
        <Header />
        <Nav />
        <main className="main">
          <div className="samples">
            {items.map((item, index) => {
              return (
                <Sample
                  key={index}
                  name={item.name}
                  price={item.price}
                  photo={item.image}
                  rating={item.rating}
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
