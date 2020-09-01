import React from "react";
import Header from "../components/Header";
import Nav from "../components/Nav";
import { Link } from "react-router-dom";
import "../css/PurchaseHistory.css";
import {lineItem} from "../db"
import CartItem from "../components/CartItems"

class PurchaseHistory extends React.Component {
  render() {
    let order={id:77,
    userId:1,
    status:"cart",
    }
    let totalPrice=0;
    return (
      <div className="App">
        <Header />
        <Nav page={1} />
        <main>
          <Link to="/cart">
            <h1 className="mypage_title">장바구니</h1>
          </Link>
          <div className="CartOrder">
            {lineItem.map((item, index) => {
                if(item.orderId == order.id) {
                    totalPrice += item.totalPrice;
                    return <CartItem item={item}/>;
                }
            })}
            <span className="orderPrice">총 가격: {totalPrice}원</span>
          </div>
        </main>
      </div>
    );
  }
}

export default PurchaseHistory;
