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
        <div className="categories">
          {cartegories.map((category, index) => {
            return <Category key={index} name={category.name} />;
          })}
        </div>
        <script src="../function.js"></script>
      </nav>
    );
  }
}

export default Nav;
