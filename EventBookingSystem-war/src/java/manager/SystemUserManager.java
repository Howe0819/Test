/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;
import entity.SystemUser;
import session.stateless.SystemUserSessionLocal;
public class SystemUserManager
{
    private SystemUserSessionLocal systemUserSessionLocal;
    public SystemUserManager()
    {
}
    public SystemUserManager(SystemUserSessionLocal systemUserSessionLocal)
    {
        this.systemUserSessionLocal = systemUserSessionLocal;
}
    public Long doLogin(String userName, String password)
    {
        SystemUser systemUser =
systemUserSessionLocal.getSystemUser(userName);
        if(systemUser == null) return null;
        else
        {
            if(systemUser.getPassword().equals(password)) return
systemUser.getSystemUserId();
            else return null;
        }
} }
