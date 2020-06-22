package br.ufpb.dcx.firstApp.firstAppSpring.exceptions;

public class DisciplinaNotFoundException extends Exception{
    public DisciplinaNotFoundException() {
    }

    public DisciplinaNotFoundException(String message) throws DisciplinaNotFoundException{
        super(message);
    }
}
