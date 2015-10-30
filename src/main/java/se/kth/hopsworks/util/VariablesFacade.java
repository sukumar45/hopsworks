/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.hopsworks.util;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import se.kth.hopsworks.user.model.Users;
import se.kth.kthfsdashboard.user.AbstractFacade;


@Stateless
public class VariablesFacade extends AbstractFacade<Variables> {

  @PersistenceContext(unitName = "kthfsPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public VariablesFacade() {
    super(Variables.class);
  }

  /**
   * Get the variable value with the given name.
   * <p/>
   * @param id
   * @return The user with given email, or null if no such user exists.
   */
  public Variables findById(String id) {
    try {
      return em.createNamedQuery("Variables.findById", Variables.class).setParameter("id", id).getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }
  
//  public void setIdValue(String id, String value) {
//    Variables v = new Variables(id, value);
//    try {
//      em.persist(v)
//    } catch (EntityExistsException ex) {
//    }
//  }

  public void detach(Variables variable) {
    em.detach(variable);
  }

}
