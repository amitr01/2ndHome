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

export default {getAll,getAllByType,getAllByCity,addUSer,deleteUser};