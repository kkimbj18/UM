import React from "react";
import Header from "../components/Header";
import Nav from "../components/Nav";
import { Link } from "react-router-dom";
import Order from "../components/Order";
import { order } from "../db";
import "../css/PurchaseHistory.css";

class PurchaseHistory extends React.Component {
  render() {
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
            {order.map((current, index) => {
              return <Order order={current} />;
            })}
          </div>
        </main>
      </div>
    );
  }
}

export default PurchaseHistory;
