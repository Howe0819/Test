/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.exception;

public class VenueConflictException extends Exception
{
    public VenueConflictException()
    {}
    
    public VenueConflictException(String msg)
    {
        super(msg);
    } 
}
