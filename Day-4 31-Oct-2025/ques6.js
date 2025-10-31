const filterEvents = (...numbers)=>{
    const evenNum = numbers.filter((num)=>{return num%2==0})
    return evenNum
}

console.log(filterEvents(1,2,3,4,5,6,7,8,9))