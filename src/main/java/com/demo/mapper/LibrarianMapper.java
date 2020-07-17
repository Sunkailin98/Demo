package com.demo.mapper;

import com.demo.Librarian;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * @author lyp
 * @date 2020/07/10
 */
@Mapper
public interface LibrarianMapper {
	//通过id查询某个信息
	Librarian selectLibrarian(int id);
	//添加一条信息
	void insertLibrarian(Librarian librarian);
	//通过id删除一条信息
	void deleteLibrarian(int id);
	//更新一条信息
	void updateLibrarian(Librarian librarian);
	//获取数据库中所有的信息
	List<Librarian> getAllLibrarian();
	//通过用户名判断该用户是的存在
	Librarian getOneLibrarian(String username);

//	List<Librarian> findLibrarianByPage(int pageno,int pagesize);
    //将数据库中的信息进行分页显示
    List<Librarian> findByPager(Map<String, Object> params);
	long count();
}
