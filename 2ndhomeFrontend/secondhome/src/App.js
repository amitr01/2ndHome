import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import React from 'react';

import 'bootstrap/dist/css/bootstrap.min.css';
import LoginPage from "./components/LoginPage";
import UserAddForm from './components/UserAddForm';
import OwnerAddForm from './components/OwnerAddForm';
import RoomAddForm from './components/RoomAddForm';
import AddressForm from './components/AddressForm';

function App() {
  return (
    <Router>
    <div>
      <div>
        <Routes>
        <Route path="/login" element={<LoginPage />} />
        <Route path="/addUser" element={<UserAddForm />} />
        <Route path="/addOwner" element={<OwnerAddForm />} />
        <Route path="/addRoom" element={<RoomAddForm />} />
        <Route path="/property/:pid/address" element={<AddressForm />} />
        </Routes>
      </div>
    </div>
  </Router>
  );
}

export default App;
