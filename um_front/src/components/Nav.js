import React from "react";
import "../css/Nav.css";
import Category from "./Category";

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
            <a href="/my_page">
              <h4 className="optionTitle">My page</h4>
            </a>
            <a href="/my_page" className="option">
              <h6 className="optionName">내 정보</h6>
            </a>
            <a href="#" className="option">
              <h6 className="optionName">구매 내역</h6>
            </a>
            <a href="#" className="option">
              <h6 className="optionName">리뷰 작성</h6>
            </a>
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
