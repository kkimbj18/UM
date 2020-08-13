import React from "react";
import "../css/Nav.css";
import Category from "./Category";
import { Link } from "react-router-dom";

class Nav extends React.Component {
  state = {
    cartegories: [
      { name: "상의" },
      { name: "하의" },
      { name: "외투" },
      { name: "신발" },
      { name: "장갑" },
      { name: "액쉐숴리" },
    ],
  };
  render() {
    const { cartegories } = this.state;
    return (
      <nav className="nav">
        {this.props.page ? (
          <div className="options">
            <Link to="/my_page">
              <h4 className="optionTitle">마이 페이지</h4>
            </Link>
            <Link to="/my_page" className="option">
              <h6 className="optionName">내 정보</h6>
            </Link>
            <Link to="/my_page/purchase_history" className="option">
              <h6 className="optionName">구매 내역</h6>
            </Link>
            <Link to="/my_page/create_review" className="option">
              <h6 className="optionName">리뷰 작성</h6>
            </Link>
          </div>
        ) : (
          <div className="categories">
            {cartegories.map((category, index) => {
              return <Category key={index} name={category.name} />;
            })}
            <script src="../function.js"></script>
          </div>
        )}
      </nav>
    );
  }
}

export default Nav;
