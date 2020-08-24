import React from "react";
import LineItem from "./LineItem";
import "../css/Order.css";

class Order extends React.Component {
  state = {
    lineItems: [
      { id: 1, orderId: 1, itemId: 1, quantity: 1 },
      { id: 2, orderId: 1, itemId: 2, quantity: 1 },
    ],
    order: this.props.order,
  };
  render() {
    const { lineItems, order } = this.state;
    return (
      <div className="order">
        {lineItems.map((lineItem, index) => {
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
