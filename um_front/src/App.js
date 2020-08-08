import React from "react";
import "./css/App.css";
import Home from "./routes/Home";
import { Route, BrowserRouter } from "react-router-dom";
import Login from "./routes/Loginpage";
import Signup from "./routes/Signuppage";
import Mypage from "./routes/Mypage";
import EditMyinfo from "./routes/EditMyinfo";

class App extends React.Component {
  state = {
    user: {
      id: "hooo0503",
      pwd: "psh0503",
      name: "박상혁",
      phone: "010-4062-5986",
      address: "아주대학교",
    },
  };
  render() {
    const { user } = this.state;
    return (
      <BrowserRouter>
        <Route path="/" exact={true} component={Home} />
        <Route path="/login" exact={true} component={Login} />
        <Route path="/signup" exact={true} component={Signup} />
        <Route
          path="/my_page"
          exact={true}
          render={() => <Mypage user={user} />}
        />
        <Route path="/my_page/edit" exact={true} component={EditMyinfo} />
      </BrowserRouter>
    );
  }
}

export default App;
