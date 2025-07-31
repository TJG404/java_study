package db;

import java.util.List;
import com.scoremgm.model.MemberVo;

public interface GenericRepositoryInterface<T> {
	int insert(T entity);
	int getCount();
	List<T> findAll();
//	int remove(String no);
//	int update(T entity);
//	T find(String no);
}
