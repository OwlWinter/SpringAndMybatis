package cn.mogeek.service;

import cn.mogeek.domain.Disciple;
import cn.mogeek.dao.DiscipleDao;
import java.util.List;
import java.util.Map;

public class ServiceImpl implements Service {

    private DiscipleDao discipleDao;

    public void setDiscipleDao(DiscipleDao discipleDao){ this.discipleDao = discipleDao; }

    public DiscipleDao getDiscipleDao(){ return discipleDao; }

    @Override
    public List<Disciple> query(Disciple disciple){
        return discipleDao.query(disciple);
    }

    @Override
    public int insert(Disciple disciple){ return discipleDao.insert(disciple); }

    @Override
    public boolean update(Disciple disciple){
        return discipleDao.update(disciple) == 1 ? true: false;
    }

    @Override
    public boolean delete(int id){
        return discipleDao.delete(id) == 1 ? true: false;
    }

    @Override
    public String queryForLink(Map<String, String> name_OR_id){
        Disciple disciple = new Disciple();

        if (!name_OR_id.isEmpty()){
            disciple.setStudent_name(name_OR_id.get("name"));

            if (name_OR_id.containsKey("id")){
                int id = 0;

                try {
                    id = Integer.parseInt(name_OR_id.get("id"));
                }catch (NumberFormatException e){
                    return "The value of 'id' is not Integer.";
                }
                disciple.setStudent_id(id);
            }

            List<Disciple> discipleList = discipleDao.query(disciple);
            if (discipleList.size() == 1){
                return discipleList.get(0).getDaily_report();
            }
            else {
                return discipleList.size() == 0 ? "Match Nothing." : "Too many context.";
            }

        }
        else {
            return "Empty Map.";
        }
    }

}
