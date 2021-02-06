package com.github.saintukrainian.storebackend.dao;

import com.github.saintukrainian.storebackend.authentication.LoginData;
import com.github.saintukrainian.storebackend.authentication.UserCredentials;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserDAO {
    private EntityManager entityManager;

    @Autowired
    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public boolean isRegistered(UserCredentials userCredentials) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery(
                "from UserCredentials where email =: email or login =: login");
        query.setParameter("email", userCredentials.getEmail());
        query.setParameter("login", userCredentials.getLogin());
        return query.getResultList().size() != 0;
    }

    public boolean registerNewUser(UserCredentials userCredentials) {
        Session session = entityManager.unwrap(Session.class);
        if (isRegistered(userCredentials)) {
            return false;
        }
        session.save(userCredentials);
        return true;
    }

    public boolean loginUser(LoginData loginData) {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery(
                "from UserCredentials where login =: login and password =: password");
        query.setParameter("login", loginData.getLogin());
        query.setParameter("password", loginData.getPassword());

        return query.getResultList().size() > 0;
    }

    public UserCredentials getUserCredentials(LoginData loginData) {
        Session session = entityManager.unwrap(Session.class);

        Query<UserCredentials> userCredentialsQuery = session.createQuery(
                "from UserCredentials where login =: login and password =: password",
                UserCredentials.class);
        userCredentialsQuery.setParameter("login", loginData.getLogin());
        userCredentialsQuery.setParameter("password", loginData.getPassword());

        return userCredentialsQuery.getSingleResult();
    }
}
