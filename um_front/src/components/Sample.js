import React from "react";
import { Link } from "react-router-dom";

function Sample(product) {
  return (
    <Link to={{pathname:"/details", state:product}}>
      <div className="sample">
        <img src={product.product.image} alt="sample photo" className="sampleImage"></img>
        <h6 className="sampleName">{product.product.name}</h6>
        <span className="samplePrice">{product.product.price}원</span>
      </div>
    </Link>
  );
}

export default Sample;
