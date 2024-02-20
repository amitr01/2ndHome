import React, { useState } from 'react';
import "../css/LoginPage.css";
import authetication from '../services/authetication';
import { useNavigate } from 'react-router-dom';
import ReCAPTCHA from "react-google-recaptcha";
import axios from 'axios';
const LoginPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const [captchaToken, setCaptchaToken] = useState('');

  const onCaptchaChange = (token) => {
    setCaptchaToken(token);

  };

const navigate=useNavigate();

const handleUser=(e)=>{
  e.preventDefault();
  navigate("/addUser");
}
const handleOwner=(e)=>{
   e.preventDefault();
   navigate("/addOwner");
}

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!captchaToken) {
      alert("Please complete the reCAPTCHA challenge.");
      return;
    }
    const singInData={
         email,
        password,
      };
    try {
      const response = await axios.post('http://localhost:8081/login/signIn',singInData, {
      
        headers: {
          'Content-Type': 'application/json'
        },
        
        
        params: new URLSearchParams({
          'g-recaptcha-response': captchaToken
        })
      });

     if(response.data==="VISITOR"){
       navigate("/");
     }else{
      navigate("/addProperty");
     }
     // console.log(data);
    } catch (error) {
      console.error('Error:', error);
    }
  };

  return (
    <div className="login-form">
      <h2>Login</h2>
      <input
        type="email"
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
         <ReCAPTCHA
          sitekey="6LeR5nkpAAAAAGkazqi_n31QX7dX6Mqt6F7cBvPJ"
          onChange={onCaptchaChange}
        />
      <button onClick={handleSubmit}>Login</button>
      <div className="signup-options">
        <button onClick={handleUser}>Sign Up as User</button>
        <button onClick={handleOwner}>Sign Up as Owner</button>
      </div>
    </div>
  );
};

export default LoginPage;
