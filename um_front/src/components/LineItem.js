import React from "react";

class LineItem extends React.Component {
  state = {
    lineItem: this.props.lineItem,
    item: [{ id: 1, name: "쌀(20kg)", price: 45000 }, ,],
  };

  render() {
    const { lineItem } = this.state;
    return <div className="lineItem"></div>;
  }
}

export default LineItem;
