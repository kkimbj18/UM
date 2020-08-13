import React from "react";
//window.$ = window.jQuery = jQuery;

class Category extends React.Component {
  /*
  componentDidMount() {
    $(".category").on("click", function () {
      $(".caption").css("display", "block");
    });
  }
  */

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
