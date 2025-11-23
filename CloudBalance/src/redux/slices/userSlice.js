import { createSlice } from "@reduxjs/toolkit"


const userLoginSlice = createSlice({
    name:"userInfo",
    initialState:{
        user:{},
    },
    reducers:{
        setUserLoginInfo:(state,action)=>{
            return {
                ...state,
                user:{...state.user, ...action.payload}
            }
        },
    
        getUserLogininfo:(state)=>{
            return state.user
        },

        removerUserLoginInfo:()=>{
            return {}
        }
        
    }
})


export const {setUserLoginInfo,getUserLogininfo,removerUserLoginInfo} = userLoginSlice.actions
export default userLoginSlice.reducer