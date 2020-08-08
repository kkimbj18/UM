import React from "react";
import "./css/App.css";
import Home from "./routes/Home";
import { Route, BrowserRouter } from "react-router-dom";
import Login from "./routes/Loginpage";
import Signup from "./routes/Signuppage";
import Mypage from "./routes/Mypage";

class App extends React.Component {
  state = {
    user: {
      id: "hooo0503",
      pwd: "psh0503",
      name: "박상혁",
      birthYear: 1998,
      birthMonth: 5,
      birthDate: 3,
      email: "hooo0503@gmail.com",
      phone: "010-4062-5986",
      description: "안녕 난 방상형이야.",
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
      </BrowserRouter>
    );
  }
}

export default App;
