package org.stream.common.mongodb.dao;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.stream.common.mongodb.dmeo.entity.Member;

@Repository
public class MemberDao extends MongoGenDao<Member> {
    @Override
    protected Class getEntityClass() {
        return Member.class;
    }
    /**
     * 分页查询
     * @param member 查询条件
     * @param page 第几页数据
     * @param pageSize 每页数据的大小
     * @return
     */
    public List<Member> queryPage(Member member,int page,int pageSize,Sort sort){
        Query query=new Query();
        //此处可以增加分页查询条件Criteria.然后query.addCriteria(criteria);
        if(null!=member){
            if(StringUtils.isNotBlank(member.getId())){
                query.addCriteria(Criteria.where("_id").is(member.getId()));
            }
            if(StringUtils.isNotBlank(member.getUsername())){
                query.addCriteria(Criteria.where("username").is(member.getUsername()));
            }
            if(StringUtils.isNotBlank(member.getPassword())){
                query.addCriteria(Criteria.where("password").is(member.getPassword()));
            }
            if(StringUtils.isNotBlank(member.getSex())){
                query.addCriteria(Criteria.where("sex").is(member.getSex()));
            }
            if(StringUtils.isNotBlank(member.getEmail())){
                query.addCriteria(Criteria.where("email").is(member.getEmail()));
            }
        }
        if(null!=sort){
            query.with(sort);
        }
        return getPage(query, (page-1)*pageSize, pageSize,sort);
    }
    /**
     * 查询满足分页的记录总数
     * @param member 查询的条件
     * @return
     */
    public Long queryPageCount(Member member){
        Query query=new Query();
        //此处可以增加分页查询条件Criteria.然后query.addCriteria(criteria);
        return getPageCount(query);
    }
    /**
     * 根据用户名
     * @param usernameLike
     * @param page
     * @param pageSize
     * @param sort
     * @return
     */
    public List<Member> queryPage(String usernameLike,int page,int pageSize,Sort sort){
        Query query=new Query();
        //此处可以增加分页查询条件Criteria.然后query.addCriteria(criteria);
        if(StringUtils.isNotBlank(usernameLike)){
            Pattern pattern = Pattern.compile("^.*"+usernameLike+".*$", Pattern.CASE_INSENSITIVE);//模糊匹配
            //Pattern pattern = Pattern.compile("^"+usernameLike+".*$", Pattern.CASE_INSENSITIVE);//左匹配
            //Pattern pattern = Pattern.compile("^.*"+usernameLike+"$", Pattern.CASE_INSENSITIVE);//右匹配
            query.addCriteria(Criteria.where("username").regex(pattern));
        }
        if(null!=sort){
            query.with(sort);
        }
        return getPage(query, (page-1)*pageSize, pageSize,sort);
    }
    /**
     * 更新数据，更新满足条件的第一天记录
     * @param member
     */
    public void updateFirst(Member member){
        Update update=new Update();
        if(StringUtils.isBlank(member.getId())){
            throw new RuntimeException("Update data Id is null ");
        }
        if(StringUtils.isNotBlank(member.getUsername())){
            update.set("username", member.getUsername());
        }
        if(StringUtils.isNotBlank(member.getPassword())){
            update.set("password", member.getPassword());
        }
        if(StringUtils.isNotBlank(member.getSex())){
            update.set("sex", member.getSex());
        }
        if(StringUtils.isNotBlank(member.getEmail())){
            update.set("email", member.getEmail());
        }
        updateFirst(Query.query(Criteria.where("_id").is(member.getId())), update);
    }
    /**
     * 更新数据，更新满足条件的多条记录
     * @param member
     */
    public void updateMulti(Member member){
        Update update=new Update();
        if(StringUtils.isBlank(member.getId())){
            throw new RuntimeException("Update data Id is null ");
        }
        if(StringUtils.isNotBlank(member.getUsername())){
            update.set("username", member.getUsername());
        }
        if(StringUtils.isNotBlank(member.getPassword())){
            update.set("password", member.getPassword());
        }
        if(StringUtils.isNotBlank(member.getSex())){
            update.set("sex", member.getSex());
        }
        if(StringUtils.isNotBlank(member.getEmail())){
            update.set("email", member.getEmail());
        }
        updateMulti(Query.query(Criteria.where("_id").is(member.getId())), update);
    }
}