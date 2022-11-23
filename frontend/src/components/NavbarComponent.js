import React from "react";
import {
  Navbar,
  Nav,
  NavDropdown,
  Form,
  FormControl,
  Button,
} from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import "../style.css";
import logo from "../static/img/logo.png";
import profile from "../static/img/profile.png";

export default class NavbarComponent extends React.Component {
  user = localStorage.getItem("user");
  loggedIn = localStorage.getItem("logged");
  role = localStorage.getItem("role");

  componentDidMount() {}
  nav() {
    if (this.loggedIn === "false") {
      return (
        <Navbar className="header-nav" id="head"expand="lg">
          <div className="container">
            <a class="navbar-brand" href="">
              <img
                src={logo}
                width="140"
                height="55"
                onMouseOver={(e) => {
                  e.currentTarget.style.opacity = "0.7";
                }}
                onMouseOut={(e) => {
                  e.currentTarget.style.opacity = "1";
                }}
                alt=""
              />
              <strong id="head"> SkyFashion</strong>
            </a>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
              <Nav className="mr-auto">
                <Nav.Link  id="head" href="/">Home</Nav.Link>
                <NavDropdown className="head"  title="Categories" id="basic-nav-dropdown ">
                  <NavDropdown.Item href="/Dresses">Dresses</NavDropdown.Item>
                  <NavDropdown.Item href="/Shirt">Shirt</NavDropdown.Item>
                  <NavDropdown.Item href="/Formals">Formals </NavDropdown.Item>
                  <NavDropdown.Divider />
                  <NavDropdown.Item href="/Suits">Suits</NavDropdown.Item>
                </NavDropdown>
              </Nav>
              {/* <Form inline>
                <FormControl
                  type="text"
                  placeholder="Search"
                  className="mr-sm-2"
                />
                <Button variant="outline-success">Search</Button>
              </Form> */}
              <Nav.Link href="/login" id="head">Log in</Nav.Link>
              <Nav.Link href="/register" id="head">Register</Nav.Link>
            </Navbar.Collapse>
          </div>
        </Navbar>
      );
    } else if (this.loggedIn === "true") {
      if (this.role === "ADMIN") {
        return (
          <Navbar className="header-nav" bg="light" expand="lg">
            <div className="container">
              <a class="navbar-brand" href="">

                <img
                  src={logo}
                  width="140"
                  height="45"
                  onMouseOver={(e) => {
                    e.currentTarget.style.opacity = "0.7";
                  }}
                  onMouseOut={(e) => {
                    e.currentTarget.style.opacity = "1";
                  }}
                  alt=""
                />


              </a>
              <Navbar.Toggle aria-controls="basic-navbar-nav" />
              <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="mr-auto">
                  <Nav.Link id="head" href="/">Home</Nav.Link>
                  <Nav.Link id="head" href="/add">Add Product</Nav.Link>
                  <NavDropdown className="head" title="Categories" id="basic-nav-dropdown">
                    <NavDropdown.Item href="/Dresses">Dresses</NavDropdown.Item>
                    <NavDropdown.Item href="/Shirt">Shirt</NavDropdown.Item>
                    <NavDropdown.Item href="/Formals">
                    Formals{" "}
                    </NavDropdown.Item>
                    <NavDropdown.Divider />
                    <NavDropdown.Item href="/Suits">Suits</NavDropdown.Item>
                  </NavDropdown>
                </Nav>
                {/* <Form inline>
                  <FormControl
                    type="text"
                    placeholder="Search"
                    className="mr-sm-2"
                  />
                  <Button variant="outline-success">Search</Button>
                </Form> */}
                <NavDropdown className="head" title={this.user} id="basic-nav-dropdown">
                  <NavDropdown.Item href={"/user"}>
                    Your Profile
                  </NavDropdown.Item>
                  <NavDropdown.Item
                    href={"/user/" + this.user + "/shoppingCart"}
                  >
                    Shopping Cart
                  </NavDropdown.Item>
                  <NavDropdown.Divider />
                  <NavDropdown.Item   href="/logout">Log Out</NavDropdown.Item>
                </NavDropdown>
              </Navbar.Collapse>
            </div>
          </Navbar>
        );
      } else if (this.role === "USER") {
        return (
          <Navbar  id="head" className="header-nav" bg="light" expand="lg">
            <div className="container">
              <a class="navbar-brand" href="">
                <img
                  src={logo}
                  width="140"
                  height="45"
                  onMouseOver={(e) => {
                    e.currentTarget.style.opacity = "0.7";
                  }}
                  onMouseOut={(e) => {
                    e.currentTarget.style.opacity = "1";
                  }}
                  alt=""
                />
              </a>
              <Navbar.Toggle aria-controls="basic-navbar-nav" />
              <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="mr-auto">
                  <Nav.Link  id="head" href="/">Home</Nav.Link>
                  <NavDropdown className="head" title="Categories" id="basic-nav-dropdown">
                    <NavDropdown.Item href="/Dresses">dresses</NavDropdown.Item>
                    <NavDropdown.Item href="/Shirt">Shirt</NavDropdown.Item>
                    <NavDropdown.Item href="/Formals">
                    Formals{" "}
                    </NavDropdown.Item>
                    <NavDropdown.Divider />
                    <NavDropdown.Item href="/Suits">Suits</NavDropdown.Item>
                  </NavDropdown>
                </Nav>
                {/* <Form inline>
                  <FormControl
                    type="text"
                    placeholder="Search"
                    className="mr-sm-2"
                  />
                  <Button variant="outline-success">Search</Button>
                </Form> */}
                  
                <NavDropdown className="head" title={this.user} id="basic-nav-dropdown" src={profile}>
                  <NavDropdown.Item href={"/user"} >
                    Your Profile
                  </NavDropdown.Item>

                  {/* <NavDropdown.Item
                    href={"/user/" + this.user + "/shoppingCart"}
                  >
                    Shopping Cart
                  </NavDropdown.Item> */}
                

                  <NavDropdown.Divider />
                  <NavDropdown.Item href="/logout">Log Out</NavDropdown.Item>
                </NavDropdown>
              </Navbar.Collapse>
            </div>
          </Navbar>
        );
      }
    }
  }
  // render(){
  //   //  console.log(user.username)
  //     if (this.user === null || this.loggedIn === null || this.role === null) {
  //         this.user = "null";
  //         this.loggedIn = "false";
  //         this.role = "ANON";
  //     }

  //     return(

  //       this.returnNavbar()

  //       );

  // }
  render() {
    if (this.user === null || this.loggedIn === null || this.role === null) {
      this.user = "null";
      this.loggedIn = "false";
      this.role = "ANON";
    }

    return this.nav();
  }
}
