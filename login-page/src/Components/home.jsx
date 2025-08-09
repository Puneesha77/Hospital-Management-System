import React from "react";
import "../css/home.css";
import { Link } from "react-router-dom";



const Home = () => {
  return (
    <div className="wrapper">
      <nav className="navbar">
        <img className="logo" src="bg2.jpg" alt="Logo" />
        <ul>
          <li><Link className="active" to="/">Home</Link></li>
          <li><Link to="/about">About us</Link></li>
          <li><Link to="/doctorView">Doctors</Link></li>
          <li><Link to="/feedback">Feedback</Link></li>
        </ul>
      </nav>

      <div className="center">
        <h1>Welcome To ABC HOSPITALS</h1>
      </div>
    </div>
  );
};

export default Home;
