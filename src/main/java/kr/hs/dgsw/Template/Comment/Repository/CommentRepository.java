package kr.hs.dgsw.Template.Comment.Repository;

import kr.hs.dgsw.Template.Comment.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
