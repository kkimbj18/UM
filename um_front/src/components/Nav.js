import React from "react";
import "../css/Nav.css";
import { render } from "react-dom";

class Nav extends React.Component() {
  state = {
    cartegories: [
      { name: "상의" },
      { name: "하의" },
      { name: "외투" },
      { name: "신발" },
    ],
  };
  render() {
    return <nav className="nav"></nav>;
  }
}

export default Nav;
