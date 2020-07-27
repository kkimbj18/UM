import React from "react";

function Category({ name }) {
  return (
    <div className="category">
      <h6 className="categoryName">{name}</h6>
    </div>
  );
}

export default Category;
