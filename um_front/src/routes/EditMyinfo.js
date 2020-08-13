import React from "react";
import Header from "../components/Header";
import Nav from "../components/Nav";
import axios from "axios";
import { Link } from "react-router-dom";

class EditMyinfo extends React.Component {
  handleSubmit = async (event) => {
    event.preventDefault();
    try {
      await axios.post("", {
        id: event.target.id.value,
        name: event.target.name.value,
        address: event.target.address.value,
        phone: event.target.phone.value,
      });
      this.props.history.push("/my_page");
    } catch {
      alert("문제가 생겨스빈다.");
    }
  };

  render() {
    return (
      <div class="App">
        <Header />
        <Nav page={1} />
        <main>
          <Link to="/my_page">
            <h1 className="mypage_title">마이 페이지</h1>
          </Link>

          <div className="myinfo_title">내 정보 수정</div>

          <form onSubmit={this.handleSubmit}>
            <div className="myinfo_column">
              <label className="myinfo_name">
                ID
                <input
                  type="text"
                  className="myinfo_body"
                  placeholder="ID"
                  name="id"
                ></input>
              </label>
            </div>
            <div className="myinfo_column">
              <label className="myinfo_name">
                NAME
                <input
                  type="text"
                  className="myinfo_body"
                  placeholder="Name"
                  name="name"
                ></input>
              </label>
            </div>
            <div className="myinfo_column">
              <label className="myinfo_name">
                PHONE NUMBER
                <input
                  type="text"
                  className="myinfo_body"
                  placeholder="Phone number"
                  name="phone"
                ></input>
              </label>
            </div>
            <div className="myinfo_column">
              <label className="myinfo_name">
                ADDRESS
                <input
                  type="text"
                  className="myinfo_body"
                  placeholder="Address"
                  name="address"
                ></input>
              </label>
            </div>
            <input className="Myinfo_btn" type="submit"></input>
          </form>
        </main>
      </div>
    );
  }
}

export default EditMyinfo;
