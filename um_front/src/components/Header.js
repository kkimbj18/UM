import React from "react";
import "../css/Header.css";
import { Link } from "react-router-dom";
import AuthenticationService from "../components/AuthenticationService"

class Header extends React.Component {
  state = {
    token: localStorage.getItem('token'),
    account: localStorage.getItem('authenticatedUser'),
  };

  logout=() => {
    localStorage.removeItem("authenticatedUser");
    localStorage.removeItem("token");
    this.setState({
      token: localStorage.getItem('token'),
      account: localStorage.getItem('authenticatedUser'),
    });
}

  render() {
    return (
      <header className="header">
        <div className="headerColumn">
          <Link className="headerTitle" to="/">
            <h4>UM</h4>
          </Link>
          <input
            className="headerSearch"
            placeholder="검색하세오"
            type="text"
          ></input>
          <Link to="#" className="headerSearchBtn">
            <i className="fas fa-search"></i>
          </Link>
        </div>
        {AuthenticationService.isUserLoggedIn() ? (
          <div className="headerColumn">
            <Link to="/my_page" className="headerBtn">
              마이페이지
            </Link>
            <Link to="#" className="headerBtn">
              장바구니
            </Link>
            <Link to="/" onClick={this.logout} className="headerBtn">
              로그아웃
            </Link>
          </div>
        ) : (
          <div className="headerColumn">
            <Link to="/login" className="headerBtn">
              로그인
            </Link>
            <Link to="/signup" className="headerBtn">
              회원가입
            </Link>
          </div>
        )}
      </header>
    );
  }
}

export default Header;
