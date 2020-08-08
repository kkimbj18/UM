import React from "react";
import "../css/Login.css";
import Loginbtn from "../components/Login"
import Signupbtn from "../components/Signup"
import Logo from "../images/kakaoTalk_20200806_202115751.png"
import {Link} from "react-router-dom";


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
                <Link to="/signup">
                    <Signupbtn />
                </Link>
            </div>
        </header>
    );
}
export default Login;