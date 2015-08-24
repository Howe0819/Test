/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;
import entity.SystemUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
@Stateless
public class SystemUserSession implements SystemUserSessionLocal
{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public SystemUser getSystemUser(String userName)
    {
        Query query = entityManager.createQuery("SELECT u FROM SystemUser u WHERE u.userName = :inUserName");
        query.setParameter("inUserName", userName);
        SystemUser systemUser = null;
        try
            {   
                systemUser = (SystemUser)query.getSingleResult();
            }catch(NoResultException ex)
            {
                ex.printStackTrace();
            }
        return systemUser;
    }
}
