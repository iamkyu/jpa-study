package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author Kj Nam
 * @since 2016-08-02
 */
public class ExamMergeMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

    public static void main(String[] args) {
        Member mebmer = createMember("memberA", "member1");
        mebmer.setUsername("changedName");
        mergeMember(mebmer);
    }

    private static Member createMember(String id, String username) {
        //영속성 컨테스트1  시작
        EntityManager em1 = emf.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();
        tx1.begin();

        Member member = new Member();
        member.setId(id);
        member.setUsername(username);
        member.setAge(1);

        em1.persist(member);
        tx1.commit();

        em1.close();

        return member;

    }

    private static void mergeMember(Member mebmer) {
        //영속성 컨테스트2  시작
        EntityManager em2 = emf.createEntityManager();
        EntityTransaction tx2 = em2.getTransaction();
        tx2.begin();

        Member mergeMember = em2.merge(mebmer);
        tx2.commit();

        //준영속 상태
        System.out.println("member= " + mebmer.getUsername());

        //영속 상태
        System.out.println("mergeMember= " + mergeMember.getUsername());
        System.out.println("em2 contains member= " + em2.contains(mebmer));
        System.out.println("em2 contains mergeMember= " + em2.contains(mergeMember));

        em2.close();
    }
}
