/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.sessionbeans;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nu.te4.entities.Users;

/**
 *
 * @author olalindsten
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "projekt6PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
/*
    @EJB
    public List users(String name) {
        return em.createQuery(
                "SELECT username,password FROM users WHERE username LIKE user")
                .setParameter("custName", name)
                .setMaxResults(10)
                .getResultList();
    }
*/
}
