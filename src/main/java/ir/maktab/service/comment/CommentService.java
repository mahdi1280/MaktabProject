package ir.maktab.service.comment;

import ir.maktab.model.Comment;

public interface CommentService {

    void save(Comment comment);

    Comment findById(long id);
}
