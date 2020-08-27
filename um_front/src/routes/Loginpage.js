import React from "react";
import "../css/Login.css";
import Loginbtn from "../components/Login";
import Signupbtn from "../components/Signup";
import Logo from "../images/kakaoTalk_20200806_202115751.png";
import { Link } from "react-router-dom";
import axios from "axios";
import AuthenticationService from "../components/AuthenticationService"

class Login extends React.Component {
  handleSubmit = (event) => {
    event.preventDefault();
    const account = event.target.account.value;
    const password = event.target.password.value;
    AuthenticationService
        .executeJwtAuthenticationService(account, password)
        .then((response) => {
        AuthenticationService.registerSuccessfulLoginForJwt(account,response.data);
        this.props.history.push("/");
    }).catch( (error) =>{
        this.setState({showSuccessMessage:false});
        this.setState({hasLoginFailed:true});
        console.log(error);
    })
    /*
    try {
      const token = await axios
        .post(
          "http://ec2-3-34-81-212.ap-northeast-2.compute.amazonaws.com:8080/login",
          {
            account: event.target.account.value,
            password: event.target.password.value,
          }
        )
        .then((response) => {
          localStorage.setItem('token', token);
          this.props.history.push("/");
        });
    } catch (error) {
      console.log(error);
      alert("문제가 생겨스빈다.");
    }
    */
  };

  render() {
    return (
      <header>
        <div className="loginBoxWrap">
          <a href="/">
            <img className="headerimg" src={Logo} alt="um"></img>
          </a>
          <form onSubmit={this.handleSubmit}>
            <input
              className="inputbox"
              type="text"
              placeholder="입력해랑"
              name="account"
              required
            ></input>
            <br></br>
            <input
              className="inputbox"
              type="password"
              placeholder="패스워드"
              name="password"
              required
            ></input>
            <br></br>
            <Loginbtn />
            <Link to="/signup">
              <Signupbtn />
            </Link>
          </form>
        </div>
      </header>
    );
  }
}
export default Login;
