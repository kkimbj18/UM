import React from "react";
import LineItem from "./LineItem";
import "../css/Order.css";
import { lineItem } from "../db";

class Order extends React.Component {
  state = {
    order: this.props.order,
  };
  render() {
    const { order } = this.state;
    return (
      <div className="order">
        {lineItem.map((lineItem, index) => {
          return <LineItem lineItem={lineItem} key={index} />;
        })}
        <div className="orderInfo">
          <span className="orderName">수취인 : {order.name}</span>
          <span className="orderAddress">배송지 : {order.address}</span>
          <span className="orderphone">전화번호 : {order.phoneNumber}</span>
          <span className="orderDate">주문 날짜 : {order.date}</span>
        </div>
      </div>
    );
  }
}

export default Order;
