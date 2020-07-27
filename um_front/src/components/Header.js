import React from "react";
import "../css/Header.css";

function Header() {
  return (
    <header className="header">
      <div className="headerColumn">
        <h4 className="headerTitle">UM</h4>
        <input
          className="headerSearch"
          placeholder="검색하세오"
          type="text"
        ></input>
        <a className="headerSearchBtn">
          <i class="fas fa-search"></i>
        </a>
      </div>
      <div className="headerColumn">
        <a className="headerBtn">로그인</a>
        <a className="headerBtn">회원가입</a>
        <a className="headerBtn">비밀번호 찾기</a>
      </div>
    </header>
  );
}

export default Header;
