import React from "react";
import Header from "../components/Header";
import Nav from "../components/Nav";
import "../css/Mypage.css";
import { Link } from "react-router-dom";

function Mypage({ user }) {
  return (
    <div class="App">
      <Header />
      <Nav page={1} />
      <main>
        <Link to="/my_page">
          <h1 className="mypage_title">My page</h1>
        </Link>

        <div className="myinfo_title">My info</div>
        <div className="myinfo_column">
          <div className="myinfo_name">ID</div>
          <div className="myinfo_body">{user.id}</div>
        </div>
        <div className="myinfo_column">
          <div className="myinfo_name">NAME</div>
          <div className="myinfo_body">{user.name}</div>
        </div>
        <div className="myinfo_column">
          <div className="myinfo_name">PHONE NUMBER</div>
          <div className="myinfo_body">{user.phone}</div>
        </div>
        <div className="myinfo_column">
          <div className="myinfo_name">ADDRESS</div>
          <div className="myinfo_body">{user.address}</div>
        </div>
        <Link to="/my_page/edit" className="myinfo_btn">
          수정하기
        </Link>
      </main>
    </div>
  );
}

export default Mypage;
