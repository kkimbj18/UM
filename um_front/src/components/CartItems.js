import React from "react"
import {item} from "../db"

class CartItem extends React.Component {

    state={
        quantity: this.props.item.quantity,
        totalPrice: this.props.item.totalPrice,
        oneItemPrice: this.props.item.totalPrice
    }

    mkfnc = (item) => {
        let current_item;
        item.map((current) => {
          if (this.props.item.itemId === current.id) {
            current_item = current;
          }
        });
        return current_item;
      };


      plus = () => {
        this.setState(current => ({
            quantity: current.quantity + 1,
            totalPrice: current.totalPrice + current.oneItemPrice,
        }));
      }

      minus = () => {
        if (this.state.quantity > 1) {
            this.setState(current => ({
                quantity: current.quantity - 1,
                totalPrice: current.totalPrice - current.oneItemPrice,
            }));
        }
      }

    render() {
        const{ item: cartItem } = this.props;
        const current_item = this.mkfnc(item);
        return(<div className="lineItem">
            <img className="lineItemImage" src={current_item.image}></img>
            <div className="lineItemName">{current_item.name}</div>
            <button className="minus btn" onClick={this.minus}>-</button>
            <div className="lineItemQuantity">{this.state.quantity}개</div>
            <button className="plus btn" onClick={this.plus}>+</button>
            <div className="lineItemPrice">{this.state.totalPrice}원</div>
        </div>);
    }
}

export default CartItem;