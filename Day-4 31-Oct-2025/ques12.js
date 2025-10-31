const deepClone =(obj) =>{
    let data = JSON.parse(JSON.stringify(obj))
    return data
}

const obj = { a: 1, b: { c: 2 } }

const cloneObj = deepClone(obj)
cloneObj.b.c = 42

console.log(obj.b.c)
console.log(cloneObj.b.c)