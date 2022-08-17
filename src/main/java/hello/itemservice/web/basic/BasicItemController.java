package hello.itemservice.web.basic;

import com.mysql.cj.Session;
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
        List<itemId> itemId = boardRepository.selectById(itemId);
        model.addAttribute("itemId", itemId);
        System.out.println(itemId);
        System.out.println(item);
//        Item item = itemRepository.findById(itemId);
//        System.out.println(item);
//        model.addAttribute("id", itemId);
//        //item x, itemId x,
//        System.out.println(itemId);
        return "basic/item";
    }

//    @PostMapping("/add")
//    public String addForm(Model model) {
//        List<Item> items = boardRepository.insert();
//        model.addAttribute("items", items);
//        return "basic/addForm";
//    }
//
//    //    @PostMapping("/add")
//    @PostMapping ("/{itemId}")
//    public String addItemV1(Model model) {
//        //Item item = new Item();
//        boardRepository.insert();
//        boardRepository.insert();
//        boardRepository.insert();
//
//        List<Item> item=boardRepository.insert();
//
//        model.addAttribute("item", item);
//
//        return "basic/item";
//    }
//
//    @PutMapping("/{itemId}/edit")
//    public String editForm(@PathVariable Long itemId, Model model) {
//        List<Item> item = boardRepository.update();
//        model.addAttribute("item", item);
//        return "basic/editForm";
//    }
//    @PutMapping("/{itemId}/edit")
//    public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
//        boardRepository.update(itemId, item);
//        return "redirect:/basic/items/{itemId}";
//    }
//
//
//    @DeleteMapping("/{itemId}/delete")
//    public String delete(@PathVariable Long itemId, Model model) {
//        boardRepository.delete();
//        return "redirect:/basic/items/";
//    }


}

