export const setLoginStatus = (status)=>{
    localStorage.setItem('loginState',status)
}

export const getLoginStatus = ()=>{
    const status = localStorage.getItem('loginState')
    if(status==="true"){
        return true
    }
    else if(status==="false"){
        return false
    }
}
