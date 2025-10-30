document.getElementById("userForm").addEventListener("submit",(e)=>{
    const name = document.getElementById("name").value.trim()
    const age = parseInt(document.getElementById("age").value.trim())
    
    if(name.length==0){
        alert("name cannot be empty")
        e.preventDefault()
        return false
    }
    if(age<18 || isNaN(age)){
        alert("age cannot be empty or less than 18")
        e.preventDefault()
        return false
    }
    alert(`Form has been submitted successfully`)
})