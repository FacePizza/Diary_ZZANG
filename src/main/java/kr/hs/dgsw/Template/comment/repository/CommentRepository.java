package kr.hs.dgsw.Template.comment.repository;

import kr.hs.dgsw.Template.comment.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
