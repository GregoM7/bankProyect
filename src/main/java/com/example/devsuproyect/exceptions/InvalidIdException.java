package com.example.devsuproyect.exceptions;

public class InvalidIdException extends RuntimeException{
    public InvalidIdException() {
        super("el id no puede ser null o 0, ni contener valores negativo");
    }

}
