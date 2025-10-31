 const fun = (name = "abc") => {
        if (name) {
          console.log("if", name);
        } else {
          console.log("else", name);
        }
      };
	  
fun(""); 


// Output: answer will be "else"
// because here we passing empty string so "name" parameter is not undefine and it will falll under else condition and print "else"
