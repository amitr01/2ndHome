import httpClient from '../http-common';

const addOwner=(ownerdata)=>{
    return httpClient.post("owner/addOwner",ownerdata);
}

const addProperty=(propertyData)=>{
    return httpClient.post("/owner/addProperty",propertyData);
}

const addRoom=(roomData)=>{
    return httpClient.post("/owner/addRoom",roomData);
}
const assignAddress=(addressData)=>{
    return httpClient.post("/property/:pid/address")
}
export default {addOwner,addProperty,addRoom,assignAddress};