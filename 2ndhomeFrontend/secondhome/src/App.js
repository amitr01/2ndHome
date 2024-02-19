import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import React from 'react';

import 'bootstrap/dist/css/bootstrap.min.css';
import "./components/LoginPage"

function App() {
  return (
    <BrowserRouter>
    <div>
      <div>
        <Routes>
        <Route path="/login" element={<LoginPage />} />
        </Routes>
      </div>
    </div>
  </BrowserRouter>
  );
}

export default App;
