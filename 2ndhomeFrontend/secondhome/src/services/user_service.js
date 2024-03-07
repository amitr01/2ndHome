import httpClient from '../http-common';

const getAll=()=>{
    return httpClient.get("user/getAllProperties")
}

const getAllByType=(type)=>{
    return httpClient.get(`user/getAllProperties/${type}`)
}

const getAllByCity=(city)=>{
    return httpClient.get(`user/getAllProperties/${city}`)
}

const addUSer=(userdata)=>{
    return httpClient.post("user/addUser",userdata)
}

const deleteUser=(email)=>{
    return httpClient.delete(`user/deleteUser/${email}`)
}

const sendOTP=(email)=>{
    return httpClient.post("/user/sendOTP",email);
}

const getPropertyDetailsById=(id)=>{
    return httpClient.get(`user/getAllPropertiesById/${id}`)
}

export default {getAll,getAllByType,getAllByCity,addUSer,deleteUser,sendOTP,getPropertyDetailsById};