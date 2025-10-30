var arr = [1, 1, 1, 5, 10, 15, 20, 25];

// Q-3
arr.push(30)
console.log(arr)

// Q-4
arr.shift()
console.log(arr)

// Q-5
arr.splice(2,0,18)
console.log(arr)

// Q-6
arr = arr.map(num => num === 1 ? 50 : num); 
console.log(arr); 

// Q-7
for (let i = 0; i < arr.length; i++) {
  for (let j = 0; j < arr.length - 1; j++) {
    if (arr[j] > arr[j + 1]) {
      let temp = arr[j];
      arr[j] = arr[j + 1];
      arr[j + 1] = temp;
    }
  }
}
console.log(arr); 

// Q-8
let left = 0;
let right = arr.length - 1;
while (left < right) {
  let temp = arr[left];
  arr[left] = arr[right];
  arr[right] = temp;
  left++;
  right--;
}
console.log(arr); 

// Q-9
let index = arr.indexOf(25); 
console.log(index);  




