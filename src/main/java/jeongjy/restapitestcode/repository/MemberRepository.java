package jeongjy.restapitestcode.repository;

import java.util.Optional;
import jeongjy.restapitestcode.dto.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

  Optional<Member> findByName(String name);
}
