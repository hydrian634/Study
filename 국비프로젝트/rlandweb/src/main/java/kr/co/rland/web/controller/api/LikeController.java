package kr.co.rland.web.controller.api;

import kr.co.rland.web.entity.Like;
import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController("apiListController")
@RequestMapping("/api/likes")
public class LikeController {

    @Autowired
    private LikeService service;

    @PostMapping
    public Like reg(@RequestBody Like like){

        Like newOne = service.add(like);

        return newOne;
    }

    //Delete /api/likes/2/members/1 (${menuId}/members/${memberId})

    @DeleteMapping("{menu-id}/members/{member-id}")   // {}는 경로로 바꿔주는 것.
    public Boolean delete(@PathVariable("menu-id") Long menuId){

        Long memberId = 1L;
        boolean result = service.delete(menuId, memberId);
        return result;
    }
}
