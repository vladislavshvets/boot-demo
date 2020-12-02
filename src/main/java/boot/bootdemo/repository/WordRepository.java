package boot.bootdemo.repository;

import boot.bootdemo.model.Word;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    List<Word> findAllByOrderByAmountDesc(Pageable pageable);
}
