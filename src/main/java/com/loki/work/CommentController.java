package com.loki.work;

import com.loki.work.model.Comment;
import com.loki.work.service.CommentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by loki on 06.02.17.
 */
@Controller

public class CommentController {

    private Log log = LogFactory.getLog(CommentController.class);

    @Autowired(required = true)
    @Qualifier(value = "jpaCommentService")
    private CommentService commentService;

//    @RequestMapping(value = "/book",method = RequestMethod.GET)
    @RequestMapping(value = {"/index", "/"},method = RequestMethod.GET)
    public String listComments(Model model) {
        model.addAttribute("comment", new Comment());
        model.addAttribute("listAllComments",this.commentService.findAll());
        return "book1";
    }


    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public String addComment(@Valid @ModelAttribute("comment") Comment c,
                             BindingResult result, Model model ){

        if (!result.hasErrors()){
            this.commentService.addComment(c);
            model.addAttribute("comment", new Comment());
        }
        model.addAttribute("listAllComments",this.commentService.findAll());
        return "book1";
    }

}
