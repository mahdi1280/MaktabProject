package ir.maktab.service.comment;

import ir.maktab.model.Comment;
import ir.maktab.repository.CommentRepository;

public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;

    public CommentServiceImpl(){
        this.commentRepository=new CommentRepository() {};
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public Comment findById(long id){
        return commentRepository.findById(Comment.class,id);
    }
}
