import React from "react";
import Nav from "../components/Nav";
import Header from "../components/Header";
import "../css/Itemdetail.css";
import "../css/Home.css";
import "../css/App.css";
import {brand} from "../db"
class Itemdetail extends React.Component{
    render() {
        let thisbrand={};

        for (let i = 0; i < brand.length; i++) {
            console.log(this.props.location.state.product.brandid);
            if (brand[i].id == this.props.location.state.product.brandid) {
                thisbrand = brand[i];
                break;
            }
        }

        return (
            <div className="App">
                <Header></Header>
                <Nav></Nav>
                <main>
                    <div className="contentswrap">
                        <div className="itemname" >{this.props.location.state.product.name}</div>
                        <div className="item_category">어쩌구 {'>'} 저쩌구</div>
                        <div className="contents-left">
                            <div className="item_bigimg">
                                <img src={this.props.location.state.product.image} height="580px" width="480px"></img>
                            </div>
                            <div>type</div>
                        </div>
                        <div className="contents-right">
                            <div className="product-exclusive-info">
                                <h4 className="exclusive-info-name">엄준식</h4>
                                <img src={thisbrand.logo}></img>
                                <h5>최고의 브랜드 엄준식의 대표 상품입니다.</h5>
                            </div>
                            <div className="product-explain">
                                <h4 className="title-box">Product info</h4>
                                <h5> - 브랜드   : 엄준식</h5>
                                <h5> - 누적판매량 : {this.props.location.state.product.soldAmount}</h5>
                                <h5> - 구매후기 : {this.props.location.state.product.rating}</h5>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div className="contents-right">
              <div className="product-exclusive-info">
                <h4 className="exclusive-info-name">엄준식</h4>
                <img src={thisbrand.logo}></img>
                <h5>최고의 브랜드 엄준식의 대표 상품입니다.</h5>
              </div>
              <div className="product-explain">
                <h4 className="title-box">Product info</h4>
                <h5> - 브랜드 : 엄준식</h5>
                <h5>
                  {" "}
                  - 누적판매량 : {this.props.location.state.product.soldAmount}
                </h5>
                <h5>
                  {" "}
                  - 구매후기 : {this.props.location.state.product.rating}
                </h5>
              </div>
            </div>
          </div>
        </main>
      </div>
    );
  }
}

export default Itemdetail;
