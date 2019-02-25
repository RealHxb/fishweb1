package com.elangzhi.fish.dao;

import com.elangzhi.fish.model.ChouQian;
import com.elangzhi.fish.model.Grade;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface GradeMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract Long insert(Grade paramGrade);
  
  public abstract Long insertSelective(Grade paramGrade);
  
  public abstract Grade selectByPrimaryKey(Long paramLong);
  
  public abstract int updateByPrimaryKeySelective(Grade paramGrade);
  
  public abstract int updateByPrimaryKey(Grade paramGrade);
  
  public abstract List<Grade> findInfo1(@Param("gameId") Long paramLong, @Param("chang") Integer paramInteger1, @Param("qu") Integer paramInteger2);
  
  public abstract List<Grade> findInfo2(@Param("gameId") Long paramLong, @Param("number") Integer paramInteger);
  
  public abstract List<Grade> CheckInfo(@Param("gameId") Long paramLong, @Param("chang") Integer paramInteger1, @Param("qu") Integer paramInteger2);
  
  public abstract List<Grade> listByGame(Long paramLong);
  
  public abstract List<Grade> countQu(Long paramLong);
  
  public abstract List<Grade> findByGameChangPerson(@Param("gameId") Long paramLong1, @Param("chang") Integer paramInteger, @Param("personId") Long paramLong2);
  
  public abstract List<Grade> gradeShow(@Param("gameId") Long paramLong, @Param("chang") Integer paramInteger1, @Param("qu") Integer paramInteger2);
  
  public abstract List<Grade> jifen(@Param("gameId") Long paramLong, @Param("chang") Integer paramInteger1, @Param("qu") Integer paramInteger2);
  
  public abstract List<Grade> zongfenShow(@Param("gameId") Long paramLong);
  
  public abstract List<Grade> zongfenCheck(@Param("gameId") Long paramLong);
  
  public abstract List<Grade> findByChangNumber(@Param("gameId") Long paramLong1, @Param("chang") Integer paramInteger, @Param("personId") Long paramLong2);
  
  public abstract List<Grade> groupShow(@Param("gameId") Long paramLong, @Param("chang") Integer paramInteger1, @Param("qu") Integer paramInteger2);
  
  public abstract List<Grade> groupCheck(@Param("gameId") Long paramLong, @Param("chang") Integer paramInteger1, @Param("qu") Integer paramInteger2);
  
  public abstract List<Grade> findDabianGrade(@Param("gameId") Long paramLong1, @Param("chang") Integer paramInteger1, @Param("personId") Long paramLong2, @Param("room") Integer paramInteger2);
  
  public abstract List<Grade> findPersonAllNumberGrade(Grade paramGrade);
  
  public abstract List<Grade> findPersonAllGrade(Grade paramGrade);
  
  public abstract List<Grade> findPersonAllWeightGrade(Grade paramGrade);
  
  public abstract List<Grade> findGroupAllGrade(@Param("personName") String paramString, @Param("gameId") Long paramLong, @Param("chang") Integer paramInteger1, @Param("qu") Integer paramInteger2);
  
  public abstract List<Grade> findGroupAllWeightGrade(@Param("personName") String paramString, @Param("gameId") Long paramLong, @Param("chang") Integer paramInteger1, @Param("qu") Integer paramInteger2);
  
  public abstract List<Grade> findGroupAllNumberGrade(@Param("personName") String paramString, @Param("gameId") Long paramLong, @Param("chang") Integer paramInteger1, @Param("qu") Integer paramInteger2);
  
  public abstract int getMaxGradeByGame(@Param("gameId") Long paramLong);

  public abstract List<ChouQian> chouQianList(@Param("gameId")Long gameId,@Param("chang")int chang);

public abstract Grade findItem(Grade g);

}


/* Location:              E:\1 CoddingProject\webapps\fishweb.war!\WEB-INF\classes\com\elangzhi\fish\dao\GradeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */