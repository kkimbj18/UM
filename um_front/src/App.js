import React from "react";
import "./css/App.css";
import Home from "./routes/Home";
import { Route, BrowserRouter } from "react-router-dom";
import Login from "./routes/Loginpage";
import Signup from "./routes/Signuppage"

function App() {
  return (
    <BrowserRouter>
      <Route path="/" exact={true} component={Home} />
      <Route path="/login" exact={true} component={Login} />
      <Route path="/signup" exact={true} component={Signup} />
    </BrowserRouter>
  );
}

export default App;
