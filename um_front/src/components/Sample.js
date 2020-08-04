import React from "react";

function Sample({ name, price, photo }) {
  return (
    <div className="sample">
      <img src={photo} alt="sample photo" className="sampleImage"></img>
      <h6 className="sampleName">{name}</h6>
      <span className="samplePrice">{price}원</span>
    </div>
  );
}

export default Sample;
