package cn.mogeek.dao;

import cn.mogeek.domain.Disciple;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class DiscipleDaoImpl extends SqlSessionDaoSupport implements DiscipleDao {

    @Override
    public List<Disciple> query(Disciple disciple){
        SqlSession sqlSession = this.getSqlSession();

        System.out.println("[" + sqlSession + "]");
        List<Disciple> discipleList = null;
        try {
            discipleList = sqlSession.selectList("mapper.DiscipleDao.query", disciple);
        }catch (DataAccessException e){
            System.out.println(e);
        }
        return discipleList;
    }

    @Override
    public int insert(Disciple disciple){
        SqlSession sqlSession = this.getSqlSession();

        int result = -1;
        try {
            result = sqlSession.insert("mapper.DiscipleDao.insert", disciple);
        }catch (DataAccessException e){
            System.out.println(e);
        }
        return result;
    }

    @Override
    public int update(Disciple disciple){
        SqlSession sqlSession = this.getSqlSession();

        int result = -1;
        if (disciple.getId() > 0){
            try {
                result = sqlSession.update("mapper.DiscipleDao.update", disciple);
            }catch (DataAccessException e){
                System.out.println(e);
            }
        }

        return result;
    }

    @Override
    public int delete(int id){
        SqlSession sqlSession = this.getSqlSession();

        int result = -1;
        try {
            result = sqlSession.delete("mapper.DiscipleDao.delete", id);
        }catch (DataAccessException e){
            System.out.println(e);
        }

        return result;
    }

}
