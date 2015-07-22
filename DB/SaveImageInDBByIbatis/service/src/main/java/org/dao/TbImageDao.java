package org.dao;

import java.util.HashMap;
import java.util.List;

import org.beans.TbImage;

public interface TbImageDao {

	public int insert(TbImage image);
	
	public TbImage queryImage(String id);
	
	public HashMap queryImage2(String id);
	
	public List<TbImage> queryList(TbImage image);
}
