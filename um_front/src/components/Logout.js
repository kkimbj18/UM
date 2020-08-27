import React from "react";
import AuthenticationService from "../components/AuthenticationService"

class Logout extends React.Component {
    render() {
        AuthenticationService.logout();
        this.props.history.push("/");
        return 0;
    }
}

export default Logout;