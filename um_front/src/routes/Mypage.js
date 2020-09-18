import React from "react";
import Header from "../components/Header";
import Nav from "../components/Nav";
import "../css/Mypage.css";
import { Link } from "react-router-dom";
import axios from "axios";

class Mypage extends React.Component {
  state = {
    id: localStorage.getItem("id"),
    token: localStorage.getItem("token"),
    user: axios.get(
      `http://ec2-3-34-81-212.ap-northeast-2.compute.amazonaws.com:8080/profile?userId=${localStorage.getItem(
        "id"
      )}`,
      { headers: { Authorization: "Bearer " + localStorage.getItem("token") } }
    ),
  };
  render() {
    const { user } = this.state;
    console.log(user);
    return (
      <div className="App">
        <Header />
        <Nav page={1} />
        <main>
          <Link to="/my_page">
            <h1 className="mypage_title">마이 페이지</h1>
          </Link>

          <div className="myinfo_title">내 정보</div>
          <div className="myinfo_column">
            <div className="myinfo_name">Account</div>
            <div className="myinfo_body">{user.account}</div>
          </div>
          <div className="myinfo_column">
            <div className="myinfo_name">NAME</div>
            <div className="myinfo_body">{user.name}</div>
          </div>
          <div className="myinfo_column">
            <div className="myinfo_name">PHONE NUMBER</div>
            <div className="myinfo_body">{user.phoneNumber}</div>
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
}

export default Mypage;
