import React from "react";
import "./css/App.css";
import Home from "./routes/Home";
import { Route, BrowserRouter } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <Route path="/" exact={true} component={Home} />
    </BrowserRouter>
  );
}

export default App;
