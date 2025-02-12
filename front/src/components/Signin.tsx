import { useState } from "react"
import { login } from "../services/authServices";
import { useNavigate } from "react-router-dom";

export default function Signin(){
const [email,setEmail] = useState<string>("");
const [password, setPassword] = useState<string>("");
const navigate = useNavigate();

const handleSubmit = async(e: any) =>{
    e.preventDefault();
    try {
        const data = await login(email,password)
            console.log("response serveur: ", data);
            if(data.success){
                navigate("/hello")
            }else{
                alert("Authentification failed")
            }
            
    } catch (error) {
        console.log("Erreur d'authentification:", error);
        alert("Échec de l'authentification. Vérifiez vos identifiants.");
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