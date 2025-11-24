import { useEffect,useState } from "react"
import { IoIosCloseCircleOutline } from "react-icons/io"

const UserForm = ({ mode, show, setShow, data }) => {

    const [fName,setFName] = useState()
    const [lName,setLName] = useState()
    const [emailId,setEmailId] = useState()

    useEffect(() => {
        if (mode === "edit" && data) {
            setFName(data.firstName || "");
            setLName(data.lastName || "");
            setEmailId(data.email || "");
        }

        if (mode === "add") {
            setFName("");
            setLName("");
            setEmailId("");
        }
    }, [mode, data]);

    console.log(fName)

    const handleVisiblity=(e)=>{
        e.preventDefault()
        setShow(false)
    }

    return (
        <>
            <div className={`size-full absolute top-0 z-10 bg-gray-600 opacity-80 ${mode == "add" ? 'hidden' : mode == 'edit' && show == true ? 'block absolute top-0' : 'hidden'}`}></div>

            <div className={`${mode == "edit" ? 'h-max w-[800px] absolute z-20 top-1/2 -translate-y-1/2 bg-gray-200 rounded-lg shadow-lg' : 'h-full w-full'} ${mode == "add" ? 'block relative z-20' : mode == 'edit' && show == true ? 'block' : 'hidden'} py-6 px-12 flex flex-col space-y-4 text-blue-950`}>
                <div className="w-full flex items-center justify-between">
                    <p className="w-[180px] text-2xl font-bold p-2 text-blue-950 rounded-lg">{mode == "edit" ? "Update User" : "Add New User"} </p>
                    <IoIosCloseCircleOutline className={`size-8 cursor-pointer ${mode=="add"?'hidden':'block'}`} onClick={handleVisiblity}/>
                </div>

                <div className={`${mode == "edit" ? 'w-8/8' : 'w-full'} p-4 flex flex-col items-start justify-between space-y-8 rounded-lg bg-gray-100 shadow-lg`}>
                    <div className={`${mode == "edit" ? 'w-full' : "w-2/5"} flex items-center justify-between text-xl font-semibold`}>
                        <div className="flex space-y-2 flex-col items-start">
                            <label htmlFor="firstName">First Name</label>
                            <input className="w-[320px] border-gray-400 focus:outline-none rounded-md p-1 bg-white shadow-sm text-black" id="firstName" type="text" required minLength={3} maxLength={20} placeholder="Enter First Name" value={fName} onChange={(e)=>{setFName(e.target.value)}}/>
                        </div>

                        <div className="flex space-y-2 flex-col items-start">
                            <label htmlFor="lastName">Last Name</label>
                            <input className="w-[320px] border-gray-400 focus:outline-none rounded-md p-1 bg-white shadow-sm text-black" id="lastName" type="text" required minLength={3} maxLength={20} placeholder="Enter Last Name" value={lName} onChange={(e)=>{setLName(e.target.value)}}/>
                        </div>
                    </div>

                    <div className={`${mode == "edit" ? 'w-full' : 'w-2/5'} flex items-center justify-between text-xl font-semibold`}>
                        <div className="flex space-y-2 flex-col items-start">
                            <label htmlFor="email">Email</label>
                            <input className="w-[320px] border-gray-400 focus:outline-none rounded-md p-1 bg-white shadow-sm text-black" id="email" type="email" placeholder="Enter Email" value={emailId} onChange={(e)=>{setEmailId(e.target.value)}}/>
                        </div>

                        <div className="w-[320px] flex space-y-2 flex-col items-start">
                            <label htmlFor="lastName">Select Role</label>
                            <select className="border-gray-400 focus:outline-none rounded-md p-1 w-full bg-white shadow-sm text-gray-600">
                                <option>Roles</option>
                                <option>Admin</option>
                                <option>Read-Only</option>
                                <option>Customer</option>
                            </select>
                        </div>
                    </div>

                    <button className="py-2 px-4 bg-blue-950 text-white rounded-md cursor-pointer hover:bg-blue-900">{mode == "edit" ? "Update User" : "Add User"}</button>
                </div>
            </div>
        </>
    )
}

export default UserForm