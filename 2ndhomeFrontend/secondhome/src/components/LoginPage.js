import React, { useState } from 'react';
import "../css/LoginPage.css";
const LoginPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = () => {
    // Implement login logic
    console.log('Logging in with:', email, password);
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
      <button onClick={handleLogin}>Login</button>
      <div className="signup-options">
        <button onClick={() => console.log('Sign up as user')}>Sign Up as User</button>
        <button onClick={() => console.log('Sign up as owner')}>Sign Up as Owner</button>
      </div>
    </div>
  );
};

export default LoginPage;
