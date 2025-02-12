import { useState } from "react"

export default function (){
    const [email,setEmail] = useState<string>("");
    const [password,setPassword] = useState<string>("");

    const handleSubmit = (e:any)=>{
        e.preventDefault;

        const newEmail = email;
        const newPassWord= password;

        setEmail("");
        setPassword("");
    }

    return <>
        <form className="d-flex column" onSubmit={handleSubmit}>
            <input type="email" onChange={(e)=>setEmail(e.target.value)} value={email}/>
            <input type="password" onChange={(e)=>setPassword(e.target.value)} value={password}/>
            <button className="secondary" type="submit">New</button>
        </form>    
    </>
}