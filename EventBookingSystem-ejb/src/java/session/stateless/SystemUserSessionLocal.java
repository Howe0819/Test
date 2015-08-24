/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;
import entity.SystemUser;
import javax.ejb.Local;

@Local
public interface SystemUserSessionLocal
{
    public SystemUser getSystemUser(String userName);
}