package com.mudchobo.sosi.sosischedule.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.appengine.api.datastore.KeyFactory;
import com.mudchobo.sosi.sosischedule.entity.Schedule;
import com.mudchobo.sosi.sosischedule.entity.Sosi;

@Repository
public class SosiDao {
    private EntityManager em;
    
    @Autowired
    public void setEntityManager(EntityManager em) {
        this.em = em;
        
        // 소시데이터 추가
        addSosi(new Long(1), "효연");
        addSosi(new Long(2), "윤아");
        addSosi(new Long(3), "수영");
        addSosi(new Long(4), "유리");
        addSosi(new Long(5), "태연");
        addSosi(new Long(6), "제시카");
        addSosi(new Long(7), "티파니");
        addSosi(new Long(8), "써니");
        addSosi(new Long(9), "서현");
    }
    
    public void addSosi(Long id, String sosiName) {
        em.getTransaction().begin();
        em.persist(new Sosi(KeyFactory.createKey(Sosi.class.getSimpleName(), id), sosiName));
        em.getTransaction().commit();
    }
    
    @SuppressWarnings("unchecked")
    public List<Sosi> getSosiList() {
        return em.createQuery("select s from Sosi s").getResultList();
    }

    public Sosi getSosi(Long sosiId) {
        return em.find(Sosi.class, sosiId);
    }
    
    @SuppressWarnings("unchecked")
    public List<Schedule> getScheduleList(final Long sosiId) {
        Query q = em.createQuery("select s.scheduleList from Sosi s where s.key = :key");
        q.setParameter("key", KeyFactory.createKey(Sosi.class.getSimpleName(), sosiId));
        return (List<Schedule>) q.getSingleResult();
    }
    
    public void addSchedule(Long sosiId, String program) {
        em.getTransaction().begin();
        Sosi sosi = em.find(Sosi.class, sosiId);
        sosi.getScheduleList().add(new Schedule(program, sosi));
        em.getTransaction().commit();
    }
    
    public void deleteSchedule(String scheduleKey) {
        em.getTransaction().begin();
        Schedule schedule = em.find(Schedule.class, scheduleKey);
        em.remove(schedule);
        em.getTransaction().commit();
    }
}