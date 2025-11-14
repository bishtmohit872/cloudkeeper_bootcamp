import { useState } from "react";

export default function Counter() {
  const [value, setValue] = useState(0);

  const handleIncrement = ()=>{
    if(value>=0){
      setValue(value+1)
    }
  }
  const handleDecrement = ()=>{
    if(value>=1){
      setValue(value-1)
    }
  }

  return (
    <div style={{ textAlign: "center" }}>
      <h1>Counter: {value}</h1>
      <button onClick={() => handleIncrement()}>+</button>
      <button onClick={() => handleDecrement()}>-</button>
    </div>
  );
}
