import React from "react";
import { Link } from "react-router-dom";

function Sample({ name, price, photo }) {
  return (
    <Link to={{pathname:"/details", state:{name, price, photo}}}>
      <div className="sample">
        <img src={photo} alt="sample photo" className="sampleImage"></img>
        <h6 className="sampleName">{name}</h6>
        <span className="samplePrice">{price}원</span>
      </div>
    </Link>
  );
}

export default Sample;
