const doubleValues = (numbers)=>{
    const updateNum=numbers.map((number)=>{
        return number*2
    })
    return updateNum
}

console.log(doubleValues([1,2,3,4,5]))