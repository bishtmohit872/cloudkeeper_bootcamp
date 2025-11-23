import { useState,useEffect } from 'react'
import users from "../constants/users.js"
import toast from 'react-hot-toast'
import { Navigate,useNavigate } from 'react-router-dom'
import { useDispatch } from 'react-redux' //access the state of global variable of app with help of redux
import { addLoginUser } from '../redux/store.js'

import { getLoginStatus,setLoginStatus } from '../utils/Utils.js'

const Login = () =>{

    const dispatch = useDispatch()

    const [username,setUsername] = useState("")
    const [password,setPassword] = useState("")

    const navigate = useNavigate()


    const handleSubmit=(e)=>{
        e.preventDefault()
        const matchedUser = users.find((user)=>(user.username===username) && (user.password===password))

        if(matchedUser){
            setLoginStatus(true)

            const loginUser={
                name:matchedUser.firstName + " " + matchedUser.lastName,
                email:matchedUser.email,
                roles:matchedUser.roles,
            }

            dispatch(addLoginUser(loginUser))

            toast.success("successfull")
            navigate("/dashboard")
        }
        else{
            toast.error("No Matched")
        }
        
    }

    useEffect(()=>{
        if(getLoginStatus()){
            navigate('/dashboard')
        }
        else{
            navigate('/login')
        }
    },[])

    
    return(
        <div className='h-screen w-screen flex items-center justify-center'>
            <form className="h-max w-150 space-y-2 flex flex-col items-center justify-center" onSubmit={handleSubmit} action="">
                
                <div className='h-max w-full flex justify-center'>
                    <img src="/assets/cloudbalance.png" className='h-30 w-120' alt="CloudBalance"/>
                </div>

                <div className='h-max flex flex-col w-full space-y-2'>
                    <label className="font-medium text-lg" htmlFor="username">Username</label>
                    <input className="p-2 border-2 border-blue-200 focus:outline-none rounded-md" id="username" type="text" placeholder='Username' required onChange={(e)=>{
                        setUsername(e.target.value)
                    }}/>
                </div>

                <div className='h-max flex flex-col w-full space-y-2'>
                    <label className="font-medium text-lg" htmlFor="password">Password</label>
                    <input className="p-2 border-2 border-blue-200 focus:outline-none rounded-md" id="password" type="password" placeholder='Password' required onChange={(e)=>{
                        setPassword(e.target.value)
                    }}/>
                </div>

                <button className='w-full py-2 bg-blue-400 text-white font-medium cursor-pointer rounded-md hover:bg-blue-500'>Submit</button>
            </form>
        </div>
    )
}

export default Login