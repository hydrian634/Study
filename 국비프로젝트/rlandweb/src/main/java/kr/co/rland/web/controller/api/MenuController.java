package kr.co.rland.web.controller.api;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("apiMenuController")
@RequestMapping("/api/menus")
public class MenuController {
//    API를 지원하는 컨트롤러
@Autowired
private MenuService service;

//목록을 제공하는 API
//@ResponseBody
@GetMapping
@CrossOrigin(origins = "http://192.168.0.73:5500") // 메서드에서 설정
    public List<MenuView> list(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "q", required = false) String query,
            @RequestParam(name = "c", required = false) Long categoryId){
//필수로 있어야 하는 값은 기본값으로 넣어주고
    //그게 아닌 있어도 없어도인 것은 required를 false로 해주자.

    List<MenuView> list =service.getViewList(page, query, categoryId);
    return list;
}
//16번 메뉴(menu_id 기준)
@GetMapping("{id}")
public Menu detail(@PathVariable long id
//        , @PathVariable String name
                    ){
    Menu menu = service.getById(id);
    return menu;
}

//메뉴를 등록하는 API
    @PostMapping
    public Menu reg(@RequestBody Menu menu){
        System.out.println(menu);
    Menu newOne = service.add(menu);
        System.out.println("--------------------------------");
        System.out.println(newOne);
    return newOne;
    }

    //메뉴를 수정하는 API
    @PutMapping
    public Menu edit(@RequestBody Menu menu){
    Menu edit = service.update(menu);
    return edit;
    }

    //좋아요 확인하는 API


}



