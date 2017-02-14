package com.loki.work;


import com.loki.work.model.Comment;
import com.loki.work.service.CommentService;
import javax.transaction.Transactional;
import javax.validation.constraints.AssertTrue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loki
 */
@ContextConfiguration(locations = "classpath:context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class GuestbookTest {
    
    private Log log = LogFactory.getLog(CommentController.class);

    @Autowired(required = true)
    @Qualifier(value = "jpaCommentService")
    private CommentService commentService;
    
    
    @Test
    @Transactional
    @Rollback(true)
    public void testAddComment(){
        
        Comment comment = new Comment();
        
        comment.setUserName("Loki");
        comment.setComment("Some Test comment");
        
        int oldCount = commentService.findAll().size();
        commentService.addComment(comment);
        
        Assert.assertNotNull(commentService.findAll()); 
        
        int newCount = commentService.findAll().size();
        
        
        Assert.assertEquals(oldCount+1, newCount);
                       
    }
}
