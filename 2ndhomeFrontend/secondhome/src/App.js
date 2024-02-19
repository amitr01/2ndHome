import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import React from 'react';

import 'bootstrap/dist/css/bootstrap.min.css';
import LoginPage from './components/LoginPage';
import AddProperty from './components/AddProperty';

function App() {
  return (
    <BrowserRouter>
    <div>
      <div>
        <Routes>
        <Route path="/login" element={<LoginPage />} />
        <Route path="/addProperty" element={<AddProperty/>}/>
        </Routes>
      </div>
    </div>
  </BrowserRouter>
  );
}

export default App;
