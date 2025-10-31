const person = {
    name: 'Alice',
    age: 25,
    address: {
        city: 'New York',
        country: 'NY'
    }
};

const {name,address:{city}} = person
console.log(`${name} lives in ${city}`)
