# Design Notes

1) Why use `ArrayList` instead of array

- Dynamic sizing: `ArrayList` grows automatically; no manual resizing bookkeeping required.
- Convenience APIs: `add()`, `remove()`, `size()`, iteration via enhanced-for, and use with generics (type safety).
- Readability and maintainability: code that manipulates collections is shorter and clearer than manual index management.
- Performance: amortized O(1) for `add()` is suitable for this in-memory demo.

2) Where `static` members are used and why

- `util/IdGenerator.java` uses `private static` counters and `public static` accessor methods (`getNextStudentId()`, `getNextCourseId()`, `getNextEnrollmentId()`).
  - Rationale: ID generation is global application state shared across services and entities; making the counters and methods `static` avoids needing a generator instance to pass around.
  - Note: current implementation is not thread-safe. If the app becomes concurrent, replace counters with `AtomicInteger` or centralize ID generation behind a synchronized service.

3) Where inheritance is used and what it gained

- `entity/Student` extends `entity/Person`.
  - Gains: reuse of common fields (`id`, `firstName`, `lastName`, `email`) and methods (`getDisplayName()`), elimination of duplication, and clearer domain modeling.
  - Polymorphism: code can accept `Person` where appropriate, enabling future subtypes.

4) Clean Code choices applied

- Meaningful names: methods such as `addStudent()`, `getAllStudents()`, `findCourseById()`, `enrollStudent()` make intent explicit.
- Small focused classes: service classes (`StudentService`, `CourseService`, `EnrollmentService`) contain focused responsibilities (add/list/find/modify), keeping methods short and readable.
- Exception clarity: `EntityNotFoundException` expresses the specific error condition rather than using generic exceptions.

Areas to improve (future work):

- The `main()` method in `ui/Main.java` contains the interactive loop and could be refactored into smaller methods (e.g., `handleAddStudent()`, `printMenu()`) to further shorten methods and improve testability.
- Make `IdGenerator` thread-safe if concurrency is needed.

These choices were made to keep the codebase simple and easy to read while demonstrating basic object-oriented design.
