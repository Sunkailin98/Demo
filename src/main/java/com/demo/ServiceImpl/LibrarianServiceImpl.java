package com.demo.ServiceImpl;

import com.demo.Librarian;
import com.demo.LibrarianService;
import com.demo.Pager;
import com.demo.mapper.LibrarianMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author lyp
 * @date 2020/07/10
 */
@Service
public class LibrarianServiceImpl implements LibrarianService {

	@Autowired
	private LibrarianMapper librarianMapper;

	@Override
	public void insertLibrarian(Librarian librarian) {
		librarianMapper.insertLibrarian(librarian);
	}

	@Override
	public Librarian deleteLibrarian(int id) {
		librarianMapper.deleteLibrarian(id);
		return null;
	}

	@Override
	public void updateLibrarian(Librarian librarian) {
		librarianMapper.updateLibrarian(librarian);
	}

	@Override
	public List<Librarian> getAllLibrarian() {
		return librarianMapper.getAllLibrarian();
	}

	@Override
	public Librarian selectLibrarian(int id) {
		return librarianMapper.selectLibrarian(id);
	}

	@Override
	public boolean isExistOneLibrarian(String username) {
		Librarian librarian = librarianMapper.getOneLibrarian(username);
		if(librarian != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Pager<Librarian> findByPager(Integer page, Integer size) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", (page - 1) * size);
		params.put("size", size);
		Pager<Librarian> pager = new Pager<Librarian>();
		List<Librarian> list = librarianMapper.findByPager(params);
		pager.setRows(list);
		pager.setTotal(librarianMapper.count());
		return pager;
	}

}
