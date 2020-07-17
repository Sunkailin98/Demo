package com.demo;


import java.util.List;

/**
 * Description:
 *
 * @author lyp
 * @date 2020/07/10
 */
public interface LibrarianService {
	//根据id获取一条信息
	Librarian selectLibrarian(int id);
	//添加一条信息
	void insertLibrarian(Librarian librarian);
	//根据id删除用户信息
	Librarian deleteLibrarian(int id);
	//更新用户信息
	void updateLibrarian(Librarian librarian);
	//获取所有用户信息
	List<Librarian> getAllLibrarian();
	//根据用户名判断该用户是否存在
	boolean isExistOneLibrarian(String username);

//	List<Librarian> findLibrarianByPage(int pageno,int pagesize);
	//分页显示
	Pager<Librarian> findByPager(Integer page,Integer size);
}
