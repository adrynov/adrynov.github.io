package com.adrynov.benchmarking.data;

public class OtherRepositoryTest {
//
//    @Test
//    public void runJpaRepositoryMethods() {
//
//        departmentRepository.save(new Department("Humanities"));
//        departmentRepository.flush();
//
//        departmentRepository.saveAndFlush(new Department("Fine Arts"));
//
//        departmentRepository.save(new Department("Social Science"));
//
//        System.out.println("\n*************3 Departments*************");
//        departmentRepository.findAll().forEach(System.out::println);
//
//        departmentRepository.deleteInBatch(
//                departmentRepository.findAll().subList(0,1));
//
//        System.out.println("\n*************1 Less Departments*************");
//        departmentRepository.findAll().forEach(System.out::println);
//        departmentRepository.deleteAllInBatch();
//        System.out.println("\n*************Zero Departments*************");
//        departmentRepository.findAll().forEach(System.out::println);
//
//    }

//    /**
//     * Simple Property Expression Queries.
//     *
//     * Students persisted to H2 in-Memory database at startup.
//     * @see UniversityApplication
//     */
//    @Test
//    public void simpleQueryExamples() {
//
//        System.out.println("\nFind 20 year old students");
//        studentRepository.findByAge(20).forEach(System.out::println);
//        System.out.println("\nFind full time old students");
//        studentRepository.findByFullTime(true).forEach(System.out::println);
//        System.out.println("\nFind students with 'doe' as last name");
//        studentRepository.findByAttendeeLastName("doe").forEach(System.out::println);
//    }
//
//    /**
//     * Advanced Property Expression Queries
//     *
//     * Students persisted to H2 in-Memory database at startup.
//     * @see UniversityApplication
//     */
//    @Test
//    public void intermediateQueryExamples() {
//        System.out.println("Find students by name and traverse entities \n" +
//                studentRepository.findByAttendeeFirstNameAndAttendeeLastName("jane","doe"));
//        System.out.println("Find students by name with Person Object \n" +
//                studentRepository.findByAttendee(new Person("jane","doe")));
//
//        System.out.println("\nFind Students older than 19");
//        studentRepository.findByAgeGreaterThan(19).forEach(System.out::println);
//
//        System.out.println("\nFind Students under 19");
//        studentRepository.findByAgeLessThan(19).forEach(System.out::println);
//
//        System.out.println("\nFind Students with last name Doe, despite the case");
//        studentRepository.findByAttendeeLastNameIgnoreCase("Doe").forEach(System.out::println);
//
//        System.out.println("\nFind Students with an i in the last name");
//        studentRepository.findByAttendeeLastNameLike("%i%").forEach(System.out::println);
//
//        System.out.println("\nFind first Student in alphabet \n" +
//                studentRepository.findFirstByOrderByAttendeeLastNameAsc());
//
//        System.out.println("\nFind oldest Student \n" +
//                studentRepository.findTopByOrderByAgeDesc());
//
//        System.out.println("\nFind 3 oldest Students \n" +
//                studentRepository.findTop3ByOrderByAgeDesc());
//
//    }
//
//    /**
//     * @Query Queries
//     *
//     * Courses persisted to H2 in-Memory database at startup.
//     * @see UniversityApplication
//     */
//    @Test
//    public void jpqlQueries() {
//        //*******Method Simplification*******
//
//        System.out.println("Find Courses where Jones is the department Chair with Property Expression");
//        courseRepository.findByDepartmentChairMemberLastName("Jones").forEach(System.out::println);
//
//        //Select c from Course c where c.department.chair.member.lastName=:chair
//        System.out.println("\nFind Courses where Jones is the department Chair with @Query");
//        courseRepository.findByChairLastName("Jones").forEach(System.out::println);
//
//
//        //*******Complex Queries********
//        //Leverage Optional.ifPresent to avoid null checks
//        courseRepository.findByName("English 101").ifPresent(english101 -> {
//            //Select c from Course c join c.prerequisites p where p.id = ?1
//            System.out.println("\nFind Courses where English 101 is a prerequisite");
//            courseRepository.findCourseByPrerequisite(english101.getId())
//                    .forEach(System.out::println);
//
//            //Select new com.example.university.view.CourseView
//            //  (c.name, c.instructor.member.lastName, c.department.name) from Course c where c.id=?1
//            System.out.println("\nCourseView for English 101 \n" +
//                    courseRepository.getCourseView(english101.getId()));
//        });
//    }
//
//    /**
//     * Queries that use Paging and Sorting
//     *
//     * Courses persisted to H2 in-Memory database at startup.
//     * @see UniversityApplication
//     */
//    @Test
//    public void pagingAndSortingQueries() {
//        System.out.println("\nFind all 3-credit courses");
//        courseRepository.findByCredits(3).forEach(System.out::println);
//
//        System.out.println("\nFind first 4 3-credit courses, sort by credit, then course name");
//        Page<Course> courses = courseRepository.findByCredits(3,
//                PageRequest.of(0, 4, Sort.Direction.ASC, "credits", "name"));
//        courses.forEach(System.out::println);
//
//        System.out.println("\nFind all staff members, sort alphabetically by last name");
//        Sort sortByLastName = new Sort(Sort.Direction.ASC, "member.lastName");
//        staffRepository.findAll(sortByLastName).forEach(System.out::println);
//
//        Page<Staff> members = staffRepository.findAll(PageRequest.of(0, 5, sortByLastName));
//        System.out.println("\nTotal number of staff members=" + members.getTotalElements());
//        System.out.println("Total number of 5-element-pages=" + members.getTotalPages());
//        System.out.println("Find first 5 Staff members, sort alphabetically by last name");
//        members.forEach(System.out::println);
//    }
//
//    /**
//     * Queries using Query by Example
//     *
//     * Departments persisted to H2 in-Memory database at startup.
//     * @see UniversityApplication
//     */
//    @Test
//    public void queryByExample() {
//        System.out.println("\nFind the Department with the name 'Humanities' \n" +
//                departmentRepository.findOne(Example.of(new Department("Humanities", null))));
//
//
//        System.out.println("\nFind Departments with the first name of the chair is 'John'");
//        departmentRepository.findAll(Example.of(
//                new Department(null, new Staff(new Person("John", null))))).forEach(System.out::println);
//
//        System.out.println("\nFind All Departments with the name ending in 'sciences', case insensitive");
//        departmentRepository.findAll(Example.of(new Department("sciences", null),
//                ExampleMatcher.matching().
//                        withIgnoreCase().
//                        withStringMatcher(ExampleMatcher.StringMatcher.ENDING))).forEach(System.out::println);
//
//    }
//
//
//    @Before
//    @After
//    public void printBanner() {
//        System.out.println("*************************************************************************************");
//    }

//    @Test
//    public void mongoQueryMethods() {
//        //Create 2 Mono Staff publishers, data not persisted yet!
//        Mono<Staff> deanJonesMono = staffRepository.save(new Staff(1, new Person("John", "Jones")));
//        Mono<Staff> deanMartinMono = staffRepository.save(new Staff(2, new Person("John", "Martin")));
//
//        Flux<Staff> staffFlux = staffRepository.findAll();
//
//        System.out.println("Staff count found in DB BEFORE subscription: " + staffFlux.count().block());
//
//        //Subscribe with block(), returns entity
//        Staff deanJones = deanJonesMono.block();
//
//        //Subscribe with subscribe(), does not return entity
//        deanMartinMono.subscribe();
//
//        System.out.println("Staff count found in DB AFTER subscription:" + staffFlux.count().block());
//
//        //Query returns a Flux publisher
//        Flux<Staff> deanMartinFindByFlux = staffRepository.findByMemberLastName("Martin");
//        Staff deanMartin = deanMartinFindByFlux.blockFirst();
//
//        //Departments
//
//        //Create an asynchronous publisher that gets the total number of Departments
//        Mono<Long> departmentCountMono = departmentRepository.findAll().count();
//
//        //Create a asynchronouse Flux publisher that persists 3 new Departments
//        Flux<Department> departmentFlux = departmentRepository.saveAll(
//                Arrays.asList(new Department(100, "Humanities", deanJones),
//                        new Department(200, "Natural Sciences", deanMartin),
//                        new Department(300, "Social Sciences", deanJones)));
//
//        System.out.println("Departments found in DB BEFORE subscription: "
//                + departmentCountMono.block());
//
//        //Persist the 3 departments, and block until complete
//        departmentFlux.blockLast();
//
//        System.out.println(("Departments found in DB AFTEr subscription: "
//                + departmentCountMono.block()));
//    }

}
