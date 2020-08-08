import React from "react";
import Header from "../components/Header";
import Nav from "../components/Nav";
import "../css/Mypage.css";

function Mypage({ user }) {
  return (
    <div class="App">
      <Header />
      <Nav />
      <main>
        <h1 className="mypage_title">My page</h1>

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
        <a href="/my_page/edit" className="myinfo_btn">
          수정하기
        </a>
      </main>
    </div>
  );
}

export default Mypage;
