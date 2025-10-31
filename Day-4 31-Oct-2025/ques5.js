const sumAll = (...numbers)=>{
    const totalSum =  numbers.reduce((acc,curr)=>{return acc+curr},0)
    return totalSum
}

console.log(sumAll(1,2,3,4))