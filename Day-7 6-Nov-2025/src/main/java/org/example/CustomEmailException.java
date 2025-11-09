package org.example;

class InvalidEmailException extends Exception{
    InvalidEmailException(String msg){
        System.out.println("Custom Email Exception :"+msg);
    }
}

public class CustomEmailException {
    static String email = "abcgmail.com";

    public static void validateEmail(String email) throws InvalidEmailException{
        if(!email.contains("@")){
            throw new InvalidEmailException("@ not found");
        }
        else{
            System.out.println("email is valid");
        }
    }
    public static void main(String args[]){
        try{
            validateEmail(email);
        }
        catch(Exception e){
            System.out.println("Exception handled here in main");
        }
        finally {
            System.out.println("ended flow");
        }
    }
}
