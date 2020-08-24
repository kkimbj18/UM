import React from "react";
import { item } from "../db";

class LineItem extends React.Component {
  state = {
    lineItem: this.props.lineItem,
  };

  mkfnc = () => {
    item.map((item) => {
      if (this.state.lineItem.itemId === item.id) {
        return item;
      }
    });
  };

  constructor() {}

  render() {
    const { lineItem } = this.state;
    return (
      <div className="lineItem">
        <div className="lineItemImage"></div>
        <div className="lineItemName"></div>
        <div className="lineItemQuantity">{lineItem.quantity}</div>
        <div className="lineItemPrice">{lineItem.totalPrice}</div>
      </div>
    );
  }
}

export default LineItem;
