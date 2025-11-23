import { createStore } from "redux";
import {composeWithDevTools} from '@redux-devtools/extension'

const initialState = {
  loginUserInfo: {},
};

const userReducer = (state = initialState, action) => {
  switch (action.type) {

    case "AddLoginUser":
      return {
        ...state,
        loginUserInfo: {
          ...state.loginUserInfo,
          ...action.payload
        }
      }
    case "RemoveLoginUser":
      return{
        ...state,loginUserInfo:{}
      }

    default:
      return state;
  }
};


//action creator
export const addLoginUser = (data)=>{
  return {type:"AddLoginUser",payload:data}
}

export const removeLoginUser=()=>{
  return {type:"RemoveLoginUser"}
}

const store = createStore(userReducer,composeWithDevTools());

export default store;
