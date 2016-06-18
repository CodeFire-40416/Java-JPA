/*
 * Copyright (C) 2016 CodeFireUA <edu@codefire.com.ua>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ua.com.codefire;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import ua.com.codefire.entity.User;

/**
 *
 * @author CodeFireUA <edu@codefire.com.ua>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Connection
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MainPU");
        // Statement
        EntityManager manager = factory.createEntityManager();

        //<editor-fold defaultstate="collapsed" desc="SELECT ALL">
//        TypedQuery<User> query = manager.createQuery("SELECT u FROM User u", User.class);
//        List<User> users = query.getResultList();
//        
//        for (User user : users) {
//            System.out.println(user);
//        }
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="INSERT (persist)">
//        User user = new User("123456manager", "1234554321");
//        manager.getTransaction().begin();
//        // INSERT
//        manager.persist(user);
//        
//        manager.getTransaction().commit();
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="FIND ONE">
//User foundUser = manager.find(User.class, 2);
//
//System.out.println("Found user: " + foundUser);
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="UPDATE (merge)">
        //foundUser.setPassword("00000000");
        //
        //manager.getTransaction().begin();
        //// UPDATE
        //manager.merge(foundUser);
        //manager.getTransaction().commit();
//</editor-fold>

        User foundSuperManager = manager.createQuery("SELECT u FROM User u WHERE u.name = :username", User.class)
                .setParameter("username", "123456manager")
                .getSingleResult();
        
        manager.getTransaction().begin();
        // DELETE
        manager.remove(foundSuperManager);
        manager.getTransaction().commit();

        factory.close();

    }

}
