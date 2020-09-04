import React from "react";
import { Link } from "react-router-dom";

class Category extends React.Component {
  

  render() {
    return (
      <div className="category">
        <Link to={`/search/filter?category1=${this.props.name}`}>
        <div className="categoryColumn">
        <h6 className="categoryName">{this.props.name}</h6>
        <i className="fas fa-plus"></i>
        </div>
        </Link>
        <div className="caption"></div>
      </div>
    );
  }
}

export default Category;
