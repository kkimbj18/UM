import React from "react";

class Category extends React.Component {
  

  render() {
    return (
      <div className="category">
        <h6 className="categoryName">{this.props.name}</h6>
        <i className="fas fa-plus"></i>
        <div className="caption"></div>
      </div>
    );
  }
}

export default Category;
