import React from "react";
import "./css/App.css";
import Home from "./routes/Home";
import { Route, BrowserRouter } from "react-router-dom";
import Search from "./routes/Search"
import SearchFilter from "./routes/SearchFilter"
import Login from "./routes/Loginpage";
import Logout from "./components/Logout"
import Signup from "./routes/Signuppage";
import Mypage from "./routes/Mypage";
import EditMyinfo from "./routes/EditMyinfo";
import Itemdetail from "./routes/Itemdetail";
import PurchaseHistory from "./routes/PurchaseHistory";
import CreateReview from "./routes/CreateReview";
import Cart from "./routes/Cart"

class App extends React.Component {
  render() {
    return (
      <BrowserRouter>
        <Route path="/" exact={true} component={Home} />
        <Route path="/search" exact={true} component={Search} />
        <Route path="/search/filter" exact={true} component={SearchFilter} />
        <Route path="/login" exact={true} component={Login} />
        <Route path="/logout" exact={true} component={Logout} />
        <Route path="/signup" exact={true} component={Signup} />
        <Route path="/details" exact={true} component={Itemdetail} />
        <Route path="/my_page" exact={true} render={() => <Mypage />} />
        <Route path="/my_page/edit" exact={true} component={EditMyinfo} />
        <Route path="/cart" exact={true} component={Cart} />
        <Route
          path="/my_page/purchase_history"
          exact={true}
          component={PurchaseHistory}
        />
        <Route
          path="/my_page/create_review"
          exact={true}
          component={CreateReview}
        />
      </BrowserRouter>
    );
  }
}

export default App;
