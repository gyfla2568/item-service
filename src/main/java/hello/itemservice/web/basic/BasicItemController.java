package hello.itemservice.web.basic;

import hello.itemservice.domain.board.BoardRepository;
import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
public class BasicItemController {

    private final ItemRepository itemRepository;
    private final BoardRepository boardRepository;

    public BasicItemController(ItemRepository itemRepository, BoardRepository boardRepository) {
        this.itemRepository = itemRepository;
        this.boardRepository = boardRepository;
    }

    @GetMapping
    public String items(Model model) {
//        List<Item> items = itemRepository.findAll();
        List<Item> items = boardRepository.select();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

    //    @PostMapping("/add")
    public String addItemV1(@RequestParam String itemName,
                            @RequestParam String contents,
                            @RequestParam String customer,
                            Model model) {

        Item item = new Item();
        item.setItemName(itemName);
        item.setContents(contents);
        item.setCustomer(customer);

        itemRepository.save(item);

        model.addAttribute("item", item);

        return "basic/item";
    }

    //    @PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item, Model model) {

        itemRepository.save(item);
//      model.addAttribute("item", item); //자동 추가, 생략 가능

        return "basic/item";
    }

    //    @PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item) {
        itemRepository.save(item);
        return "basic/item";
    }

    //    @PostMapping("/add")
    public String addItemV4(Item item) {
        itemRepository.save(item);
        return "basic/item";
    }

    //    @PostMapping("/add")
    public String addItemV5(Item item) {
        itemRepository.save(item);
        return "redirect:/basic/items/" + item.getId();
    }

    @PostMapping("/add")
    public String addItemV6(Item item, RedirectAttributes redirectAttributes) {
        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
        itemRepository.update(itemId, item);
        return "redirect:/basic/items/{itemId}";
    }


    @GetMapping("/{itemId}/delete")
    public String delete(@PathVariable Long itemId) {
        itemRepository.deleteById(itemId);
        return "redirect:/basic/items/";
    }

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("안녕하세요", "새로 들어오게 되었습니다.", "뿡삥"));
        itemRepository.save(new Item("신입생입니다", "적응가능할까요?.", "효림"));
        itemRepository.save(new Item("반갑습니다잉", "게시판이 잘 될까요?", "준수"));
        itemRepository.save(new Item("에스파 신곡리뷰", "에스파는 나야", "해윙"));
        itemRepository.save(new Item("첫회사 들어왔어요", "실력이 너무 부족한 것 같아요.", "허잉"));
        itemRepository.save(new Item("허팝나무 대신 별명 뭐할까요", "그짓말이지롱", "허팝나무"));
        itemRepository.save(new Item("신입여캠입니다.", "별풍선 많이 받고싶어요.", "BJ초아"));
        itemRepository.save(new Item("즐거운 하루 보내십쇼", "나는야 즐거운봉준", "BJ봉준"));
        itemRepository.save(new Item("미미가 이달의 소녀인가", "츄입니다 귀여워 사랑스러워", "이달의소녀"));
        itemRepository.save(new Item("이뻐지고 싶은 사람들아", "여기 붙어라", "연예인"));


    }

}

