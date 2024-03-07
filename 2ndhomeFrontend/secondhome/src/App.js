import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import React from 'react';

import 'bootstrap/dist/css/bootstrap.min.css';
import LoginPage from "./components/LoginPage";
import UserAddForm from './components/UserAddForm';
import OwnerAddForm from './components/OwnerAddForm';
import RoomAddForm from './components/RoomAddForm';
import AddressForm from './components/AddressForm';

import AddProperty from './components/AddProperty';

import Navbar from './components/Navbar';
import PropertyList from './components/PropertyList';
import MainPage from './components/MainPage';
import 'bootstrap/dist/css/bootstrap.css'
import ViewPropertyDetails from './components/ViewPropertyDetails';

function App() {
  return (
    <BrowserRouter>
    <div>
        <Navbar></Navbar>
        <Routes>

        <Route path="/" element={<MainPage/>}/>  
        <Route path="/login" element={<LoginPage />} />
        <Route path='/propertyList' element={<PropertyList/>}/>
        <Route path="/showPropertyDetails/:id" element={<ViewPropertyDetails/>}/>
        <Route path="/addUser" element={<UserAddForm />} />
        <Route path="/addOwner" element={<OwnerAddForm />} />
        <Route path="/addOwner/:id" element={<OwnerAddForm/>}/>
        <Route path="/addRoom" element={<RoomAddForm />} />
        <Route path="/property/:pid/address" element={<AddressForm />} />
       
        <Route path="/addProperty" element={<AddProperty/>}/>

        </Routes>
      
    </div>
  </BrowserRouter>
  );
}

export default App;
