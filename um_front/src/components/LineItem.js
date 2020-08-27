import React from "react";
import { item } from "../db";

class LineItem extends React.Component {
  state = {
    lineItem: this.props.lineItem,
  };

  mkfnc = (items) => {
    let current_item;
    items.map((current) => {
      if (this.state.lineItem.itemId === current.id) {
        current_item = current;
      }
    });
    return current_item;
  };

  render() {
    const { lineItem } = this.state;
    const current_item = this.mkfnc(item);
    return (
      <div className="lineItem">
        <img className="lineItemImage" src={current_item.image}></img>
        <div className="lineItemName">{current_item.name}</div>
        <div className="lineItemQuantity">{lineItem.quantity}개</div>
        <div className="lineItemPrice">{lineItem.totalPrice}원</div>
      </div>
    );
  }
}

export default LineItem;
