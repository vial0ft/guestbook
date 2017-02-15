/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loki.work.service;


import com.loki.work.model.Comment;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author loki
 */
@Service("jpaCommentService")
@Repository
@Transactional
public class CommentServiceImpl implements CommentService{
    
    private static final String FIND_ALL_COMMENTS = "select u.id_comment, u.username, u.comment, u.creation_date from user_comments u order by 1 desc";
    private Log log = LogFactory.getLog(CommentServiceImpl.class);
    
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    @Override
    public List<Comment> findAll() {
        List<Comment> comments = em.createNativeQuery(FIND_ALL_COMMENTS, Comment.class).getResultList();
        return comments;
    }
    
    
    @Override
    public void addComment(Comment c) {
       if (c.getId() == null) {
            log.info("Inserting new contact");
            em.persist(c);
            log.info("Contact saved with id: " + c.getId());
        } 
        
    }
    
}
