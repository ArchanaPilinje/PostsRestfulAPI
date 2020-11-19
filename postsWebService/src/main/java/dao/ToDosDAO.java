package dao;

import java.util.List;

import com.posts.Status;
import com.posts.ToDos;

public interface ToDosDAO {
ToDos insert(ToDos t);
ToDos update(int id);
Status delete(int id);
List<ToDos> view();
}
