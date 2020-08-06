import React from "react";
import "../css/Login.css";
import Loginbtn from "../components/Login"
import Signupbtn from "../components/Signup"
import Logo from "../images/kakaoTalk_20200806_202115751.png"


function Login() {
    return(
        <header>
            <div className="loginBoxWrap">
                <a href ="/">
                    <img className="headerimg" src={Logo} alt='um'></img>
                </a>
                <input className="inputbox" type="text" placeholder="입력해랑"></input>
                <br></br>
                <input className="inputbox" type="text" placeholder="패스워드"></input>
                <br></br>
                <Loginbtn />
                <a href="/signup">
                    <Signupbtn />
                </a>
            </div>
        </header>
    );
}
export default Login;