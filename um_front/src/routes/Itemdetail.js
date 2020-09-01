import React from "react";
import Nav from "../components/Nav";
import Header from "../components/Header";
import "../css/Itemdetail.css";
import "../css/Home.css";
import "../css/App.css";
import { brand } from "../db";
import { Link } from "react-router-dom";

function getbrand(brand, brandID) {
  let thisbrand = {};
  for (let i = 0; i < brand.length; i++) {
    if (brand[i].id == brandID) {
      thisbrand = brand[i];
      break;
    }
  }
  return thisbrand;
}

class Itemdetail extends React.Component {
  render() {
    let thisbrand = getbrand(brand, this.props.location.state.product.brandId);
    return (
      <div className="App">
        <Header></Header>
        <Nav></Nav>
        <main>
          <div className="contentswrap">
            <div className="itemname">
              {this.props.location.state.product.name}
            </div>
            <div className="item_category">어쩌구 {">"} 저쩌구</div>
            <div className="contents-left">
              <div className="item_bigimg">
                <img
                  src={this.props.location.state.product.thumbnail}
                  height="580px"
                  width="480px"
                ></img>
              </div>
              <div className="thumnail-box"></div>
            </div>
            <div className="contents-right">
              <div className="product-exclusive-info">
                <h4 className="exclusive-info-name">{thisbrand.name}</h4>
                <img src={thisbrand.logo} height="100px" width="230px"></img>
                <h5>최고의 브랜드 {thisbrand.name}의 대표 상품입니다.</h5>
              </div>
              <div className="product-explain">
                <h4 className="title-box">Product info</h4>
                <h5> - 브랜드 : {thisbrand.name}</h5>
                <h5>
                  {" "}
                  - 누적판매량 : {this.props.location.state.product.soldAmount}
                </h5>
                <h5>
                  <span class="text-center">- 구매후기 :</span>
                  <span class="star-rating">
                    <span
                      style={{
                        width: this.props.location.state.product.rating + "%",
                      }}
                    ></span>
                  </span>
                </h5>
              </div>
              <div className="product-explain">
                <h4 className="title-box">Price info</h4>
                <h5>
                  {" "}
                  - UM 판매가 : {this.props.location.state.product.price}
                </h5>
                <h5>
                  {" "}
                  - UM 적립금 : {this.props.location.state.product.price * 0.05}
                </h5>
                <h4 className="yellow-box">UM은 모든 상품 무료 배송입니다.</h4>
              </div>
              <div className="option-box-cover">
                <select className="option-box">
                  <option selected="selected">옵션 선택</option>
                  <option>블랙</option>
                </select>
              </div>
              <div className="total-price-box">
                총 합계
                <span className="total-price">{}원</span>
              </div>
              <Link to="/">
                <input
                  type="submit"
                  className="buybtn"
                  value="장바구니로 ㄱㄱ"
                ></input>
              </Link>
            </div>
          </div>
          <div className="contents-info">
            <br />
            <h3 className="title-box">Info</h3>
            <br />
            <img src={this.props.location.state.product.descriptionImage}></img>
          </div>
        </main>
      </div>
    );
  }
}

export default Itemdetail;
