/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import model.Competence;
import integration.RegisterDAO;

/**
 *
 * @author Sam
 */

/**
 * The AdminController class is a controller class 
 * meant to handle actions taken on the admin console.
 * 
 * However, this class cannot access the database directly.
 * Instead, it uses the competenceDAO and registerDAO 
 * in order to carry out database related transactions.
 * 
 */

@Stateful
public class AdminController {
    
}
