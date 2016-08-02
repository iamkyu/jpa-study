package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * @author Kj Nam
 * @since 2016-08-02
 */
public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("jpabook");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            logic(entityManager);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }

    private static void logic(EntityManager entityManager) {
        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("Kyu");
        member.setAge(7);

        //등록
        entityManager.persist(member);

        //수정
        member.setAge(3);

        //한건조회
        Member findMember = entityManager.find(Member.class, id);
        System.out.println("findMember= " + findMember.getUsername() + ", age= " + member.getAge());

        //목록조회 (JPQL)
        List<Member> members = entityManager
                .createQuery("select m from Member m", Member.class)
                .getResultList();
        System.out.println("member.size= " + members.size());

        //삭제
        entityManager.remove(member);
    }
}
