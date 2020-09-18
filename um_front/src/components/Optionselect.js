import React, { Component } from "react";
import { product } from "../db";
import { Link } from "react-router-dom";
import { brand } from "../db";
import { item } from "../db";
import "../css/Itemdetail.css";

function getitem(item, productid) {
  let thisitem = {};
  for (let i = 0; i < item.length; i++) {
    if (item[i].product_id == productid) {
      thisitem = item[i];
      break;
    }
  }
  return thisitem;
}

const select_amount = ({ price }) => {
  let amount = 1;
  let option = document.getElementById("option_select");
  if (option != "default") {
    return (
      <div className="wrap-selected-opt">
        <ul>
          <li className="select-opt">
            <div className="opt">
              {option.color},{option.size}
            </div>
            <div className="amount">1</div>
            <div className="price">{price * amount}</div>
          </li>
        </ul>
      </div>
    );
  }
};

class Option extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    console.log(this.props.product.id);
    let items = item;
    let this_item = getitem(items, this.props.product.id);
    return (
      <div>
        <div className="option-box-cover">
          <select id="option_select" className="option-box">
            <option selected="selected" value="default">
              옵션 선택
            </option>
            <option value={this_item}>
              {this_item.color} / (사이즈 : {this_item.size})
            </option>
          </select>
          {select_amount(1000)}
        </div>
        <div className="total-price-box">
          총 합계
          <span className="total-price">{}원</span>
        </div>
      </div>
    );
  }
}

export default Option;
