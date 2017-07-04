package org.stream.common.mongodb;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.stream.common.mongodb.dao.MemberDao;
import org.stream.common.mongodb.dmeo.entity.Member;

public class MemberDaoTest extends AbstractConfigTest{

	 @Autowired
	    private ApplicationContext ctx;
	    @Autowired
	    private MemberDao memberDao;
	    /**
	     * 测试保存
	     */
	    @Test
	    public void saveTest(){
	        for(int i=0;i<100;i++){
	            Member member=new Member();
	            int j=new Random().nextInt(100);
	            member.setUsername("test"+j);
	            member.setSex(j%2==0?"男":"女");
	             j=new Random().nextInt(100);
	            member.setPassword(j+"");
	            member.setEmail(j+"@"+"qq.com");
	            memberDao.save(member);
	            System.out.println("member 保存成功："+member);
	        }

	    }
	    @Test
	    public void deleteTest(){
	        Member m=memberDao.queryById("1");
	        if(null!=m){
	            memberDao.delete(m);
	            System.out.println("删除member："+m);
	        }
	    }
	    @Test
	    public void updateFirstTest(){
	        Member m=memberDao.queryById("5704b88609a825017e751075");
	        if(null!=m){
	            m.setUsername("test");
	            this.memberDao.updateFirst(m);
	        }
	    }

	    @Test
	    public void queryPageCountTest(){
	        long l=memberDao.queryPageCount(null);
	        System.out.println("member 总数："+l);
	    }
	    @Test
	    public void queryPageTest(){
	        Member member=new Member();
	        //member.setId("5704b88609a825017e751073");
	        //member.setEmail("333");
	        //member.setUsername("赖兆世");
	        Sort sort=new Sort(Direction.DESC, "username");
	        List<Member> mList=this.memberDao.queryPage(member, 1, 20,sort);
	        System.out.println("############:"+mList.size());
	        for(Member m:mList){
	            System.out.println("member:"+m);
	        }
	        //assertEquals("6",mList.size()+""); 
	    }
	    @Test
	    public void queryPageTest1(){
	        List<Member> mList =this.memberDao.queryPage("2", 1, 100, null);
	        System.out.println("############:"+mList.size());
	        for(Member m:mList){
	            System.out.println("member:"+m);
	        }
	    }
}
