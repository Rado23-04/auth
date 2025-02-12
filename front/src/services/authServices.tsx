import axios from "axios";

const API_URL = "http://localhost:8080/auth";
export const login = async (email: string, password: string) => {    
    try {
        const response = await axios.post(`${API_URL}`, {
            email,
            password
        });
       return response.data;
    } catch (error) {
        throw error; 
    }
};

const API_URL_NEW_USER = "http://localhost:8080/save";
export const saveUser = async (email:string,password:string)=>{
    try {
        const user = await axios.post(`${API_URL_NEW_USER}`,{
            email,
            password
        });
        return user.data;

    } catch (error) {
        throw error;
    }
}
