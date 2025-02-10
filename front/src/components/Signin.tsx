import { useState } from "react"
import { login } from "../services/authServices";

export default function Signin(){
const [email,setEmail] = useState<string>("");
const [password, setPassword] = useState<string>("");

const handleSubmit = async(e: any) =>{
    e.preventDefault();
    try {
        const data = await login(email,password)
            console.log("response serveur: ", data);
            
    } catch (error) {
        console.log("error", error);
        
    }
    const newEmail = email;
    const newPassWord = password;
    
    setEmail("");
    setPassword("");
}

    return <>
    <div className="container d-flew row">
        <form action="" onSubmit={handleSubmit}>
           <label htmlFor="">Email
                <input type="Email" value={email} onChange={(event)=> setEmail(event.target.value)}/>
           </label>
           <label htmlFor="">Password
                <input type="password" value={password} onChange={(event)=>setPassword(event.target.value)}/>
           </label>
           <button className="primary"type="submit">Submit</button>
        </form>
        
    </div>
    </>
}