import httpClient from '../http-common';

const addOwner=(ownerdata)=>{
    return httpClient.post("owner/addOwner",ownerdata);
}

const addProperty=(propertyData)=>{
    return httpClient.post("/owner/addProperty",propertyData);
}

export default {addOwner,addProperty};