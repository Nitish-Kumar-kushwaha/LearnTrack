# LearnTrack

Simple CLI Java application to manage students, courses and enrollments in-memory.

This project stores data in-memory using Java collections and demonstrates basic
CRUD-like operations with a tiny service layer and simple domain entities.

## Project structure

- `entity/` — domain classes: `Person`, `Student`, `Course`, `Enrollment`
- `service/` — simple in-memory services (add, find, list)
- `ui/` — `Main` CLI entrypoint
- `util/` — `IdGenerator` (simple ID counters)
- `exception/` — `EntityNotFoundException`

## How to compile and run

From the workspace root (Windows PowerShell):

```powershell
# compile all .java files into bin
javac -d bin $(Get-ChildItem -Recurse -Filter *.java | ForEach-Object FullName)

# run the CLI
java -cp bin ui.Main
```

From Linux / macOS (bash):

```bash
mkdir -p bin
find . -name "*.java" > sources.txt
javac -d bin @sources.txt
java -cp bin ui.Main
```

Notes:
- The project currently uses top-level packages that mirror the folders (`entity`, `service`, `ui`, `util`, `exception`).
- If you prefer the original namespaced package `com.airtribe.learntrack.*`, move the files into `com/airtribe/learntrack/...` directories and update package declarations accordingly.

## Quick usage

Run the program and follow the numbered menu to add students, courses and enroll students into courses.

---
Generated documentation: see `docs/Design_Notes.md` for design rationale and clean-code notes.
# LearnTrack