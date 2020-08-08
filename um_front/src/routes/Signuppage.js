import React from "react";
import "../css/Signup.css";
import "../css/Login.css"
import Signupsubbmitbtn from "../components/Signupsubbmit"
import Logo from "../images/kakaoTalk_20200806_202115751.png"
import { Link } from 'react-router-dom';


function Signup() {
    return (
        <header>
            <div className="signupBoxWrap">
                <a href="/">
                    <img className="headerimg" src={Logo} alt='um'></img>
                </a>
                <h2 className="center">회원가입</h2>
                <br></br>
                
                <h3>  아이디</h3>
                <input className="inputbox" type="text" placeholder="입력해랑"></input>
                <br></br>
                <h3>  패스워드</h3>
                <input className="inputbox" type="text" placeholder="패스워드"></input>
                <br></br>
                <input className="inputbox" type="text" placeholder="패스워드 확인"></input>
                <br></br>
                <h3>  개인정보</h3>
                <input className="inputbox" type="text" placeholder="이름"></input>
                <br></br>
                <input className="inputbox" type="text" placeholder="전화번호"></input>
                <br></br>
                <input className="inputbox" type="text" placeholder="주소"></input>
                <Link to="/signup">
                    <Signupsubbmitbtn />
                </Link>
            </div>
        </header>
    );
}
export default Signup;