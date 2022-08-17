package hello.itemservice.domain.board;

import hello.itemservice.domain.item.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardRepository {
    List<Item> select();

    List<Item> selectById();

    List<Item> insert();

    List<Item> upsert();

    List<Item> delete();
}
