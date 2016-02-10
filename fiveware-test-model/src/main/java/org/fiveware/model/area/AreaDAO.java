package org.fiveware.model.area;

import java.util.List;

import org.fiveware.dao.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.springframework.stereotype.Repository;

@Repository
public class AreaDAO extends AbstractDAO<Integer, Area> {

	@SuppressWarnings("unchecked")
	public List<Area> getAreas() {
		Criteria criteria = createEntityCriteria();
		criteria.setFetchMode("skills", FetchMode.JOIN);
		criteria.createAlias("skills", "s");
		return (List<Area>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

}
