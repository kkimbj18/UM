import React from "react";
import "../css/Signup.css";
import "../css/Login.css";
import Signupsubbmitbtn from "../components/Signupsubbmit";
import Logo from "../images/kakaoTalk_20200806_202115751.png";
import { Link } from "react-router-dom";
import axios from "axios";

class Signup extends React.Component {
  handleSubmit = async (event) => {
    event.preventDefault();
    try {
      await axios.post(
        "http://ec2-3-34-81-212.ap-northeast-2.compute.amazonaws.com:8080/signup",
        {
          account: event.target.account.value,
          name: event.target.name.value,
          address: event.target.address.value,
          phoneNumber: event.target.phoneNumber.value,
          password: event.target.password.value,
        }
      );
      this.props.history.push("/login");
    } catch (error) {
      console.log(error);
      alert("문제가 생겨스빈다.");
    }
  };
  render() {
    return (
      <header>
        <div className="signupBoxWrap">
          <a href="/">
            <img className="headerimg" src={Logo} alt="um"></img>
          </a>
          <h2 className="center">회원가입</h2>
          <br></br>
          <form onSubmit={this.handleSubmit}>
            <h3> 아이디</h3>
            <input
              className="inputbox"
              type="text"
              placeholder="입력해랑"
              name="account"
            ></input>
            <br></br>
            <h3> 패스워드</h3>
            <input
              className="inputbox"
              type="text"
              placeholder="패스워드"
              name="password"
            ></input>
            <br></br>
            <input
              className="inputbox"
              type="text"
              placeholder="패스워드 확인"
            ></input>
            <br></br>
            <h3> 개인정보</h3>
            <input
              className="inputbox"
              type="text"
              placeholder="이름"
              name="name"
            ></input>
            <br></br>
            <input
              className="inputbox"
              type="text"
              placeholder="전화번호"
              name="phoneNumber"
            ></input>
            <br></br>
            <input
              className="inputbox"
              type="text"
              placeholder="주소"
              name="address"
            ></input>
            <Signupsubbmitbtn />
          </form>
        </div>
      </header>
    );
  }
}
export default Signup;
