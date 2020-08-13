import React from "react";
import Nav from "../components/Nav";
import Header from "../components/Header";
import "../css/Itemdetail.css";
import "../css/Home.css";
import "../css/App.css";
class Itemdetail extends React.Component {
  render() {
    return (
      <div className="App">
        <Header></Header>
        <Nav></Nav>
        <main>
          <div className="contentswrap">
            <div className="itemname">{this.props.location.state.name}</div>
            <div className="item_category">어쩌구 {">"} 저쩌구</div>
            <div className="contents-left">
              <div className="item_bigimg">
                <img
                  src={this.props.location.state.photo}
                  height="580px"
                  width="480px"
                ></img>
              </div>
              <div>type</div>
            </div>
            <div className="contents-right">
              <h4 className="title-box">Product info</h4>
            </div>
          </div>
        </main>
      </div>
    );
  }
}

export default Itemdetail;
