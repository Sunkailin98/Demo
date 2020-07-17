package com.demo;

import com.demo.mapper.LibrarianMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;

/**
 * Description:
 *
 * @author lyp
 * @date 2020/07/10
 */
@RestController
public class LibrarianController {
	@Autowired
	private LibrarianService librarianService;

	@GetMapping("/getLibrarian")
	public Librarian getALibrarianInfo(int id) {
		Librarian librarian= librarianService.selectLibrarian(id);
		return librarian;
	}
	@GetMapping("/deleteLibrarian")
	public void deleteLibrarianByID(int id) {
		Librarian delete = librarianService.deleteLibrarian(id);
		System.out.println("第"+id+"条信息删除成功！");
	}
	@GetMapping("/getAllLibrarian")
	public List<Librarian> getAllLibrarian() {
		List<Librarian> list = librarianService.getAllLibrarian();
		return list;
	}
	@GetMapping("/addLibrarian")
	public void insertLibrarian(Librarian librarian) {
		librarianService.insertLibrarian(librarian);
		System.out.println("信息添加成功！");
	}
	@GetMapping("/updateLibrarian")
	public void updateLibrarian(Librarian librarian) {
		librarianService.updateLibrarian(librarian);
		System.out.println("信息更新成功！");
	}
	@GetMapping("/ExistOneLibrarian")
	public boolean isExistOneUser(String username) {
		boolean librarian = librarianService.isExistOneLibrarian(username);
		if (librarian) {
			return true;
		} else {
			return false;
		}
	}
	@GetMapping("/findByPager")
	public Pager<Librarian> findByPager(Integer page, Integer size) {
		Pager<Librarian> librarianPager = librarianService.findByPager(page,size);
		return librarianPager;
	}
//	@GetMapping("/pagenumber")
//	public String queryUser(@RequestParam(required = true,defaultValue = "1") Integer page, Model model) throws Exception {
//		InputStream in = Resources.getResourceAsStream("application.properties");
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//		SqlSession session = factory.openSession();
//		LibrarianMapper mapper = session.getMapper(LibrarianMapper.class);
//		//开始执行分页,每页5条数据
//		PageHelper.startPage(page,5);
//		List<Librarian> librarians = mapper.queryLibrarian();
//		//创建pageInfo对象保存查询出的结果
//		PageInfo<Librarian> pageInfo = new PageInfo<>(librarians);
//		//将数据存入model中
//		model.addAttribute("librarians",librarians);
//		model.addAttribute("page",pageInfo);
//		return "show";
//	}

}
