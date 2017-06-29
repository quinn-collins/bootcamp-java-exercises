package com.techelevator.ssg.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.ssg.model.forum.ForumDao;
import com.techelevator.ssg.model.forum.ForumPost;

@Controller
public class SpaceForumController {
	@Autowired
	ForumDao forumDao;
	
	@RequestMapping(path="/spaceForumView", method=RequestMethod.GET)
	public String showSpaceForumView(HttpServletRequest request) {
		
		List<ForumPost> forumPosts = forumDao.getAllPosts();
		request.setAttribute("forumPosts", forumPosts);
		
		return "spaceForumView";
	}
	
	@RequestMapping(path="/spaceForumInput", method=RequestMethod.GET)
	public String showSpaceForumInput() {
		return "spaceForumInput";
	}
	
	@RequestMapping(path="/spaceForumInput", method=RequestMethod.POST)
	public String processSpaceForumInput(ForumPost post) {
		post.setDatePosted(LocalDateTime.now());

		forumDao.save(post);
			
		return "redirect:/spaceForumView";
	}
}













