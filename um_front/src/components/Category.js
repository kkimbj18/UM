import React from "react";

function Category({ name }) {
  return (
    <a href="#" className="category">
      <h6 className="categoryName">{name}</h6>
      <i className="fas fa-plus"></i>
      <div className="caption"></div>
    </a>
  );
}

export default Category;
