package kr.co.rland.web.repository;

import kr.co.rland.web.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {
    Member findByUsername(String userName);

    void save(Member member);

    Member last();
}
