import React from "react";
import "../css/Header.css";
import Home from "../routes/Home";

function Header() {
  return (
    <header className="header">
      <div className="headerColumn">
        <a className="headerTitle" href="/">
          <h4>UM</h4>
        </a>
        <input
          className="headerSearch"
          placeholder="검색하세오"
          type="text"
        ></input>
        <a className="headerSearchBtn">
          <i className="fas fa-search"></i>
        </a>
      </div>
      <div className="headerColumn">
        <a href="/login" className="headerBtn">
          로그인
        </a>
        <a className="headerBtn">회원가입</a>
      </div>
    </header>
  );
}

export default Header;
