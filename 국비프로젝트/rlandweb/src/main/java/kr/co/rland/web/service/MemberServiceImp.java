package kr.co.rland.web.service;

import kr.co.rland.web.entity.Member;
import kr.co.rland.web.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImp implements MemberService {

    @Autowired
    private MemberRepository repository;

    @Override
    public boolean isValid(String username, String password) {
        //crud에 해당하는 것만 요청하라.
//        repository.findById(1L);
        Member member = repository.findByUsername(username);
        if(member == null)
            return false;
        else if(!member.getPassword().equals(password))
            return false;

        return true;
    }
}
