package com.adrynov.benchmarking.data.repository;

import com.adrynov.benchmarking.data.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

//    @Query(value = "SELECT title FROM film f INNER JOIN film_actor fa on f.film_id = fa.film_id WHERE actor_id = ?1", nativeQuery = true)
//    Collection<String> findFilmsByActor(@Param("actorId") int actorId);
//
//    Page<Film> findByTitle(@Param("title") String title, Pageable pageable);


    List<Film> findByTitleContaining(String title);

//    List<Film> findByYear(int year);
//
//    List<Film> findByYearLessThan(int year);

//    @Override
//    @RestResource(exported = false)
//    void deleteAll();
//
//    Course findByName(String name);
//
//    List<Course> findByDepartmentChairMemberLastName(String chair);
//
//    @Query("Select c from Course c where c.department.chair.member.lastName=:chair")
//    List<Course> findByChairLastName(@Param("chair") String chairLastName);
//
//    @Query("Select c from Course c join c.prerequisites p where p.id = ?1")
//    List<Course> findCourseByPrerequisite(int id);
//
////    @Query("Select new CourseView" +
////            "(c.name, c.lastName, c.department.name) from Course c where c.id=?1")
////    CourseView getCourseView(int courseId) ;
//
//    List<Course> findByCredits(@Param("credits") int credits);

//    Page<Course> findByCredits(@Param("credits") int credits, Pageable pageable);

//      Common Querying Mistake
//      Uncomment to Debug.
//
//    Course findByDeptName(String deptName);
//
//    @Query("Select new com.example.university.view.CourseView" +
//            "(c.name, c.instructor.member.lastName, c.department.name) from course c where c.name=?1")
//    Course getCourseViewByName(String name);

}
