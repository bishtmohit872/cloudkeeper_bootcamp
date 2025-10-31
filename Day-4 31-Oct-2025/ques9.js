const data =[
  {
    name: "Bob",
    age: 24
  },
  {
    name: "Alice",
    age: 21
  }
]


// const [firstperson,secondperson] = data
// console.log(firstperson,secondperson)

const [{age},{name}]=data

console.log(`${name}'s age is ${age}`)