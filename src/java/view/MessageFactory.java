package view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * The MessageFactory class handles all the
 * error messages shown to the user.
 */
public class MessageFactory {
    
    private static MessageFactory factory = new MessageFactory();
    
    
    /**
    *Method get the instance of the factory.
    *
    * @return Return the instance of the factory.
    */
    static MessageFactory getInstance(){
        return factory;
    }
    
    
    /**
    * Method add the error message into face context for h:message
    * display
    *
    * @param message
    * 
    */
    public void addErrorMessage(String message){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
            FacesMessage.SEVERITY_ERROR, null, message));
    }
    
    /**
    * Method adds success message into face context for h:message
    *display
    *
    * @param message
    * 
    */
    public void addInfoMessage(String message){
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
            FacesMessage.SEVERITY_INFO, null, message));
    }
}
