package ir.maktab.service.comment;

import ir.maktab.model.Comment;

import java.util.List;

public interface CommentService {

    void save(Comment comment);

    Comment findById(long id);

    List<Comment> findAll();
}
