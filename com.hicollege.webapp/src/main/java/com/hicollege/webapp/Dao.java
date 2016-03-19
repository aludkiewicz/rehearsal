package com.hicollege.webapp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hicollege.webapp.dtos.Album;
import com.hicollege.webapp.dtos.User;

@Component
@Repository
public class Dao {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<User> getAllUsers() {
        Query query = sessionFactory.getCurrentSession().createQuery("from User");
        
        return (List<User>) query.list();
    }
    
    @Transactional
    public void saveAlbum(Album album) {
        sessionFactory.getCurrentSession().save(album);
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    public List<Album> getAllAlbums() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Album");
        return (List<Album>) query.list();
    }
    
    @Transactional
    public Album findAlbumByTitle(String title) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Album as a where a.title= :title");
        query.setParameter("title", title);
        return (Album) query.uniqueResult();
    }

}
