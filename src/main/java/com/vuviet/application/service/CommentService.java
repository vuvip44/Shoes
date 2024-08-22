package com.vuviet.application.service;

import org.springframework.stereotype.Service;

import com.vuviet.application.entity.Comment;
import com.vuviet.application.model.request.CreateCommentPostRequest;
import com.vuviet.application.model.request.CreateCommentProductRequest;

@Service
public interface CommentService {
    Comment createCommentPost(CreateCommentPostRequest createCommentPostRequest,long userId);
    Comment createCommentProduct(CreateCommentProductRequest createCommentProductRequest, long userId);
}
