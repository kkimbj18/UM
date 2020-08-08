import React from "react";
import Header from "../components/Header";
import Nav from "../components/Nav";

function EditMyinfo() {
  return (
    <div class="App">
      <Header />
      <Nav />
      <main>
        <h1 className="mypage_title">My page</h1>

        <div className="myinfo_title">Edit My info</div>

        <form method="post" action="#">
          <div className="myinfo_column">
            <div className="myinfo_name">ID</div>
            <input type="text" className="myinfo_body" placeholder="ID"></input>
          </div>
          <div className="myinfo_column">
            <div className="myinfo_name">NAME</div>
            <input
              type="text"
              className="myinfo_body"
              placeholder="Name"
            ></input>
          </div>
          <div className="myinfo_column">
            <div className="myinfo_name">PHONE NUMBER</div>
            <input
              type="text"
              className="myinfo_body"
              placeholder="Phone number"
            ></input>
          </div>
          <div className="myinfo_column">
            <div className="myinfo_name">ADDRESS</div>
            <input
              type="text"
              className="myinfo_body"
              placeholder="Address"
            ></input>
          </div>
          <input className="Myinfo_btn" type="submit">
            Submit
          </input>
        </form>
      </main>
    </div>
  );
}

export default EditMyinfo;
