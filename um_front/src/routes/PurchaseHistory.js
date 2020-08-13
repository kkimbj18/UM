import React from "react";
import Header from "../components/Header";
import Nav from "../components/Nav";
import { Link } from "react-router-dom";

function PurchaseHistory() {
  return (
    <div className="App">
      <Header />
      <Nav page={1} />
      <main>
        <Link to="/my_page">
          <h1 className="mypage_title">마이 페이지</h1>
        </Link>

        <div className="myinfo_title">구매 내역</div>
      </main>
    </div>
  );
}

export default PurchaseHistory;
