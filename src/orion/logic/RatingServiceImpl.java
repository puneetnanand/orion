package orion.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orion.dao.RatingDao;


@Service("ratingService")
@Transactional(readOnly = true)
public class RatingServiceImpl implements RatingService
{
	@Autowired
	RatingDao ratingDao;

	public String rating(String rating) {
		// TODO Auto-generated method stub
		return ratingDao.ratingInsert(rating);
	}

}
