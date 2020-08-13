import React from "react";
import Header from "../components/Header";
import Nav from "../components/Nav";
import { Link } from "react-router-dom";
import Order from "../components/Order";

class PurchaseHistory extends React.Component {
  state = {
    orders: [
      {
        id: 1,
        userId: 1,
        quantity: 100,
        status: "cart",
        name: "박상혁",
        address: "오산",
        phoneNumber: "010-4062-5986",
        date: "2020-08-13",
      },
    ],
  };

  render() {
    const { orders } = this.state;
    return (
      <div className="App">
        <Header />
        <Nav page={1} />
        <main>
          <Link to="/my_page">
            <h1 className="mypage_title">마이 페이지</h1>
          </Link>
          <div className="myinfo_title">구매 내역</div>
          <div className="Orders">
            {orders.map((order, index) => {
              return <Order order={order} />;
            })}
          </div>
        </main>
      </div>
    );
  }
}

export default PurchaseHistory;
