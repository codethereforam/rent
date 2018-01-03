package priv.thinkam.rent.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import priv.thinkam.rent.dao.model.Category;
import priv.thinkam.rent.dao.model.CategoryExample;

public interface CategoryMapper {
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}