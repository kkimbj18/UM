import React from "react";
import "./css/App.css";
import Nav from "./components/Nav";
import Header from "./components/Header";

class App extends React.Component() {
  render() {
    return (
      <div className="App">
        <Header />
        <Nav />
        <main className="main"></main>
      </div>
    );
  }
}

export default App;
